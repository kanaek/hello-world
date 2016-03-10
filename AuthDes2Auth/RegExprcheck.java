package AuthDes2Auth;
import org.tmatesoft.svn.core.io.SVNRepository;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016/3/10.
 */
public class RegExprcheck {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\git\\giy\\ownsvnpan\\src\\SIRM权限方案.authz");
        String temp = null;

        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"gbk");   //本行可能在linux中需要修改
        BufferedReader br=new BufferedReader(read);

       // if (temp.equals("")) System.out.println("he"); //
        temp = br.readLine();
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



        while ((temp= br.readLine()) !=null) {
            //System.out.println(temp);
            if ()temp.matches("\\[groups\\]");
            else System.out.println(temp);
        }

    }
}
