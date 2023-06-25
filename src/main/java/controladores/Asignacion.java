package controladores;

import java.util.LinkedList;

public class Asignacion implements Instruccion{
    private final String id;
    private final Operacion valor;
    private final LinkedList<Instruccion> listaInstrucciones;
    private final LinkedList<String> listaParametros;
    public Asignacion(String a, Operacion b) {
        this.id=a;
        this.valor=b;
        this.listaInstrucciones=null;
        this.listaParametros=null;
    }
    public Asignacion(String a, LinkedList<Instruccion> listaInstrucciones) {
        this.id = a;
        this.valor = null;
        this.listaInstrucciones = listaInstrucciones;
        this.listaParametros = null;
    }
    public Asignacion(String a, LinkedList<Instruccion> listaInstrucciones, LinkedList<String> listaParametros) {
        this.id = a;
        this.valor = null;
        this.listaInstrucciones = listaInstrucciones;
        this.listaParametros = listaParametros;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if (this.listaInstrucciones!=null && this.listaParametros==null){
            System.out.println("asignando intrucciones de  funcion");
            ts.setValor(id,listaInstrucciones);
        }
        else if(this.listaParametros!=null){
            System.out.println("asignando PARAMETROS de  funcion");
            ts.setValor2(id,listaInstrucciones, listaParametros);
        }
        else if(this.listaParametros==null && this.listaInstrucciones==null){
            ts.setValor(id, valor.ejecutar(ts));
        }
        return null;
    }

}
