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
ESCRIBIR = "escribir" | "Escribir" | "ESCRIBIR"
HACER = "hacer" | "Hacer" | "HACER"

SI = "si" | "Si" | "SI"
SINO = "sino" | "Sino" | "SINO"
FINSI = "finsi" | "Finsi" | "FINSI"

MIENTRAS = "mientras" | "Mientras" | "MIENTRAS"
FINMIENTRAS = "finmientras" | "Finmientras" | "FINMIENTRAS"

PARA = "para" | "Para" | "PARA"
HASTA = "hasta" | "Hasta" | "HASTA"
CON_PASO = "conpaso" | "Conpaso" | "CONPASO"
FINPARA = "finpara" | "Finpara" | "FINPARA"

SEGUN = "segun" | "Segun" | "SEGUN"
DEOTROMODO = "deotromodo" | "Deotromodo" | "DEOTROMODO"
FINSEGUN = "finsegun" | "Finsegun" | "FINSEGUN"

%%

/*------------  3raa Area: Reglas Lexicas ---------*/
{COMENTUNILINEA} {}
{COMENTMULTILINEA} {}
{CADENACOMILLASDOBLES}   {return new Symbol(sym.CADENA,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}

{ESCRIBIR}               {return new Symbol(sym.RESCRIBIR,yyline,yychar, yytext());}
{ENTERO}                 {return new Symbol(sym.RENTERO,yyline,yychar, yytext());}
{MIENTRAS}               {return new Symbol(sym.RMIENTRAS,yyline,yychar, yytext());}
{SI}                     {return new Symbol(sym.RSI,yyline,yychar, yytext());}
{SINO}                   {return new Symbol(sym.RSINO,yyline,yychar, yytext());}
{CADENA}                 {return new Symbol(sym.RCADENA,yyline,yychar,yytext());}
{FINSI}                  {return new Symbol(sym.RFINSI,yyline,yychar,yytext());}
{HACER}                  {return new Symbol(sym.RHACER,yyline,yychar,yytext());}
{FINMIENTRAS}            {return new Symbol(sym.RFINMIENTRAS,yyline,yychar,yytext());}
{PARA}                   {return new Symbol(sym.RPARA,yyline,yychar,yytext());}
{FINPARA}                {return new Symbol(sym.RFINPARA,yyline,yychar,yytext());}
{HASTA}                  {return new Symbol(sym.RHASTA,yyline,yychar,yytext());}
{CON_PASO}               {return new Symbol(sym.RCONPASO,yyline,yychar,yytext());}
{SEGUN}                  {return new Symbol(sym.RSEGUN,yyline,yychar,yytext());}
{FINSEGUN}               {return new Symbol(sym.RFINSEGUN,yyline,yychar,yytext());}
{DEOTROMODO}             {return new Symbol(sym.RDEOTROMODO,yyline,yychar,yytext());}


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