package lexanalizer;

import static model.Tokens.*;
import  model.Tokens;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
DO = {D}|[()"*""/""+""-"]
EXPALPHA=[A-Za-z]
Esp=[\ \t\r\n]
WHITE=[ \t\r\n]
%{
public String Tipo;
%}
%%

"(" {return PARENTESISDERECHO;}
")" {return PARENTESISIZQUIERDO;}
"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
"^" {return POTENCIA;}
{DO}*{EXPALPHA}{DO}* { return ERROR;}
{D}+{Esp}* {Tipo=yytext(); return NUMERO;}




{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return VALIDO;}