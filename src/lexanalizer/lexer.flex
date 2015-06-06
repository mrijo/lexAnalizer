package lexanalizer;

import static model.Tokens.*;
import  model.Tokens;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
PA=("(")
PC=(")")
OPERADORES= ("*"|"+"|"-"|"/"|"^")
DCONPAR = {PA}({D}+|"-"{D}+) {PC} 
DODCONPAR = {D}+|{DCONPAR}
OPERACION_BASICA= (({DODCONPAR})+{Esp}*(("*"|"+"|"-"|"/"|"^"){Esp}*{DODCONPAR}+{Esp}*)*)
OPERACIONCONPAR = ( {PA}{OPERACION_BASICA}{PC}) | OPERACION_BASICA 
OPERACIONCIERRE =  {OPERADORES} (({PA}{OPERACION_BASICA}{PC}) | OPERACION_BASICA | DODCONPAR ) 
Esp=[\ \t\r]


WHITE=[ \t\r\n]
%{
public String Tipo;
%}
%%



"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
"^" {return POTENCIA;}
"(" {return PARENTESIS1;}
")" {return PARENTESIS2;}
{D}+{Esp}* {Tipo=yytext(); return NUMERO;}

{OPERACION_BASICA} {Tipo=yytext(); return VALIDO;}
({OPERACIONCONPAR}{OPERADORES})* {OPERACIONCONPAR} ({OPERACIONCIERRE})* {Tipo=yytext(); return VALIDO;}




{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}
