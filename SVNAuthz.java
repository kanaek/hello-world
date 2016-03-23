package SvnAuthz;

import UniveralRepoConf.RepoConfParser;

import java.io.*;

/**
 * Created by kanrun on 2016/3/22.
 */
public class SVNAuthz {
    private RepoConfParser repo;
    private String globalRoleFilePath;
    private File globalRoleFile;

    public SVNAuthz() {
        globalRoleFilePath = "C:\\linuxserver2\\conf\\globalrole.authz";  //本行需要在配置文件中配置
        repo = new RepoConfParser("hello");                                      //本行需要修改
        globalRoleFile = new File(globalRoleFilePath);
        if (globalRoleFile.exists()) {
            //
        } else System.err.print("global role file not exists");
    }

    //prjname不存在，username,rolename存在的情况
    private void addUser(String username,String rolename,String prjname) throws Exception{
        if (prjname==null &&  username !=null && rolename !=null) {
            BufferedReader reader = null;
            String line = null;
            String temp = null;
            File rolefile = new File(globalRoleFilePath);
            if (rolefile.exists()) {
                reader = new BufferedReader(new FileReader(rolefile));
            }
            else {
                System.err.println("global role file not exists");
                return ;   //本行之后更改                                                                                                          ge
            }
            File tempFile = new File(rolefile.getAbsolutePath() + ".tmp");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(" ", "");
                if (line.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*")) {
                    temp = line;
                    if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) && (temp.charAt(temp.length()-1) == ',' || temp.charAt(temp.length()-1) == '=')  ) {
                        temp = temp + username ;
                        pw.println(temp);
                        pw.flush();
                    }
                    else if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) ) {
                        temp = temp + ","  + username ;
                        pw.println(temp);
                        pw.flush();
                    }
                    else {
                        pw.println(line);
                        pw.flush();
                    }

                } else {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            reader.close();
            rolefile.delete();
            tempFile.renameTo(rolefile);

        }

    }

    //获取某个全局角色
    private String getRoleFromGlobal(String username) throws Exception{
        BufferedReader reader = null;
        String line = null;
        String temp = null;
        File rolefile = new File(globalRoleFilePath);
        if (rolefile.exists()) {
            reader = new BufferedReader(new FileReader(rolefile));
        }
        else {
            System.err.println("global role file not exists");
            return null ;   //本行之后更改                                                                                                          ge
        }
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll(" ", "");
            if (line.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*")) {
                if (line.contains(username)) {
                    String rolename = temp.substring(0,temp.indexOf("="));
                    reader.close();
                    return rolename;
                }


            }
        }

        reader.close();
        return null;

    }
    //prjname,rolename,username都存在的情况
    private void addPrjUser(String username, String rolename, String prjname) throws Exception{

        if (username !=null && rolename !=null && prjname !=null) {
            String[] prjlocation = repo.getPrjLoc(prjname);
            String prjpath = prjlocation[1];
            if (prjpath != null) {
                BufferedReader reader = null;
                String line = null;
                String temp = null;
                File rolefile = new File(prjpath);
                if (rolefile.exists()) {
                    reader = new BufferedReader(new FileReader(rolefile));
                }
                else {
                    System.err.println("global role file not exists");
                    return ;   //本行之后更改
                }
                File tempFile = new File(rolefile.getAbsolutePath() + ".tmp");
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                while ((line = reader.readLine()) != null) {
                    line = line.replaceAll(" ","");
                    if (line.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*")) {
                        temp = line;
                        if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) && (temp.charAt(temp.length()-1) == ',' || temp.charAt(temp.length()-1) == '=')  ) {
                            temp = temp + username ;
                            pw.println(temp);
                            pw.flush();
                        }
                        else if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) ) {
                            temp = temp + ","  + username ;
                            pw.println(temp);
                            pw.flush();
                        }
                        else {
                            pw.println(line);
                            pw.flush();
                        }

                    } else {
                        pw.println(line);
                        pw.flush();
                    }
                }
                pw.close();
                reader.close();
                rolefile.delete();
                tempFile.renameTo(rolefile);
            }
        }
    }

    //角色未被提及的，需要验证测试
    private void addUserNoRoleMentioned(String username,String rolename, String prjname) throws Exception{
        if (rolename == null && username != null && prjname !=null) {
            String[] prjlocation = repo.getPrjLoc(prjname);
            String prjpath = prjlocation[1];
            rolename = getRoleFromGlobal(username);
            if (rolename == null) {
                System.err.println("role not exists");
                return;
            }
            BufferedReader reader = null;
            String line = null;
            String temp = null;
            File rolefile = new File(prjpath);
            if (rolefile.exists()) {
                reader = new BufferedReader(new FileReader(rolefile));
            }
            else {
                System.err.println("global role file not exists");
                return ;   //本行之后更改
            }
            File tempFile = new File(rolefile.getAbsolutePath() + ".tmp");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(" ","");
                if (line.matches("[a-zA-Z_]+=([a-z.0-9]+(,[a-z.0-9]+)*,?)*")) {
                    temp = line;
                    if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) && (temp.charAt(temp.length()-1) == ',' || temp.charAt(temp.length()-1) == '=')  ) {
                        temp = temp + username ;
                        pw.println(temp);
                        pw.flush();
                    }
                    else if (rolename.equals(temp.substring(0,temp.indexOf("="))) && ! temp.contains(username) ) {
                        temp = temp + ","  + username ;
                        pw.println(temp);
                        pw.flush();
                    }
                    else {
                        pw.println(line);
                        pw.flush();
                    }

                } else {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            reader.close();
            rolefile.delete();
            tempFile.renameTo(rolefile);
            while ((line = reader.readLine()) != null) {
                String others = (line.split("="))[1];
            }

        }
    }
    //--------------------------------------------------------------------------------------------------------------------------//
    /*
    以下为用于删除的函数
     */
    public void deleteUser(String username,String rolename,String prjname) throws Exception{
        if (username !=null && rolename != null && prjname !=null) {
            String prjpath = (repo.getPrjLoc(prjname))[1];
            BufferedReader reader = null;
            String line = null;
            String temp = null;
            File rolefile = new File(prjpath);
            if (rolefile.exists()) {
                reader = new BufferedReader(new FileReader(rolefile));
            }
            else {
                System.err.println("global role file not exists");
                return ;   //本行之后更改
            }
            File tempFile = new File(rolefile.getAbsolutePath() + ".tmp");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        }
    }

    public static void main(String[] args) throws Exception{
        SVNAuthz auth = new SVNAuthz();
        //String temp = "hello,";
        //System.out.println(temp.charAt(temp.length()-1));
        auth.addPrjUser("kr.hu","RW__ir__sirm__zq__ht","ecsvn/xn_jj_rbzc_web");
        //auth.addUser("kr","deptmanager",null);
    }
}