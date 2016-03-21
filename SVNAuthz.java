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

}
