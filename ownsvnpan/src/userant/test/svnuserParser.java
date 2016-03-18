// Generated from C:/git/giy/ownsvnpan/src/test\svnuser.g4 by ANTLR 4.5.1
package userant.test;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class svnuserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NAME=7, NUMBER=8, WS=9;
	public static final int
		RULE_prog = 0, RULE_orders = 1, RULE_svnuser = 2, RULE_opts = 3, RULE_optA = 4, 
		RULE_optD = 5, RULE_optRP = 6, RULE_optQ = 7;
	public static final String[] ruleNames = {
		"prog", "orders", "svnuser", "opts", "optA", "optD", "optRP", "optQ"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'svnuser'", "'-a'", "'-d'", "'-rp'", "'-q'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NAME", "NUMBER", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "svnuser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public svnuserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public OrdersContext orders() {
			return getRuleContext(OrdersContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			orders();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrdersContext extends ParserRuleContext {
		public SvnuserContext svnuser() {
			return getRuleContext(SvnuserContext.class,0);
		}
		public OptsContext opts() {
			return getRuleContext(OptsContext.class,0);
		}
		public OrdersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orders; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOrders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOrders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOrders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrdersContext orders() throws RecognitionException {
		OrdersContext _localctx = new OrdersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_orders);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			svnuser();
			setState(19);
			opts();
			setState(20);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SvnuserContext extends ParserRuleContext {
		public SvnuserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_svnuser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterSvnuser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitSvnuser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitSvnuser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SvnuserContext svnuser() throws RecognitionException {
		SvnuserContext _localctx = new SvnuserContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_svnuser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptsContext extends ParserRuleContext {
		public OptQContext optQ() {
			return getRuleContext(OptQContext.class,0);
		}
		public OptAContext optA() {
			return getRuleContext(OptAContext.class,0);
		}
		public OptRPContext optRP() {
			return getRuleContext(OptRPContext.class,0);
		}
		public OptDContext optD() {
			return getRuleContext(OptDContext.class,0);
		}
		public OptsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOpts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOpts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOpts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptsContext opts() throws RecognitionException {
		OptsContext _localctx = new OptsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_opts);
		try {
			setState(28);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				optQ();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				optA();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				optRP();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(27);
				optD();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptAContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(svnuserParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(svnuserParser.NAME, i);
		}
		public OptAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOptA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOptA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOptA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptAContext optA() throws RecognitionException {
		OptAContext _localctx = new OptAContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_optA);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__2);
			setState(31);
			match(NAME);
			setState(32);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptDContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(svnuserParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(svnuserParser.NAME, i);
		}
		public OptDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOptD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOptD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOptD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptDContext optD() throws RecognitionException {
		OptDContext _localctx = new OptDContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__3);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				match(NAME);
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptRPContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(svnuserParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(svnuserParser.NAME, i);
		}
		public OptRPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optRP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOptRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOptRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOptRP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptRPContext optRP() throws RecognitionException {
		OptRPContext _localctx = new OptRPContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_optRP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__4);
			setState(41);
			match(NAME);
			setState(42);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptQContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(svnuserParser.NAME, 0); }
		public OptQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).enterOptQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof svnuserListener ) ((svnuserListener)listener).exitOptQ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof svnuserVisitor ) return ((svnuserVisitor<? extends T>)visitor).visitOptQ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptQContext optQ() throws RecognitionException {
		OptQContext _localctx = new OptQContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_optQ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__5);
			setState(46);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(45);
				match(NAME);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\63\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5\37\n\5\3\6\3\6\3\6\3\6\3\7\3\7\6\7"+
		"\'\n\7\r\7\16\7(\3\b\3\b\3\b\3\b\3\t\3\t\5\t\61\n\t\3\t\2\2\n\2\4\6\b"+
		"\n\f\16\20\2\2/\2\22\3\2\2\2\4\24\3\2\2\2\6\30\3\2\2\2\b\36\3\2\2\2\n"+
		" \3\2\2\2\f$\3\2\2\2\16*\3\2\2\2\20.\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2"+
		"\2\24\25\5\6\4\2\25\26\5\b\5\2\26\27\7\3\2\2\27\5\3\2\2\2\30\31\7\4\2"+
		"\2\31\7\3\2\2\2\32\37\5\20\t\2\33\37\5\n\6\2\34\37\5\16\b\2\35\37\5\f"+
		"\7\2\36\32\3\2\2\2\36\33\3\2\2\2\36\34\3\2\2\2\36\35\3\2\2\2\37\t\3\2"+
		"\2\2 !\7\5\2\2!\"\7\t\2\2\"#\7\t\2\2#\13\3\2\2\2$&\7\6\2\2%\'\7\t\2\2"+
		"&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\r\3\2\2\2*+\7\7\2\2+,\7\t\2"+
		"\2,-\7\t\2\2-\17\3\2\2\2.\60\7\b\2\2/\61\7\t\2\2\60/\3\2\2\2\60\61\3\2"+
		"\2\2\61\21\3\2\2\2\5\36(\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}