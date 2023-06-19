package controladores;
import java.util.LinkedList;

public class Mientras implements Instruccion{
    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    public Mientras(Operacion a, LinkedList<Instruccion> b) {
        this.condicion=a;
        this.listaInstrucciones=b;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        while((Boolean)condicion.ejecutar(ts)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                ins.ejecutar(tablaLocal);
            }
        }
        return null;
    }
}