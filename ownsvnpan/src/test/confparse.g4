grammar confparse;
GroupName : '[' Group ']' roles* ;
Group : 'groups' ;
roles : ROLENAME '=' rolemember* '\n' ;
ROLENAME : [a-zA-Z_]+;
rolemember : ID;
ID : (LETTER| DIGIT | '_' | '.')+ ;

//NAME : LETTER (LETTER|'.' | DIGIT)*;
fragment LETTER : [a-zA-Z];
fragment DIGIT : [0-9];

SvnDir : '['