package analizador;
import java_cup.runtime.*;


%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares 

entero = [0-9]+
decimal = [0-9]+("."[0-9]+)?
cadena = [\"][^\n\"]*[\"]
id = [a-zA-Z][a-zA-Z0-9_]*

%%
// ------------  Reglas Lexicas -------------------
// Palabras reservas
"program"   {return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"println"   {return new Symbol(sym.RPRINT, yycolumn, yyline, yytext());}
"var"       {return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
"arr"       {return new Symbol(sym.ARR, yycolumn, yyline, yytext());}
"double"    {return new Symbol(sym.DOUBLEVAR, yycolumn, yyline, yytext());}
"char"      {return new Symbol(sym.CHARVAR, yycolumn, yyline, yytext());}
"sum"      {return new Symbol(sym.SUMA, yycolumn, yyline, yytext());}
"res"     {return new Symbol(sym.RESTA, yycolumn, yyline, yytext());}
"mul"     {return new Symbol(sym.MULTI, yycolumn, yyline, yytext());}
"div"  {return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
"mod"    {return new Symbol(sym.MOD, yycolumn, yyline, yytext());}
"media"  {return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());}
"mediana" {return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());}
"moda"    {return new Symbol(sym.MODA, yycolumn, yyline, yytext());}
"varianza" {return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());}
"max"      {return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
"min"      {return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
"console"  {return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"    {return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"column"   {return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
"end"       {return new Symbol(sym.END, yycolumn, yyline, yytext());}

"end program" {return new Symbol(sym.ENDPROGRAM, yycolumn, yyline, yytext());}

// Simbolos
"!"         {return new Symbol(sym.EXCL, yycolumn, yyline, yytext());}
"("         {return new Symbol(sym.PARIZQ, yycolumn, yyline, yytext());}
")"         {return new Symbol(sym.PARDER, yycolumn, yyline, yytext());}
","         {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"="         {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
";"         {return new Symbol(sym.PYC, yycolumn, yyline, yytext());}
":"         {return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
"<"         {return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
">"         {return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());}
"-"         {return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
"["         {return new Symbol(sym.CORIZQ, yycolumn, yyline, yytext());}
"]"         {return new Symbol(sym.CORDER, yycolumn, yyline, yytext());}
     

// Operadores
"+"         {return new Symbol(sym.MAS, yycolumn, yyline, yytext());}

// Expresiones
{entero}    {return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{cadena}    {return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
"@"{id}     {return new Symbol(sym.IDARR, yycolumn, yyline, yytext());}
{id}        {return new Symbol(sym.ID, yycolumn, yyline, yytext());}
{decimal}   {return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}
"!" [^\n]* \n?   { /* Ignorar comentario de una línea */ }
"<!"[^!]*"!>"    { /* Ignorar comentario multilinea */ }

//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }
