// Generated from C:/git/giy/ownsvnpan/src/test\svnauthz.g4 by ANTLR 4.5.1
package test3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link svnauthzParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface svnauthzVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(svnauthzParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#orders}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrders(svnauthzParser.OrdersContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#svnauthz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSvnauthz(svnauthzParser.SvnauthzContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#opts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpts(svnauthzParser.OptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optU}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptU(svnauthzParser.OptUContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#username1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsername1(svnauthzParser.Username1Context ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptA(svnauthzParser.OptAContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptP(svnauthzParser.OptPContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptR(svnauthzParser.OptRContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optD}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptD(svnauthzParser.OptDContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnauthzParser#optRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptRight(svnauthzParser.OptRightContext ctx);
}