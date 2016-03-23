<<<<<<< HEAD
package SvnAuthz;

import UniveralRepoConf.RepoConfParser;
import java.io.*;
/**
 * Created by user on 2016/3/21
 * 本文件用于执行.
 */
public class SVNAuthz {
    private RepoConfParser repo;
    private File globalRoleFile;
    private String globalRoleFilePath;
    public SVNAuthz(String globalRoleFilePath) {
        repo = new RepoConfParser("hello");
        this.globalRoleFilePath = globalRoleFilePath;
        globalRoleFile = new File(this.globalRoleFilePath);
        if (globalRoleFile.exists()) {
            //
        } else System.err.println("global role file not exists");
    }
    public void addRole(String username,String rolename, String prjname) throws Exception{
        if (prjname == null && rolename != null && username != null) {
            //打开globalRoleFile,查找角色，查找用户
        }

    }

    public static void main(String[] args) throws Exception{
        SVNAuthz auth = new SVNAuthz("C:\\linuxserver2\\conf\\globalrole.authz");
        auth.addRole(null,null,null);
    }

=======
package SvnAuthz.AuthDes2Auth;

import UniveralRepoConf.RepoConfParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by kanrun on 2016/3/22.
 */
public class SVNAuthz {
    private RepoConfParser repo;
    private String globalRoleFilePath;
    private File globalRoleFile;
    public SVNAuthz() {
        globalRoleFilePath = "D:\\linuxserver2\\role.authz";
        globalRoleFile = new File(globalRoleFilePath);
        if (globalRoleFile.exists()) {
            //
        } else System.err.print("file not exists");
    }
    private void addUser(String username,String rolename,String prjname) throws Exception{
        if (prjname==null &&  username !=null && rolename !=null) {
            BufferedReader reader = null;
            String line = null;
            String temp = null;
            File tempFile = new File(globalRoleFile.getAbsolutePath() + ".tmp");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            while ((line = reader.readLine()) != null) {
                if (line.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*")) {
                    temp = line;
                    if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username)) {
                        temp = temp + username + ",";
                        pw.println(temp);
                        pw.flush();
                    }
                    else {
                        pw.println(line);
                        pw.flush();
                    }
                }
            }
        }

    }
>>>>>>> 64011106f6199215deb8e5a1c66e3ecd14a60f45
}
