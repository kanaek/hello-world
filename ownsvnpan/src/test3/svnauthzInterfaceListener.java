package test3;

import java.util.*;
//import org.antlr.v4.runtime.misc.OrderedHashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.jetbrains.annotations.NotNull;
import javax.xml.parsers.*;
import java.io.*;
import java.util.Map;

/**
 * Created by user on 2016/3/4.
 */
public class svnauthzInterfaceListener{

    public static class PropertyFileLoader extends svnauthzBaseListener {
        private int countOptU = 0;
        private int countOptA = 0;
        private int countOptP = 0;
        private int countOptR = 0;
        private int countOptD = 0;
        private int countOptRight = 0;
        private String optUType = null;
        private Set<String> Username1 = new HashSet<String>();
        private Set<String> Project = new HashSet<String>();
        private Set<String> Role = new HashSet<String>();
       // Stack<Integer> stack = new Stack<Integer>();
        public void exitOptU(svnauthzParser.OptUContext ctx){
            countOptU++;
            optUType = ctx.getChild(0).toString();

        }
        public void exitOptA(svnauthzParser.OptAContext ctx){
            countOptA++;

        }
        public void exitOptP(svnauthzParser.OptPContext ctx){
            countOptP++;
           // System.out.println(ctx.getChildCount());
           // System.out.println(ctx.getChild(1).toString());
           // Project.add(ctx.getChild(1).toString());

            int i = 1;
            String temp;

            while (i<ctx.getChildCount()) {
                temp = ctx.getChild(i).toString();
                if (! temp.equals(",")){
                    Project.add(temp);
                    //System.out.println(temp);
                }
                i++;
            }
        }
        public void exitOptR(svnauthzParser.OptRContext ctx){
            countOptR++;
            System.out.println(ctx.getChildCount());
            System.out.println(ctx.getChild(1).toString());
        }
        public void exitOptD(svnauthzParser.OptDContext ctx){
            countOptD++;
        }
        public void exitOptRight(svnauthzParser.OptRightContext ctx){
            countOptRight++;
        }
        public void exitUsername1(svnauthzParser.Username1Context ctx) {
            int i = 0;
            String temp;

            while (i<ctx.getChildCount()) {
                temp = ctx.getChild(i).toString();
                if (! temp.equals(",")){
                    Username1.add(temp);
                    //System.out.println(temp);
                }
                i++;
            }
            for(Iterator it=Username1.iterator();it.hasNext();)
            {
                System.out.println(it.next());
            }

        }

        public boolean optJudge() {
            if ((countOptA |countOptU | countOptRight | countOptR | countOptD | countOptP)>1){
                System.out.println("overlapped options");
                return false;
            }else if (countOptU==1 && optUType.equals("-a ") ){        /*判断其他都是0,还没写，想想是否另立一个函数*/
                //当语法分析出错时，经过测试本句语言任会输出，比如svnauthz -qqqq，需要之后利用ErrorNode等方法解决。
                if (countOptR==1 && countOptP==1){
                    //svnauthz -a (员工名字)* -r (角色)* -p (项目名)*
                    System.out.println("svnauthz -a (员工名字)* -r (角色)* -p (项目名)*");
                } else if (countOptR ==1 && countOptP==0){
                    //svnauthz -a (员工名字)* -r (角色)*
                    System.out.println("svnauthz -a (员工名字)* -r (角色)*");
                } else if (countOptR==0 && countOptP==1){
                    //svnauthz -a (员工名字)* -p 项目名
                    System.out.println("svnauthz -a (员工名字)* -p 项目名");
                }
            }else if (countOptU==1 && optUType.equals("-d ")) {
                //System.out.println("-d");
                if (countOptP ==0 && countOptR==0){
                    //svnauthz -d (员工名字)*
                    System.out.println("svnauthz -d (员工名字)*");
                } else if (countOptR ==1 && countOptP ==0) {
                    //svnauthz -d (员工名字)* -r (角色)
                    System.out.println("svnauthz -d (员工名字)* -r (角色)");
                } else if (countOptR == 0 && countOptP == 1) {
                    //svnauthz -d (员工名字)* -p (项目名)*
                    System.out.println("svnauthz -d (员工名字)* -p (项目名)*");
                } else if (countOptP ==1 && countOptR ==1) {
                    //svnauthz -d (员工名字)* -r (角色) -p (项目名)*
                    System.out.println("svnauthz -d (员工名字)* -r (角色) -p (项目名)*");
                }
            } else if (countOptU==1 && optUType.equals("-q ")) {
                if (countOptR == 0 && countOptP ==0 && countOptD==0) {
                    //svnauthz -q (员工名字)
                    System.out.println("svnauthz -q (员工名字)");
                }  else if (countOptR==1 && countOptP==0 && countOptD==0){
                    //svnauthz -q (员工名字) -r
                    //svnauthz -q -r (角色)
                    System.out.println("svnauthz -q -r (角色)//svnauthz -q (员工名字) -r");
                }  else if (countOptR==1 && countOptP==1 && countOptD==0) {
                    //svnauthz -q -r (角色) -p (项目名字)
                    System.out.println("svnauthz -q -r (角色) -p (项目名字)");
                }  else if (countOptR==0 && countOptP==1 && countOptD==0) {
                    //svnauthz -q -p (项目名字)
                    System.out.println("svnauthz -q -p (项目名字)");
                }    /****剩下的都存在-q后空缺的问题，需要修改svnauthz语法规则****/

            } else if (countOptA ==1 && countOptP ==1) {
                //svnauthz -as 标准权限方案描述文件.authz -p 项目名
                System.out.println("svnauthz -as 标准权限方案描述文件.authz -p 项目名");
            } else if (countOptR ==1 && countOptD==1 && countOptP==1 && countOptRight ==1) {
                //svnauthz -r 角色 -dir 文件夹路径 +R -p 项目名
                System.out.println("svnauthz -r 角色 -dir 文件夹路径 +R -p 项目名");
            }

            return true;
        }
        public int optAction() {

            return 1;
        }
    }


    public static void main(String[] args) throws Exception {   /*正式应用的时候用try catch捕捉语法错误，比如line 1:32 mismatched input 'deptleade' expecting Role*/

        ANTLRInputStream input = new ANTLRInputStream(System.in);
        svnauthzLexer lexer = new svnauthzLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        svnauthzParser parser = new svnauthzParser(tokens);
        ParseTree tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        PropertyFileLoader loader = new PropertyFileLoader();
        walker.walk(loader, tree);        // walk parse tree
        loader.optJudge();
        //System.out.println(loader.); // print results
    }

}
