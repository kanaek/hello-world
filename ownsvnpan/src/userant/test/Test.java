package userant.test;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import test.test.ExprLexer;
import test.test.ExprParser;

/**
 * Created by user on 2016/3/18.
 */
public class Test extends svnuserBaseVisitor<String> {
    @Override public String visitSvnuser(svnuserParser.SvnuserContext ctx) {
        System.out.println("already visit svnuser string");
        return "hello";
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
        Test test = new Test();

        test.visit(tree);
    }
}
