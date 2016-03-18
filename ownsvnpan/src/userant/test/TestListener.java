package userant.test;

import SvnUser.Htpasswd;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by user on 2016/3/18
 * 本文件用于测试svnuser命令的使用.
 */
public class TestListener extends svnuserBaseListener {
      private boolean existerror;
      private String username;
      private String passwd;
      private Htpasswd htpasswd;
      private int state;

    public TestListener() {
        existerror = false;
        username = null;
        passwd = null;
        htpasswd = new Htpasswd();
        state = 0;
    }

    @Override public void visitErrorNode(ErrorNode node) {
        System.out.println("svnuser command exists error");
        existerror = true;
    }

    @Override public void exitOptA(svnuserParser.OptAContext ctx) {
        username = ctx.getChild(1).toString();
        passwd = ctx.getChild(2).toString();
        System.out.println("OptA;"+username+" "+passwd);
        state = 1;

    }
    @Override public void enterOptRP(svnuserParser.OptRPContext ctx) {
        username = ctx.getChild(1).toString();
        passwd = ctx.getChild(2).toString();
        System.out.println("OptRP"+username+" "+passwd);
        state = 2;

    }

    @Override public void exitOptQ(svnuserParser.OptQContext ctx) {
        int number = ctx.getChildCount();
        System.out.println("childcount:" +number);
        if (number==2) {
            username = ctx.getChild(1).toString();
            System.out.println("username:"+username);
            state = 3;

        } else if (number ==1) {
            state = 4;
        }
    }

    @Override public void exitOptD(svnuserParser.OptDContext ctx) {
        int number = ctx.getChildCount();
        Set<String> userset = new HashSet<String>();
        if (number>11) {
            state = -1;
            return;
        } else {
            for (int i=1; i<number; i++) {
                userset.add(ctx.getChild(i).toString());
            }
            state = 5;
        }

    }

    public void chooseHtpasswdFuc() throws Exception{
        if ( !existerror ) {
            switch (state) {
                case -1: System.err.println("over ten users");
                          System.out.println();
                         break;
                case 1: htpasswd.addUser(username,passwd);
                         break;
                case 2: htpasswd.reviseUserPasswd(username,passwd);
                         break;
                case 3: htpasswd.queryUser(username);
                         break;
                case 4://查询所有用户，暂时没有
                        break;
                case 5://删除用户，暂时没有
            }
        }
    }


    public static void main(String[] args) throws Exception{
        System.out.println("shuru");
        ANTLRInputStream input = new ANTLRInputStream(System.in);
// create a lexer that feeds off of input CharStream
        svnuserLexer lexer = new svnuserLexer(input);
// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
// create a parser that feeds off the tokens buffer
        svnuserParser parser = new svnuserParser(tokens);
        ParseTree tree = parser.prog(); // begin parsing at init rule
        ParseTreeWalker walker = new ParseTreeWalker();

        TestListener test = new TestListener();
        walker.walk(test,tree);
        test.chooseHtpasswdFuc();

    }
}
