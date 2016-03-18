package test.test;

/**
 * Created by user on 2016/3/3.
 */
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Test {
    public static void main(String[] args) throws Exception{
        // create a CharStream that reads from standard input
        System.out.println("shuru");
        ANTLRInputStream input = new ANTLRInputStream(System.in);
// create a lexer that feeds off of input CharStream
        ExprLexer lexer = new ExprLexer(input);
// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
// create a parser that feeds off the tokens buffer
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.init(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
