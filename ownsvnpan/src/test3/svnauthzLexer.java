// Generated from C:/git/giy/ownsvnpan/src/test\svnauthz.g4 by ANTLR 4.5.1
package test3;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class svnauthzLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, Role=19, ID2=20, ID=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "Role", "ID2", "ID", "LETTER", "DIGIT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'svnauthz '", "'-a '", "'-d '", "'-ru '", "'-rp '", "'-q '", 
		"','", "'-as '", "'-p '", "'-r '", "'-dir '", "'+'", "'-'", "'='", "'R'", 
		"'RW'", "'W'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "Role", "ID2", "ID", "WS"
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


	public svnauthzLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "svnauthz.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00fe\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00df\n\24\3\25\3\25\3\25"+
		"\3\25\6\25\u00e5\n\25\r\25\16\25\u00e6\6\25\u00e9\n\25\r\25\16\25\u00ea"+
		"\3\26\3\26\3\26\6\26\u00f0\n\26\r\26\16\26\u00f1\3\27\3\27\3\30\3\30\3"+
		"\31\6\31\u00f9\n\31\r\31\16\31\u00fa\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\2/\2\61\30\3\2\6\4\2\60\60aa\4\2C\\c|\3\2\62;\5\2\13\13"+
		"\17\17\"\"\u010e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61"+
		"\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7?\3\2\2\2\tC\3\2\2\2\13G\3\2\2\2\r"+
		"L\3\2\2\2\17Q\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25\\\3\2\2\2\27`\3\2\2\2"+
		"\31d\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!p\3\2\2\2#r\3\2\2\2%"+
		"u\3\2\2\2\'\u00de\3\2\2\2)\u00e8\3\2\2\2+\u00ef\3\2\2\2-\u00f3\3\2\2\2"+
		"/\u00f5\3\2\2\2\61\u00f8\3\2\2\2\63\64\7\f\2\2\64\4\3\2\2\2\65\66\7u\2"+
		"\2\66\67\7x\2\2\678\7p\2\289\7c\2\29:\7w\2\2:;\7v\2\2;<\7j\2\2<=\7|\2"+
		"\2=>\7\"\2\2>\6\3\2\2\2?@\7/\2\2@A\7c\2\2AB\7\"\2\2B\b\3\2\2\2CD\7/\2"+
		"\2DE\7f\2\2EF\7\"\2\2F\n\3\2\2\2GH\7/\2\2HI\7t\2\2IJ\7w\2\2JK\7\"\2\2"+
		"K\f\3\2\2\2LM\7/\2\2MN\7t\2\2NO\7r\2\2OP\7\"\2\2P\16\3\2\2\2QR\7/\2\2"+
		"RS\7s\2\2ST\7\"\2\2T\20\3\2\2\2UV\7.\2\2V\22\3\2\2\2WX\7/\2\2XY\7c\2\2"+
		"YZ\7u\2\2Z[\7\"\2\2[\24\3\2\2\2\\]\7/\2\2]^\7r\2\2^_\7\"\2\2_\26\3\2\2"+
		"\2`a\7/\2\2ab\7t\2\2bc\7\"\2\2c\30\3\2\2\2de\7/\2\2ef\7f\2\2fg\7k\2\2"+
		"gh\7t\2\2hi\7\"\2\2i\32\3\2\2\2jk\7-\2\2k\34\3\2\2\2lm\7/\2\2m\36\3\2"+
		"\2\2no\7?\2\2o \3\2\2\2pq\7T\2\2q\"\3\2\2\2rs\7T\2\2st\7Y\2\2t$\3\2\2"+
		"\2uv\7Y\2\2v&\3\2\2\2wx\7e\2\2xy\7q\2\2yz\7o\2\2z{\7r\2\2{|\7n\2\2|}\7"+
		"g\2\2}~\7c\2\2~\177\7f\2\2\177\u0080\7g\2\2\u0080\u00df\7t\2\2\u0081\u0082"+
		"\7f\2\2\u0082\u0083\7g\2\2\u0083\u0084\7r\2\2\u0084\u0085\7v\2\2\u0085"+
		"\u0086\7n\2\2\u0086\u0087\7g\2\2\u0087\u0088\7c\2\2\u0088\u0089\7f\2\2"+
		"\u0089\u008a\7g\2\2\u008a\u00df\7t\2\2\u008b\u008c\7f\2\2\u008c\u008d"+
		"\7g\2\2\u008d\u008e\7r\2\2\u008e\u008f\7v\2\2\u008f\u0090\7c\2\2\u0090"+
		"\u0091\7u\2\2\u0091\u0092\7u\2\2\u0092\u0093\7k\2\2\u0093\u0094\7u\2\2"+
		"\u0094\u00df\7v\2\2\u0095\u0096\7r\2\2\u0096\u0097\7t\2\2\u0097\u0098"+
		"\7l\2\2\u0098\u0099\7o\2\2\u0099\u009a\7c\2\2\u009a\u009b\7p\2\2\u009b"+
		"\u009c\7c\2\2\u009c\u009d\7i\2\2\u009d\u009e\7g\2\2\u009e\u00df\7t\2\2"+
		"\u009f\u00a0\7f\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7x\2\2\u00a2\u00a3"+
		"\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7r\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00df\7t\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7g\2\2"+
		"\u00aa\u00ab\7u\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7q\2\2\u00ad\u00df"+
		"\7t\2\2\u00ae\u00af\7f\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7r\2\2\u00b1"+
		"\u00b2\7n\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7{\2\2\u00b4\u00b5\7g\2\2"+
		"\u00b5\u00df\7t\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9"+
		"\7u\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7e\2\2\u00bc"+
		"\u00bd\7v\2\2\u00bd\u00be\7q\2\2\u00be\u00df\7t\2\2\u00bf\u00c0\7u\2\2"+
		"\u00c0\u00c1\7{\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4"+
		"\7f\2\2\u00c4\u00c5\7o\2\2\u00c5\u00c6\7k\2\2\u00c6\u00df\7p\2\2\u00c7"+
		"\u00c8\7u\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7g\2\2"+
		"\u00cb\u00df\7u\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf"+
		"\7g\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7n\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3\u00df\7u\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7f\2\2"+
		"\u00d6\u00d7\7o\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da"+
		"\7u\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7h\2\2\u00dd"+
		"\u00df\7h\2\2\u00dew\3\2\2\2\u00de\u0081\3\2\2\2\u00de\u008b\3\2\2\2\u00de"+
		"\u0095\3\2\2\2\u00de\u009f\3\2\2\2\u00de\u00a8\3\2\2\2\u00de\u00ae\3\2"+
		"\2\2\u00de\u00b6\3\2\2\2\u00de\u00bf\3\2\2\2\u00de\u00c7\3\2\2\2\u00de"+
		"\u00cc\3\2\2\2\u00de\u00d4\3\2\2\2\u00df(\3\2\2\2\u00e0\u00e4\7\61\2\2"+
		"\u00e1\u00e5\5-\27\2\u00e2\u00e5\5/\30\2\u00e3\u00e5\7a\2\2\u00e4\u00e1"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e0\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"*\3\2\2\2\u00ec\u00f0\5-\27\2\u00ed\u00f0\5/\30\2\u00ee\u00f0\t\2\2\2"+
		"\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2,\3\2\2\2\u00f3"+
		"\u00f4\t\3\2\2\u00f4.\3\2\2\2\u00f5\u00f6\t\4\2\2\u00f6\60\3\2\2\2\u00f7"+
		"\u00f9\t\5\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\b\31\2\2\u00fd"+
		"\62\3\2\2\2\n\2\u00de\u00e4\u00e6\u00ea\u00ef\u00f1\u00fa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}