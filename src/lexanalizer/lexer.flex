package lexanalizer;

import static model.Tokens.*;
import  model.Tokens;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Esp=[\ \t\r\n]
WHITE=[ \t\r\n]
EXPALPHA=[A-Za-z_]
EXPDIG = [0-9]
EXPALPHANUM = {EXPALPHA}|{EXPDIG}
IDENTIFICADORVAR = {EXPALPHA}({EXPALPHANUM})*
%{
public String Tipo;
%}
%%

"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
"^" {return POTENCIA;}
{EXPDIG} {return NUMERO;}
{IDENTIFICADORVAR} {Tipo=yytext(); return VARIABLE;}
.*|,+ {return ERROR;}

