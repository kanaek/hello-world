grammar hello;
options{
language=CSharp2;
utput=AST;
ASTLabelType=CommonTree;
} 
tokens{
option;
} 
cmdLine : String option* para* EOF;
option
: swt ((':' para)((','|';')para)*)? ->(Option swt para*);
swt : ('/'|'-'|'\\') ID -> ID; 
para : String|INT|ID; 
ID : ('a'..'z'|'A'..'Z')(('a'..'z')
|('A'..'Z')
|'0'..'9'
|'&'
|'/'
|'\\'
|'.'
|'_'
)*; //don't support chinese 
String : ('"' .+ '"')|('\'' .+ '\''); 
INT : ('1'..'9')('0'..'9')*
; 
WS 
: (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
;