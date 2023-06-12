/*------------  1ra Area: Codigo de Usuario ---------*/
//------> Paquetes,importaciones y declaraciones
package analyst;
import java_cup.runtime.*;
import java.util.LinkedList;

/*------------  2da Area: Opciones y Declaraciones ---------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
    public static LinkedList<TError> TablaEL = new LinkedList<TError>();
%}

//-------> Directivas
%public
%class Lexer
%cupsym sym
%cup
%char
%column
%full
%ignorecase
%line

//------> Expresiones Regulares
WHITESPACE = [\040\f\r\t\013]
numero = 0|[1-9][0-9]*
decimal = {numero}\.\d+
id = [_a-zA-Z][a-zA-Z0-9]*
comilla = \"([a-zA-Z]|(\s)|[0-9])+\"


//-------> keywords
ESCRIBIR = "escribir" | "Escribir" | "ESCRIBIR"
LEER = "leer" | "Leer" | "LEER"
SI = "si" | "Si" | "SI"
SINO = "sino" | "Sino" | "SINO"
FINSI = "finsi" | "Finsi" | "FINSI"
PARA = "para" | "Para" | "PARA"
FINPARA = "finpara" | "Finpara" | "FINPARA"
HASTA = "hasta" | "Hasta" | "HASTA"
CON_PASO = "con paso" | "Con paso" | "CON PASO"
HACER = "hacer" | "Hacer" | "HACER"
MIENTRAS = "mientras" | "Mientras" | "MIENTRAS"
FINMIENTRAS = "finmientras" | "Finmientras" | "FINMIENTRAS"
//-----> keywords declarar
ENTERO = "entero" | "Entero" | "ENTERO"
FLOTANTE = "flotante" | "Flotante" | "FLOTANTE"
CADENA = "cadena" | "Cadena" | "CADENA"



%%
/*------------  3raa Area: Reglas Lexicas ---------*/

//------> Espacios
<YYINITIAL>{WHITESPACE} { }
//------> Comentarios
"#".* {/*Ignore*/}
<YYINITIAL> "+"         { System.out.println("Encontro "+yytext()+"mas" ); return new Symbol(sym.mas, yycolumn, yyline, yytext()); }
<YYINITIAL> "-"         { System.out.println("Encontro "+yytext()+"menos" ); return new Symbol(sym.menos, yycolumn, yyline, yytext()); }
<YYINITIAL> "*"         { System.out.println("Encontro "+yytext()+"mult" ); return new Symbol(sym.mult, yycolumn, yyline, yytext()); }
<YYINITIAL> "/"         { System.out.println("Encontro "+yytext()+"div" ); return new Symbol(sym.div, yycolumn, yyline, yytext()); }
<YYINITIAL> "("         { System.out.println("Encontro "+yytext()+"parenta" ); return new Symbol(sym.parenta, yycolumn, yyline, yytext()); }
<YYINITIAL> ")"         { System.out.println("Encontro "+yytext()+"parentc" ); return new Symbol(sym.parentc, yycolumn, yyline, yytext()); }
<YYINITIAL> "="         { System.out.println("Encontro "+yytext()+"igual" ); return new Symbol(sym.igual, yycolumn, yyline, yytext()); }
<YYINITIAL> ";"         { System.out.println("Encontro "+yytext()+"puntocoma" ); return new Symbol(sym.puntocoma, yycolumn, yyline, yytext()); }
<YYINITIAL> "<"        { System.out.println("Encontro "+yytext()+"menor" ); return new Symbol(sym.menor, yycolumn, yyline, yytext()); }
<YYINITIAL> ">"        { System.out.println("Encontro "+yytext()+"mayor" ); return new Symbol(sym.mayor, yycolumn, yyline, yytext()); }

[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}

//------> Simbolos
{ESCRIBIR}  { System.out.println("Reconocio "+yytext()+" escribir"); return new Symbol(sym.ESCRIBIR, yycolumn, yyline, yytext()); }
{LEER}      { System.out.println("Reconocio "+yytext()+" leer"); return new Symbol(sym.LEER, yycolumn, yyline, yytext()); }
{SI}        { System.out.println("Reconocio "+yytext()+" si"); return new Symbol(sym.SI, yycolumn, yyline, yytext()); }
{SINO}      { System.out.println("Reconocio "+yytext()+" sino"); return new Symbol(sym.SINO, yycolumn, yyline, yytext()); }
{FINSI}     { System.out.println("Reconocio "+yytext()+" finsi"); return new Symbol(sym.FINSI, yycolumn, yyline, yytext()); }
{PARA}      { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(sym.PARA, yycolumn, yyline, yytext()); }
{FINPARA}   { System.out.println("Reconocio "+yytext()+" finpara"); return new Symbol(sym.FINPARA, yycolumn, yyline, yytext()); }
{HASTA}     { System.out.println("Reconocio "+yytext()+" hasta"); return new Symbol(sym.HASTA, yycolumn, yyline, yytext()); }
{HACER}     { System.out.println("Reconocio "+yytext()+" hacer"); return new Symbol(sym.HACER, yycolumn, yyline, yytext()); }
{CON_PASO}  { System.out.println("Reconocio "+yytext()+" con paso"); return new Symbol(sym.CON_PASO, yycolumn, yyline, yytext()); }
{MIENTRAS}  { System.out.println("Reconocio "+yytext()+" mientras"); return new Symbol(sym.MIENTRAS, yycolumn, yyline, yytext()); }
{FINMIENTRAS} { System.out.println("Reconocio "+yytext()+" finmientras"); return new Symbol(sym.FINMIENTRAS, yycolumn, yyline, yytext()); }
{ENTERO}    { System.out.println("Reconocio "+yytext()+" entero"); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{FLOTANTE}  { System.out.println("Reconocio "+yytext()+" flotante"); return new Symbol(sym.FLOTANTE, yycolumn, yyline, yytext()); }
{CADENA}    { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(sym.CADENA, yycolumn, yyline, yytext()); }


//-------> Simbolos ER
{numero}    { System.out.println("Reconocio "+yytext()+" numero"); return new Symbol(sym.numero, Integer.valueOf(yytext())); }
{comilla}  { System.out.println("Reconocio "+yytext()+" comilla"); return new Symbol(sym.comilla, yycolumn, yyline, yytext()); }
{id}    { System.out.println("Reconocio "+yytext()+" id"); return new Symbol(sym.id, yycolumn, yyline, yytext()); }
{decimal}   { System.out.println("Reconocio "+yytext()+" decimal"); return new Symbol(sym.decimal, Double.valueOf(yytext())); }


//------> Errores Lexicos
.                       { System.out.println("Error Lexico"+yytext()+" Linea "+yyline+" Columna "+yycolumn);
                          TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);}
