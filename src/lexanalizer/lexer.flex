package lexanalizer;

import static model.Tokens.*;
import  model.Tokens;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
OPERACION_BASICA= ({D}+{Esp}*(("*"|"+"|"-"|"/"|"^"){Esp}*{D}+{Esp}*)*)
Esp=[\ \t\r]
PA=("(")
PC=(")")
OPERADORES= ("*"|"+"|"-"|"/"|"^")
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

("+" | "-")?({OPERACION_BASICA} | ({PA}{OPERACION_BASICA}{PC} | (({OPERADORES}{PA}{OPERACION_BASICA}{PC})+  | ({OPERADORES}{PA}{OPERACION_BASICA}{PC}({OPERADORES}{D}+)+)))*  {Tipo=yytext(); return VALIDO;}
({PA}{OPERACION_BASICA}{PC}({OPERADORES}{D}+)+) ({OPERACION_BASICA} | ({PA}{OPERACION_BASICA}{PC} | (({OPERADORES}{PA}{OPERACION_BASICA}{PC})+  | ({OPERADORES}{PA}{OPERACION_BASICA}{PC}({OPERADORES}{D}+)+)))*  {Tipo=yytext(); return VALIDO;}

{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}
