grammar svnauthz2;
prog : orders;
orders : svnauthz opts;
svnauthz : 'svnauthz';
opts : (optU | optA | optR | optP )*;
//////////////////////////////////////////////////
optU :  ('-a'| '-d'|'-ru'|'-rp'|'-q') username1;
username1 : username (',' username)*;
//username :ID;
/////////////////////////////////////////////////
optA : '-as' file;
file : filename '.authz';
//filename : ID;
/////////////////////////////////////////////////
optR : '-r' Role;

////////////////////////////////////////////////
optP : '-p' Project;
//Project : ID;
////////////////////////////////////////////////
//optD : '-dir' directory;
Role : 'compleader'
      |'deptleader'
      ;
username :ID;
filename : ID;
//Project : ID;

ID : ([a-zA-Z] | [0-9] | '_')+;
WS : (' '|'\t'|'\r')+ -> skip ;
