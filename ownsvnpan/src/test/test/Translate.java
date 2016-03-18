package test.test;

/**
 * Created by user on 2016/3/3.
 */
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Translate {
    public static void main(String[] args) throws Exception{
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.init();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ShortToUnicodeString(),tree);
        System.out.println();

    }
}
