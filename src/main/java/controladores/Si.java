package controladores;

import java.util.LinkedList;

public class Si implements Instruccion{
    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaElseIfInstrucciones;
    private LinkedList<Instruccion> listaInsElse;
    public Si(Operacion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
    }
    public Si(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaInsElse=c;
    }
    public Si(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaElseIfInstrucciones = l;
        listaInsElse=c;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if((Boolean)condicion.ejecutar(ts)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
            return true;
        }else{
            boolean bandera = false;
            if(listaElseIfInstrucciones != null){
                for(Instruccion in: listaElseIfInstrucciones){
                    if((boolean)in.ejecutar(ts)){
                        bandera = true;
                        break;
                    }
                }
            }
            if(listaInsElse!=null && !bandera){
                TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
                tablaLocal.addAll(ts);
                for(Instruccion in: listaInsElse){
                    in.ejecutar(tablaLocal);
                }
            }
        }
        return false;
    }
}
