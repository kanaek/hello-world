package SvnAuthz.AuthDes2Auth;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016/3/10
 * 本文件用于将项目权限描述文件转换成真正的项目版本库的权限文件.
 */
public class AuthDes2Auth {

    private File originFile;
    private File targetFile;
    private Parse_Dir parse;

    public AuthDes2Auth(String originfilepath, String targetfilepath) {
        originFile = new File(originfilepath);
        targetFile = new File(targetfilepath);
        parse = new Parse_Dir();
    }

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\git\\giy\\ownsvnpan\\src\\SIRM权限方案.authz");
        File cfile = new File("SIRM.authz");
        if (cfile.exists()) {
            System.err.println("file exists");
        } else {
            cfile.createNewFile();
        }
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(cfile),"gbk");
        BufferedWriter bw = new BufferedWriter(out);

        String temp = null;
        String tmpdir = null;
        boolean tq = false;

        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"gbk");   //本行可能在linux中需要修改
        BufferedReader br=new BufferedReader(read);

       // if (temp.equals("")) System.out.println("he"); //
        //temp = br.readLine();
        /*
        try {
            AddDir2SVN add = new AddDir2SVN("https://user-PC/svn/qq","kr","123");
            add.setupLibrary();
            SVNRepository repository = add.login("https://user-PC/svn/qq");
            add.adddir(repository,temp);

        }  catch (Exception e) {
            e.printStackTrace();
        } */
        /*
        HashMap<String,HashSet<String>> map = new HashMap<String, HashSet<String>>();
        HashSet<String> set = new  HashSet<String>();
        set.add("中国");
        set.add("b");
        map.put("1",set);
        HashSet<String> tmp = map.get("1");
        tmp.add("c");
        tmp.add("d");
        map.put("1",tmp);
        HashSet<String> tmp2 = map.get("1");
        Iterator<String> iterator = tmp2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        } */

        HashMap<String,HashSet<String>> rolemap = new HashMap<String, HashSet<String>>();
        int count = 0;
        int count1 = 0;
        int judge_state = 0; //0表示开始，1表示读入[role]，2表示读入dept=kr,hu....，3表示读入[directory],4表示读入需创建的文件夹,5表示读入[/文件夹路径],
        //6表示读入@dept=rw，可转至5
        boolean errorstate = false;
        Parse_Dir parse = new Parse_Dir();

        while ((temp= br.readLine()) !=null) {
            temp = temp.replace(" ","");
            temp = temp.replaceAll("\t","");
            if (temp.matches("\\[role\\]") && judge_state == 0) {
                System.out.println("role");
                out.write("[role]\r\n");
                judge_state = 1;
            }
            else if (temp.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*") && judge_state ==1 ) {

                out.write(temp+"\r\n");
                /*
                String[] temp2 = temp.split("=");
                String temp3 = temp2[1];
                String[] temp4 = temp3.split(",");
                HashSet<String> temp5 = new HashSet<String>();
                for (String item : temp4) {
                     temp5.add(item);
                }
                rolemap.put(temp2[0],temp5);
                System.out.println(temp2[0]);
                */
                System.out.println("hh");
            }
            else if (temp.matches("\\[directory\\]") && judge_state == 1 ) {
                System.out.println("dir");
                judge_state = 2;
            }
            else if (temp.matches("(/[a-zA-Z._0-9\u4E00-\u9FFF]+)(/[a-zA-Z._0-9\u4E00-\u9FFF]+)*/?") && judge_state == 2) {
                parse.parse_line(temp);
                parse.getTree().Add_child(parse.getDir());
                parse.clear();
                System.out.println(count++);
            }
            else if (temp.matches("\\[(/[a-zA-Z._0-9\u4E00-\u9FFF]+)(/[a-zA-Z._0-9\u4E00-\u9FFF]+)*/?\\]") && (judge_state ==2 || judge_state ==4 )) {
                tmpdir = temp.substring(1,temp.length()-1);
                parse.clear();
                parse.parse_line(tmpdir);
                tq = parse.getTree().Search_child(parse.getDir());
                //parse.clear();
                System.out.println("qq:"+tmpdir+tq);
                parse.clear();
                judge_state = 3;
            }
            else if (temp.matches("@[a-z]+=(r|rw)*") && (judge_state == 3 || judge_state ==4) ) {

                String role = temp.substring(1,temp.indexOf("="));
                String auth = temp.substring(temp.indexOf("=")+1,temp.length());

                if (tq) {
                    parse.parse_line(tmpdir);
                    parse.getTree().add_ChildAuth(parse.getDir(), role,auth);
                    parse.clear();
                }

                System.out.println(auth);
                judge_state = 4;
            }
            else if (temp.equals("")){
                //errorstate = true;
                System.out.println("nothing");
            } else {
                errorstate = true;
                System.out.println("error line :"+temp);
            }
        }

        if (errorstate == false) {
            //System.out.println(parse.getTree().iteratorTree(parse.getTree().getRoot()));
            //以下为在svn服务器端创建目录
            AddDir2SVN add = new AddDir2SVN("https://user-PC/svn/qq","kr","123");
            add.setupLibrary();
            SVNRepository repository = add.login("https://user-PC/svn/qq");
            ISVNEditor editor;
            editor = repository.getCommitEditor("add directory",null);
            editor.openRoot(-1);
            parse.getTree().iteratorCreateDir(parse.getTree().getRoot(),editor);
            SVNCommitInfo commitInfo = editor.closeEdit();
            /////////////////////////////////////////////////////////////////////////

        }

        System.out.println("-----------------------------------");
        //System.out.println(parse.getTree().iteratorTree(parse.getTree().getRoot()));
        System.out.println("-----------------------------------");

        parse.getTree().iteratorTreeAuth(parse.getTree().getRoot(),out,parse.getTree().getRoot().getData().getNodeId(),"qq:");
        out.close();

    }
}
