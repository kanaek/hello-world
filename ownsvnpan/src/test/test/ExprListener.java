// Generated from C:/git/giy/ownsvnpan/src/test\Expr.g4 by ANTLR 4.5.1
package test.test;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(ExprParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(ExprParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ExprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ExprParser.ValueContext ctx);
}