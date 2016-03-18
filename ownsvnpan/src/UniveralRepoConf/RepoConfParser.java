package UniveralRepoConf;

import java.io.File;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016/3/16
 * 本文件用于解析uberSVN下50-repositories.conf文件，提供查询项目名，项目地址，增加新项目等功能，删除现存项目等功能。完成
 * 相关功能修改后，需要重启apache http服务器.
 * 注：经过测试后发现，linux下和windows下文本换行符不同对读取一行没有影响
 */
public class RepoConfParser {
    private File RepoConfFile;
    private String filepath;
    private String SVNPath;
    private String AuthzSVNAccessFile;

    public RepoConfParser(String repoconffile) {
        filepath = "C:\\linuxserver\\conf\\conf.d\\50-repositories.conf.bak"; //本行需要写在配置文件中
        RepoConfFile = new File(filepath);
    }

    //查找某项目是否存在
    public boolean isPrjExist(String projectname) throws Exception{
        BufferedReader reader = null;
        String line;
            if (RepoConfFile.exists()) {
                reader = new BufferedReader(new FileReader(RepoConfFile));
            }
            else {
                System.err.println("文件不存在");
                return false;
            }

        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            if (line.contains("<Location /"+projectname+">")) {
                System.out.println("contains " + projectname);
                reader.close();
                return true;
            }

        }
        reader.close();
        return false;

    }

    //获取输入的项目名所在地址和项目权限文件所在的地址
    public String[] getPrjLoc(String projectname) throws Exception{
        BufferedReader reader = null;
        String line;
        boolean permission = false;
        if (RepoConfFile.exists()) {
            reader = new BufferedReader(new FileReader(RepoConfFile));
        }
        else {
            System.err.println("文件不存在");
            return null ;
        }

        while ((line = reader.readLine()) != null) {
            if (line.contains("<Location /"+projectname+">")) {
                permission = true;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("SVNPath")) {
                        System.out.println(line);
                        SVNPath = line.substring(line.indexOf('"')+1,line.lastIndexOf('"'));
                        System.out.println(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));

                    }

                    else if (line.contains("AuthzSVNAccessFile")) {
                        System.out.println(line);
                        AuthzSVNAccessFile = line.substring(line.indexOf('"')+1,line.lastIndexOf('"'));
                        System.out.println(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
                        break;
                    }
                }
                break;
            }

        }
        String [] temp = new String[2];
        temp[0] = SVNPath;
        temp[1] = AuthzSVNAccessFile;

        return temp;
    }

    //在50-repositories.conf文件中新增一个项目
    public boolean addPrj(String projectname) throws Exception{
        BufferedReader reader = null;
        String line = null;
        String temp = null;
        boolean permission = false;
        if (RepoConfFile.exists()) {
            reader = new BufferedReader(new FileReader(RepoConfFile));
        }
        else {
            System.err.println("文件不存在");
            return false;
        }

        File tempFile = new File(RepoConfFile.getAbsolutePath() + ".tmp");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        while ((line = reader.readLine()) != null) {
            if ( !line.contains("<Location /"+projectname+">")) {
                if ( line.contains("CustomLog")) {
                    temp = line;
                    pw.println("  <Location /" + projectname + ">");
                    pw.println("    DAV svn");
                    pw.println("    SVNPath \"/opt/ubersvn/repositories/ecsvn/xn_jj_rbzc_web\"");
                    pw.println("    AuthType Basic");
                    pw.println("    AuthName \"Subversion Repository\"");
                    pw.println("    Require valid-user");
                    pw.println("    AuthUserFile \"/opt/ubersvn/conf/svn.passwd\"");
                    pw.println("    AuthzSVNAccessFile \"/opt/ubersvn/conf/alternative_svn.authz\""); //本行应用是需要做修改
                    pw.println("    Order deny,allow");
                    pw.println("    Allow from all");
                    pw.println("    SVNAutoversioning On");
                    pw.println("  </Location>");
                    pw.println(line);
                    pw.flush();
                }  else {
                    pw.println(line);
                    pw.flush();
                }
            } else {
                System.err.println("project already exists");
                pw.close();
                reader.close();
                return false;
            }
        }


        pw.close();
        reader.close();
        return true;

    }
    //删除某个项目，慎用
    public boolean deletePrj(String projectname) throws Exception {
        boolean prjExist = false;
        BufferedReader reader = null;
        String line = null;
        String temp = null;
        boolean permission = false;
        if (RepoConfFile.exists()) {
            reader = new BufferedReader(new FileReader(RepoConfFile));
        }
        else {
            System.err.println("文件不存在");
            return false;
        }

        File tempFile = new File(RepoConfFile.getAbsolutePath() + ".tmp");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        while ((line = reader.readLine()) != null) {
            if ( !line.contains("<Location /"+projectname+">")) {
                pw.println(line);
                pw.flush();
            } else {
                prjExist  = true;
                while ((line = reader.readLine()) != null) {
                    if ( line.contains("</Location>")) break;
                }
            }
        }
        pw.close();
        reader.close();
        return prjExist;
    }

    //返回所有项目的权限文件的地址,返回HashMap
    public HashMap<String,String> getAllPrjLocMap() throws Exception{
        BufferedReader reader = null;
        String tmpPrjname = null;
        String tmpPrjpath = null;
        String line = null;
        HashMap<String,String> prjMap = new HashMap<String, String>();

        boolean permission = false;
        if (RepoConfFile.exists()) {
            reader = new BufferedReader(new FileReader(RepoConfFile));
        }
        else {
            System.err.println("文件不存在");
            return null ;
        }

        while ((line = reader.readLine()) != null) {
            if (line.contains("<Location /")) {
                System.out.println(line.substring(line.indexOf("/"),line.length()-1));
                tmpPrjname = line.substring(line.indexOf("/"),line.length());
                permission = true;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("AuthzSVNAccessFile")) {

                        tmpPrjpath = line.substring(line.indexOf('"')+1,line.lastIndexOf('"'));
                        System.out.println(tmpPrjpath);
                        prjMap.put(tmpPrjname,tmpPrjpath);
                        break;
                    }
                }
            }

        }

        return prjMap;
    }

    /**
     * Exit a parse tree produced by
     *  the parse tree
     */
    //返回所有项目的权限文件的地址,返回HashSet
    public Set<String> getAllPrjLocSet() throws Exception{
        BufferedReader reader = null;
        String tmpPrjname = null;
        String tmpPrjpath = null;
        String line = null;
        Set<String> prjSet = new HashSet<String>();

        boolean permission = false;
        if (RepoConfFile.exists()) {
            reader = new BufferedReader(new FileReader(RepoConfFile));
        }
        else {
            System.err.println("文件不存在");
            return null ;
        }

        while ((line = reader.readLine()) != null) {
            if (line.contains("<Location /")) {
                //System.out.println(line.substring(line.indexOf("/"),line.length()-1));
                tmpPrjname = line.substring(line.indexOf("/"),line.length());
                permission = true;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("AuthzSVNAccessFile")) {

                        tmpPrjpath = line.substring(line.indexOf('"')+1,line.lastIndexOf('"'));
                        //System.out.println(tmpPrjpath);
                        prjSet.add(tmpPrjpath);
                        break;
                    }
                }
            }

        }

        return prjSet;
    }

    public static void main(String[] args) throws Exception{
        RepoConfParser repo = new RepoConfParser("hello");
        boolean qq = repo.isPrjExist("ecsvn/doc_lyhe");
        repo.getPrjLoc("sirmsvn/sxn_jj_stmg_sirm");
        System.out.println("---------------------------------");
        Set<String> set = repo.getAllPrjLocSet();
        Iterator<String> hh = set.iterator();
        while (hh.hasNext()) {
            System.out.println(hh.next());
        }
        //System.out.println(repo.deletePrj("ecsvn/xn_jj_rbzc_web"));
    }
}
