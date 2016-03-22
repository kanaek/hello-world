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
}
