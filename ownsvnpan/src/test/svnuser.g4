grammar svnuser;
prog : orders;
orders : svnuser opts  '\n';
svnuser : 'svnuser';
opts : optQ | optA | optRP | optD ;
//增加用户
optA : '-a' NAME NAME;
optD : '-d' NAME+;
optRP : '-rp' NAME NAME;
optQ : '-q' NAME?;
NAME : (('a'..'z')
      |('A'..'Z')
      |'0'..'9'
      |'&'
      |'/'
      |'\\'
      |'.'
      |'_')+;
NUMBER : ('0'..'9')+;
WS : (' '|'\t'|'\r')+ -> skip ;