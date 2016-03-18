package SvnUser;
import UniveralRepoConf.RepoConfParser;

import java.io.*;

/**
 * Created by user on 2016/3/16.
 */
public class Htpasswd {
    private String CmdPath;
    private String PasswdFilePath;
    private RepoConfParser repo;

    public Htpasswd(String PasswdFilePath) {
        File passwdFile = new File(PasswdFilePath);
        if (passwdFile.isFile()) {
            this.PasswdFilePath = PasswdFilePath;
        } else {
            this.PasswdFilePath = "C:\\linuxserver\\conf\\svn.passwd"; //本行需要写在配置文件中
        }
    }
    public Htpasswd() {
        this.PasswdFilePath = "C:\\linuxserver\\conf\\svn.passwd"; //本行需要写在配置文件中
        repo = new RepoConfParser("hello");
    }

    //删除用户
    public boolean deleteUser(String username) {

        return false;
    }

    //增加用户，如果用户名重复则报错
    public void addUser(String username, String passwd) throws Exception{
        BufferedReader reader = null;
        String line = null;
        String tempname = null;
        String cmd = "htpasswd -b ";
        boolean userexist = false;
        try {
            File file = new File(PasswdFilePath);
            if (file.isFile()) {
                reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.matches(".*:.*")) {
                        tempname = line.substring(0,line.indexOf(":"));
                        //System.out.println(username);
                        //System.out.println(Username.get(0));
                        //i++;
                        if (tempname.equals(username)) {
                            System.err.println("user already exist");
                            reader.close();
                            return;
                        }
                    }
                }
                reader.close();
                cmd = cmd + PasswdFilePath + " " + username + " " + passwd;
                Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
                try {
                    Process p = run.exec(cmd);
                    System.out.println("add user successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    //修改已存在的用户的密码
    public void reviseUserPasswd(String username, String passwd) throws Exception{
        BufferedReader reader = null;
        String line = null;
        String tempname = null;
        String cmd = "htpasswd -b ";
        boolean userexist = false;
        try {
            File file = new File(PasswdFilePath);
            if (file.isFile()) {
                reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.matches(".*:.*")) {
                        tempname = line.substring(0,line.indexOf(":"));
                        //System.out.println(username);
                        //System.out.println(Username.get(0));
                        //i++;
                        if (tempname.equals(username)) {

                            //reader.close();
                            userexist = true;
                            break;
                        }
                    }
                }
                reader.close();
                if (userexist == true) {
                    cmd = cmd + PasswdFilePath + " " + username + " " + passwd;
                    Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
                    try {
                        Process p = run.exec(cmd);
                        System.out.println("revise user password successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else System.err.println("user not exists");

            }

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    //查询某位用户是否存在
    public boolean queryUser(String username) throws Exception{
        BufferedReader reader = null;
        String line = null;
        String tempname = null;
        String cmd = "htpasswd -b ";
        boolean userexist = false;
        try {
            File file = new File(PasswdFilePath);
            if (file.isFile()) {
                reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.matches(".*:.*")) {
                        tempname = line.substring(0,line.indexOf(":"));
                        //System.out.println(username);
                        //System.out.println(Username.get(0));
                        //i++;
                        if (tempname.equals(username)) {

                            //reader.close();
                            userexist = true;
                            break;
                        }
                    }
                }
                reader.close();

            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return userexist;
    }

    public static void main(String[] args) {
        /*
        String cmd = "htpasswd -b C:\\linuxserver\\conf\\svn.passwd kr 123" ;
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);
            OutputStream os = p.getOutputStream();
            InputStreamReader input =new InputStreamReader(p.getInputStream(),"GBK");
            BufferedReader inBr = new BufferedReader(input);
            String lineStr;
            os.write(cmd.getBytes());
            os.flush();
            os.close();
            while ((lineStr = inBr.readLine()) != null)
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
            //检查命令是否执行失败。
            if (p.waitFor() != 0) {
                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }


            inBr.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    } */
      Htpasswd htpasswd = new Htpasswd();
        try {
            htpasswd.addUser("qqq","123");
            //htpasswd.reviseUserPasswd("qqq","125");
            System.out.println("fff.wang user exist?"+htpasswd.queryUser("fff.wang"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
