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

%init{ 
    yyline = 1;
    yycolumn = 1;
%init} 

// ------> Expresiones Regulares 

entero = [0-9]+
decimal = [0-9]+("."[0-9]+)?
cadena = [\"][^\n\"]*[\"]
id = [a-zA-Z][a-zA-Z0-9_]*

%%
// ------------  Reglas Lexicas -------------------
// Palabras reservas
"program"   {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn);   return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"var"       {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
"arr"       {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.ARR, yycolumn, yyline, yytext());}
"double"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn);return new Symbol(sym.DOUBLEVAR, yycolumn, yyline, yytext());}
"char"      {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.CHARVAR, yycolumn, yyline, yytext());}
"sum"      {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.SUMA, yycolumn, yyline, yytext());}
"res"     {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.RESTA, yycolumn, yyline, yytext());}
"mul"     {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MULTI, yycolumn, yyline, yytext());}
"div"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
"mod"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MOD, yycolumn, yyline, yytext());}
"media"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());}
"mediana" {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());}
"moda"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MODA, yycolumn, yyline, yytext());}
"varianza" {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());}
"max"      {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
"min"      {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
"console"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"column"   {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
"graphpie" {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPHPIE, yycolumn, yyline, yytext());}
"titulo"   {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
"label"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.LABEL, yycolumn, yyline, yytext());}
"values"   {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.VALUES, yycolumn, yyline, yytext());}
"exec"     {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.EXEC, yycolumn, yyline, yytext());}
"grappie"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPPIE, yycolumn, yyline, yytext());}
"grapbar"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPBAR, yycolumn, yyline, yytext());}
"graphbar"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPHBAR, yycolumn, yyline, yytext());}
"label"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.LABEL, yycolumn, yyline, yytext());}
"ejex"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.EJEX, yycolumn, yyline, yytext());}
"ejey"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.EJEY, yycolumn, yyline, yytext());}
"titulox"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.TITX, yycolumn, yyline, yytext());}
"tituloy"    {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.TITY, yycolumn, yyline, yytext());}
"graphline"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPHLINE, yycolumn, yyline, yytext());}
"grapline"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.GRAPLINE, yycolumn, yyline, yytext());}
"histogram"  {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.HISTOGRAM, yycolumn, yyline, yytext());}
"end"      {Util.Reports.agregarToken( yytext(), "reservada" ,yyline, yycolumn); return new Symbol(sym.END, yycolumn, yyline, yytext());}

"end program" {Util.Reports.agregarToken(yytext(), "reservada" ,yyline, yycolumn);  return new Symbol(sym.ENDPROGRAM, yycolumn, yyline, yytext());}

// Simbolos
"!"         {Util.Reports.agregarToken( yytext(), "exclamacion" ,yyline, yycolumn); return new Symbol(sym.EXCL, yycolumn, yyline, yytext());}
"("         {Util.Reports.agregarToken( yytext(), "parentesis derecho" ,yyline, yycolumn); return new Symbol(sym.PARIZQ, yycolumn, yyline, yytext());}
")"         {Util.Reports.agregarToken( yytext(), "parentesis izquierdo" ,yyline, yycolumn); return new Symbol(sym.PARDER, yycolumn, yyline, yytext());}
","         {Util.Reports.agregarToken( yytext(), "coma" ,yyline, yycolumn); return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"="         {Util.Reports.agregarToken( yytext(), "igual" ,yyline, yycolumn); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
";"         {Util.Reports.agregarToken( yytext(), "punto y coma" ,yyline, yycolumn); return new Symbol(sym.PYC, yycolumn, yyline, yytext());}
":"         {Util.Reports.agregarToken( yytext(), "dos puntos" ,yyline, yycolumn); return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
"<"         {Util.Reports.agregarToken( yytext(), "menor que" ,yyline, yycolumn); return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
">"         {Util.Reports.agregarToken( yytext(), "mayor que" ,yyline, yycolumn); return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());}
"-"         {Util.Reports.agregarToken( yytext(), "guion" ,yyline, yycolumn); return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
"["         {Util.Reports.agregarToken( yytext(), "corchete izquierdo" ,yyline, yycolumn); return new Symbol(sym.CORIZQ, yycolumn, yyline, yytext());}
"]"         {Util.Reports.agregarToken( yytext(), "corchete derecho" ,yyline, yycolumn); return new Symbol(sym.CORDER, yycolumn, yyline, yytext());}
     



// Expresiones
{entero}    {Util.Reports.agregarToken( yytext(), "double" ,yyline, yycolumn); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{cadena}    {Util.Reports.agregarToken( yytext(), "char" ,yyline, yycolumn); return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
"@"{id}     {Util.Reports.agregarToken( yytext(), "variable array" ,yyline, yycolumn); return new Symbol(sym.IDARR, yycolumn, yyline, yytext());}
{id}        {Util.Reports.agregarToken( yytext(), "variable" ,yyline, yycolumn); return new Symbol(sym.ID, yycolumn, yyline, yytext());}
{decimal}   {Util.Reports.agregarToken( yytext(), "double" ,yyline, yycolumn); return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}

//------> Ingorados 
[\t\r\f]         {/* Espacios en blanco se ignoran */}
\n               { yycolumn = 1; }
"!" [^\n]* \n?   { Util.Reports.agregarToken( yytext(), "comentarios de una linea" ,yyline, yycolumn); }
"<!"[^!]*"!>"    { /* Ignorar comentario multilinea */ }
" "              {}
 //------> Errores Léxicos 
.           	{ Util.Reports.agregarTokenErr("Lexema desconocido: "+yytext(), "error lexico", yyline, yycolumn);
                 System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }
