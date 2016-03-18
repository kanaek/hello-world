// Generated from C:/git/giy/ownsvnpan/src/test\svnuser.g4 by ANTLR 4.5.1
package userant.test;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link svnuserParser}.
 */
public interface svnuserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link svnuserParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(svnuserParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(svnuserParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#orders}.
	 * @param ctx the parse tree
	 */
	void enterOrders(svnuserParser.OrdersContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#orders}.
	 * @param ctx the parse tree
	 */
	void exitOrders(svnuserParser.OrdersContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#svnuser}.
	 * @param ctx the parse tree
	 */
	void enterSvnuser(svnuserParser.SvnuserContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#svnuser}.
	 * @param ctx the parse tree
	 */
	void exitSvnuser(svnuserParser.SvnuserContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#opts}.
	 * @param ctx the parse tree
	 */
	void enterOpts(svnuserParser.OptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#opts}.
	 * @param ctx the parse tree
	 */
	void exitOpts(svnuserParser.OptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#optA}.
	 * @param ctx the parse tree
	 */
	void enterOptA(svnuserParser.OptAContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#optA}.
	 * @param ctx the parse tree
	 */
	void exitOptA(svnuserParser.OptAContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#optD}.
	 * @param ctx the parse tree
	 */
	void enterOptD(svnuserParser.OptDContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#optD}.
	 * @param ctx the parse tree
	 */
	void exitOptD(svnuserParser.OptDContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#optRP}.
	 * @param ctx the parse tree
	 */
	void enterOptRP(svnuserParser.OptRPContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#optRP}.
	 * @param ctx the parse tree
	 */
	void exitOptRP(svnuserParser.OptRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link svnuserParser#optQ}.
	 * @param ctx the parse tree
	 */
	void enterOptQ(svnuserParser.OptQContext ctx);
	/**
	 * Exit a parse tree produced by {@link svnuserParser#optQ}.
	 * @param ctx the parse tree
	 */
	void exitOptQ(svnuserParser.OptQContext ctx);
}