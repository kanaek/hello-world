grammar svnrepo;
prog: (init|init2|init3)+;
init : SVNREPO OPT NAME '\n';
init2: SVNREPO OPT NAME NAME '\n';
init3: SVNREPO OPT NAME OPT FILENAME  '\n';
SVNREPO : 'svnrepo';
FILEPROP: '.authz';
OPT : '-c'
    | '-as'
    |'-d'
    |'-r'
    |'-q'
    ;
FILENAME : ('a'..'z'|'A'..'Z') (('a'..'z')
                 |('A'..'Z')
                 |'0'..'9'
                 |'_')* FILEPROP;
NAME : ('a'..'z'|'A'..'Z') (('a'..'z')
      |('A'..'Z')
      |'0'..'9'
      |'&'
      |'/'
      |'\\'
      |'.'
      |'_')*;


WS : (' '|'\t'|'\r')+ -> skip ;