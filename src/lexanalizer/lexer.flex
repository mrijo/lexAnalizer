package lexanalizer;

import static model.Tokens.*;
import  model.Tokens;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Esp=[\ \t\r\n]
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



(({D}+(("*"|"+"|"-"|"/"|"^"){D}+)*) | (("*"|"+"|"-"|"/"|"^")("("){D}+(("*"|"+"|"-"|"/"|"^"){D}+)*(")")((("*"|"+"|"-"|"/"|"^"){D}+)+) | (("*"|"+"|"-"|"/"|"^")("("){D}+(("*"|"+"|"-"|"/"|"^"){D}+)*(")")(("*"|"+"|"-"|"/"|"^"){D}+)+)))*  {Tipo=yytext(); return VALIDO;}


{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}