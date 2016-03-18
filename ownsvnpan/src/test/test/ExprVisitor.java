// Generated from C:/git/giy/ownsvnpan/src/test\Expr.g4 by ANTLR 4.5.1
package test.test;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(ExprParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExprParser.ValueContext ctx);
}