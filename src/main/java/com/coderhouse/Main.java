package com.coderhouse;

import analyst.*;
import controladores.Instruccion;
import controladores.TablaDeSimbolos;
import forms.appform;

import java.io.FileReader;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        //interpretar("prueba.txt");
        appform app = new appform();
        app.setVisible(true);
    }
    private static void interpretar(String path) {
        Sintactico pars;
        LinkedList<Instruccion> AST_arbolSintaxisAbstracta=null;
        try {
            Lexico lexico = new Lexico(new FileReader(path));
            pars = new Sintactico(lexico);
            pars.parse();
            AST_arbolSintaxisAbstracta=pars.getAST();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
        }
        ejecutarAST(AST_arbolSintaxisAbstracta);
    }
    private static void ejecutarAST(LinkedList<Instruccion> ast) {
        if(ast==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        TablaDeSimbolos ts=new TablaDeSimbolos();
        for(Instruccion ins:ast){

            if(ins!=null)
                System.out.println("----------------------------------AQUI ALGO"+ins);
            ins.ejecutar(ts);

        }
    }
}
