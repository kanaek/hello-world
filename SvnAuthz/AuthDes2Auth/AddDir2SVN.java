package SvnAuthz.AuthDes2Auth;

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

    public void parsedir(String directory, ISVNEditor editor) throws Exception {
        parse.parse_line(directory);
        List<String> list = parse.getDir();
        editor.openRoot(-1);
        Iterator<String> iter = list.iterator();
        for (int j=1; j<list.size(); j++) {
            try {
                editor.addDir(list.get(j), null, -1);
            }
            catch (Exception e) {

            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            editor.closeDir();
        }
        SVNCommitInfo commitInfo = editor.closeEdit();
        parse.clear();
    }
        /*
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
        */

        //parse.sort_Dir();
    //}

    public  SVNRepository login(String url1) throws SVNException{
        SVNURL Url = SVNURL.parseURIEncoded(url1);
        SVNRepository repository = SVNRepositoryFactory.create(Url);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name,password);
        repository.setAuthenticationManager(authManager);
        return repository;
    }

    public void adddir(SVNRepository repository, String directory) throws Exception{
        String currentdir = directory;
        Stack<String> stack = new Stack<String>();
        SVNNodeKind nodeKind;
        ISVNEditor editor;
        int i = 0;
        editor = repository.getCommitEditor("add directory",null);
        parsedir(directory,editor);


    }


    public  void setupLibrary() {
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
    }

    public static void main(String[] args){
        try {
            AddDir2SVN add = new AddDir2SVN("https://user-PC/svn/qq","kr","123");

            add.setupLibrary();
            SVNRepository repository = add.login("https://user-PC/svn/qq");
            add.adddir(repository,"/trunk");
            add.adddir(repository,"/trunk/fff");
            

            //add.adddir(add.login("https://user-PC/svn/qq"),"/hello/hh");
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }


}
