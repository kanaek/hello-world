package AuthDes2Auth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
/**
 * Created by user on 2016/3/8.
 */
public class AddDir2SVN {
    private String url = "https://user-PC/svn/qq";
    private String name = "kr";
    private String password = "123";
    //private Stack<String> stack;
    private String filePath = "svn.ico";
    public Parse_Dir parse;

    public AddDir2SVN(String url, String name, String password) {
        this.url = url;
        this.name = name;
        this.password = password;
        parse = new Parse_Dir();
        //stack = new Stack<String>();

    }

    public void parsedir() {
        parse.parse_line("/trunk/doc/ppp/10.项目周报" );
        parse.parse_line("/trunk/doc/09.会议纪要");
        parse.parse_line("/trunk/doc/08.部署");
        parse.parse_line("/trunk/doc/04.数据导入");
        parse.parse_line("/trunk/doc/00.项目计划");
        parse.parse_line("/trunk/doc/00.项目计划");
        parse.parse_line("/line2");
        parse.parse_line("/trunk/d/");
        parse.parse_line("/trunk/d");
        parse.parse_line("/trunk/doc/01.用户需求");
        parse.parse_line("/d/d");
        parse.parse_line("/d/d/d");


        parse.sort_Dir();
    }

    private  SVNRepository login(String url1) throws SVNException{
        SVNURL Url = SVNURL.parseURIEncoded(url1);
        SVNRepository repository = SVNRepositoryFactory.create(Url);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name,password);
        repository.setAuthenticationManager(authManager);
        return repository;
    }

    public void adddir(SVNRepository repository, String directory) throws SVNException{
        String currentdir = directory;
        Stack<String> stack = new Stack<String>();
        SVNNodeKind nodeKind;
        ISVNEditor editor;
        int i = 0;
        nodeKind = repository.checkPath(currentdir,-1);
        if (nodeKind == SVNNodeKind.DIR) return;
        while (true) {
            nodeKind = repository.checkPath(currentdir,-1);
            if (nodeKind == SVNNodeKind.NONE && currentdir.lastIndexOf("/") != 0 ) {
                //currentdir.substring(0,currentdir.lastIndexOf("/"));
                stack.push(currentdir);
                currentdir = currentdir.substring(0,currentdir.lastIndexOf("/"));

            } else if (nodeKind == SVNNodeKind.NONE && currentdir.lastIndexOf("/") == 0) {
                    //stack.push(currentdir);
                    SVNRepository repo2 = login(url);
                    String add = currentdir.substring(currentdir.lastIndexOf("/")+1,currentdir.length());
                    editor = repo2.getCommitEditor("add directory",null);
                    editor.openRoot(-1);
                    editor.addDir(add,null,-1);
                    editor.closeDir();
                    SVNCommitInfo commitInfo = editor.closeEdit();

                    while (!stack.isEmpty()) {

                        SVNRepository repo3 = login(url+currentdir);
                        currentdir = stack.pop();
                        String add2 = currentdir.substring(currentdir.lastIndexOf("/")+1,currentdir.length());
                        editor = repo3.getCommitEditor("add directory",null);
                        editor.openRoot(-1);
                        editor.addDir(add2,null,-1);
                        editor.closeDir();
                        SVNCommitInfo commitInfo2 = editor.closeEdit();

                    }
                    break;

            }
            else if (nodeKind == SVNNodeKind.DIR ) {
                SVNRepository repo2 = login(url+currentdir);
                currentdir = stack.pop();
                String add = currentdir.substring(currentdir.lastIndexOf("/")+1,currentdir.length());
                editor = repo2.getCommitEditor("add directory trunk,branches,tags",null);
                editor.openRoot(-1);
                editor.addDir(add,null,-1);
                editor.closeDir();
                SVNCommitInfo commitInfo = editor.closeEdit();
                while (!stack.isEmpty()) {

                    SVNRepository repo3 = login(url+currentdir);
                    currentdir = stack.pop();
                    String add2 = currentdir.substring(currentdir.lastIndexOf("/")+1,currentdir.length());
                    editor = repo3.getCommitEditor("add directory",null);
                    editor.openRoot(-1);
                    editor.addDir(add2,null,-1);
                    editor.closeDir();
                    SVNCommitInfo commitInfo2 = editor.closeEdit();

                }
                break;

            }
            i++;
        }


    }


    private  void setupLibrary() {
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
    }

    public static void main(String[] args){
        try {
            AddDir2SVN add = new AddDir2SVN("https://user-PC/svn/qq","kr","123");
            add.parsedir();
            Iterator<Dir> iter = add.parse.getDir3().iterator();

            add.setupLibrary();
            Date date  = new Date();
            while (iter.hasNext()) {
                add.adddir(add.login("https://user-PC/svn/qq"), iter.next().dir);
            }
            Date date2 = new Date();
            System.out.println(date2.getTime()-date.getTime());

            //add.adddir(add.login("https://user-PC/svn/qq"),"/hello/hh");
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }


}
