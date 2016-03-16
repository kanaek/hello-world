package SvnUser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by user on 2016/3/16.
 */
public class Htpasswd {
    private String CmdPath;

    public static void main(String[] args) {
        String cmd = "htpasswd -b F:\\collabnet\\data\\conf\\svn.passwd hahahaha qq" ;
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);
            OutputStream os = p.getOutputStream();
            InputStreamReader input =new InputStreamReader(p.getInputStream(),"GBK");
            BufferedReader inBr = new BufferedReader(input);
            String lineStr;
            /*
            os.write(cmd.getBytes());
            os.flush();
            os.close(); */
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
    }
}
