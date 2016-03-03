grammar svnauthz;
prog : orders;
orders : svnauthz opts '\n';
svnauthz : 'svnauthz ';
opts : (optU | optA | optP | optR | optD | optRight)+;
//optA : '-as' ID ;
//////////////////////////////////////////////////
optU :  ('-a '| '-d '|'-ru '|'-rp '|'-q ') username1;
username1 : ID (',' ID)*;
//username :ID;
/////////////////////////////////////////////////
optA : '-as ' ID ;
//file : filename '.authz';
//filename : ID;
/////////////////////////////////////////////////
optP : '-p ' ID;
////////////////////////////////////////////////
optR : '-r ' Role;
Role : 'compleader'
      |'deptleader'
      |'deptassist'
      |'prjmanager'
      |'developer'
      |'testor'
      |'deployer'
      |'inspector'
      |'sysadmin'
      |'sales'
      |'presales'
      |'adminstaff'
      ;
////////////////////////////////////////////////
optD : '-dir ' ID2 ;
///////////////////////////////////////////////
optRight : ('+' | '-' | '=') ('R' | 'RW' | 'W') ;
//////////////////////////////////////////////
//NAME : ([a-zA-Z] | [0-9] | '_' | '.')+;
ID2 : ('/'(LETTER|DIGIT|'_')+)+;
ID : (LETTER| DIGIT | '_' | '.')+ ;

//NAME : LETTER (LETTER|'.' | DIGIT)*;
fragment LETTER : [a-zA-Z];
fragment DIGIT : [0-9];
WS : (' '|'\t'|'\r')+ -> skip ;
