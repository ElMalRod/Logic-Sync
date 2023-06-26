/*------------  1ra Area: Codigo de Usuario ---------*/
//------> Paquetes,importaciones y declaraciones
package analyst;
import java_cup.runtime.Symbol;

//-------> Directivas
%%
%class Lexico
%public
%line
%char
%cup
%unicode
%ignorecase

%init{
    yyline = 1;
    yychar = 1;
%init}

//------> Expresiones Regulares
CARACTER            =   [\']([^\t\'\"\n]|(\\\")|(\\n)|(\\\')|(\\t))?[\']
BLANCOS=[ \r\t]+
CADENACOMILLASDOBLES = [\"]([^\"\n]|(\\\"))*[\"]
NUMERO=[0-9]+
DECIMAL=[0-9]+("."[  |0-9]+)?
ID=[A-Za-z]+["_"0-9A-Za-z]*
COMENTUNILINEA      =   ("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTMULTILINEA    =   "/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"

//-------> keywords
ENTERO = "entero" | "Entero" | "ENTERO"
CADENA = "cadena" | "Cadena" | "CADENA"
FLOTANTE = "flotante" | "Flotante" | "FLOTANTE"
ESCRIBIR = "escribir" | "Escribir" | "ESCRIBIR"
LEER = "leer" | "Leer" | "LEER"

SI = "si" | "Si" | "SI"
SINO = "sino" | "Sino" | "SINO"

MIENTRAS = "mientras" | "Mientras" | "MIENTRAS"

PARA = "para" | "Para" | "PARA"
HASTA = "hasta" | "Hasta" | "HASTA"
CON_PASO = "conpaso" | "Conpaso" | "CONPASO"

SEGUN = "segun" | "Segun" | "SEGUN"
FUNCION = "funcion" | "Funcion" | "FUNCION"
MAIN = "main" | "Main" | "MAIN";
CASE = "caso" | "Caso" | "CASO";
DEFECTO = "defecto" | "Defecto" | "DEFECTO";
BREAK = "break" | "Break" | "BREAK";

%%

/*------------  3raa Area: Reglas Lexicas ---------*/
{COMENTUNILINEA} {}
{COMENTMULTILINEA} {}
{CADENACOMILLASDOBLES}   {return new Symbol(sym.CADENA,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}

{ESCRIBIR}               {return new Symbol(sym.RESCRIBIR,yyline,yychar, yytext());}
{LEER}                   {return new Symbol(sym.RLEER,yyline,yychar, yytext());}
{ENTERO}                 {return new Symbol(sym.RENTERO,yyline,yychar, yytext());}
{FLOTANTE}               {return new Symbol(sym.RFLOTANTE,yyline,yychar, yytext());}
{MIENTRAS}               {return new Symbol(sym.RMIENTRAS,yyline,yychar, yytext());}
{SI}                     {return new Symbol(sym.RSI,yyline,yychar, yytext());}
{SINO}                   {return new Symbol(sym.RSINO,yyline,yychar, yytext());}
{CADENA}                 {return new Symbol(sym.RCADENA,yyline,yychar,yytext());}
{PARA}                   {return new Symbol(sym.RPARA,yyline,yychar,yytext());}
{HASTA}                  {return new Symbol(sym.RHASTA,yyline,yychar,yytext());}
{CON_PASO}               {return new Symbol(sym.RCONPASO,yyline,yychar,yytext());}
{SEGUN}                  {return new Symbol(sym.RSEGUN,yyline,yychar,yytext());}
{FUNCION}                {return new Symbol(sym.FUN,yyline,yychar,yytext());}
{MAIN}                   {return new Symbol(sym.MAIN,yyline,yychar,yytext());}
{CASE}                   {return new Symbol(sym.RCASE,yyline,yychar,yytext());}
{DEFECTO}                {return new Symbol(sym.RDEFECTO,yyline,yychar,yytext());}
{BREAK}                  {return new Symbol(sym.RBREAK,yyline,yychar,yytext());}



";"   {return new Symbol(sym.PUNTOCOMA,yyline,yychar, yytext());}
":"   {return new Symbol(sym.DOSPUNTOS,yyline,yychar, yytext());}
"("   {return new Symbol(sym.PARENTA,yyline,yychar, yytext());}
")"   {return new Symbol(sym.PARENTC,yyline,yychar, yytext());}
"+"   {return new Symbol(sym.MAS,yyline,yychar, yytext());}
"-"   {return new Symbol(sym.MENOS,yyline,yychar, yytext());}
"*"   {return new Symbol(sym.POR,yyline,yychar, yytext());}
"/"   {return new Symbol(sym.DIV,yyline,yychar, yytext());}
"&"   {return new Symbol(sym.CONCAT,yyline,yychar, yytext());}
"<"   {return new Symbol(sym.MENOR,yyline,yychar, yytext());}
">"   {return new Symbol(sym.MAYOR,yyline,yychar, yytext());}
"="   {return new Symbol(sym.IGUAL,yyline,yychar, yytext());}
"{"   {return new Symbol(sym.LLAVEA,yyline,yychar, yytext());}
"}"   {return new Symbol(sym.LLAVEB,yyline,yychar, yytext());}
","   {return new Symbol(sym.COMA,yyline,yychar, yytext());}

"++"  {return new Symbol(sym.INCREMENTO,yyline,yychar, yytext());}
"--"  {return new Symbol(sym.DECREMENTO,yyline,yychar, yytext());}

\n {yychar=1;}

{BLANCOS} {}
{CARACTER}       {return new Symbol(sym.CARACTER,yyline,yychar, yytext());}
{ID}             {return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
{NUMERO}         {return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
{DECIMAL}        {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}

//------> Errores Lexicos
. {
    System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}