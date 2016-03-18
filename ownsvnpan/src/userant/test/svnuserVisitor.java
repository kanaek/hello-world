// Generated from C:/git/giy/ownsvnpan/src/test\svnuser.g4 by ANTLR 4.5.1
package userant.test;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link svnuserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface svnuserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link svnuserParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(svnuserParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#orders}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrders(svnuserParser.OrdersContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#svnuser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSvnuser(svnuserParser.SvnuserContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#opts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpts(svnuserParser.OptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#optA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptA(svnuserParser.OptAContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#optD}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptD(svnuserParser.OptDContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#optRP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptRP(svnuserParser.OptRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link svnuserParser#optQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptQ(svnuserParser.OptQContext ctx);
}