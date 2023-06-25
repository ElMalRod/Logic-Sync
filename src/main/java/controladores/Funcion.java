package controladores;

import java.util.LinkedList;
import controladores.Simbolo.Tipo;
public class Funcion implements Instruccion{


    /*
        private final String id;
        private final LinkedList<Instruccion> listaInstrucciones;
        private final LinkedList<Instruccion> listaParametros;
        private final Simbolo.Tipo tipo;
        public Funcion(String id, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones, Simbolo.Tipo tipo) {
            this.id = id;
            this.listaInstrucciones = listaInstrucciones;
            this.listaParametros = listaParametros;
            this.tipo = tipo;
        }
    */
    private final String id;
    private final Boolean esMain;
    private final LinkedList<Instruccion> listaInstrucciones;
    private final LinkedList<String> listaParametros;

    public Funcion(String id, LinkedList<Instruccion> listaInstrucciones) {
        this.id = id;
        this.esMain = false;
        this.listaInstrucciones = listaInstrucciones;
        this.listaParametros = null;
    }
    public Funcion(LinkedList<Instruccion> listaInstrucciones) {
        this.id = "main";
        this.esMain = true;
        this.listaInstrucciones = listaInstrucciones;
        this.listaParametros=null;
    }
    public Funcion(String id, LinkedList<Instruccion> listaInstrucciones, LinkedList<String> listaParametros) {
        this.id = id;
        this.esMain = false;
        this.listaInstrucciones = listaInstrucciones;
        this.listaParametros = listaParametros;
        /*for (String s : listaParametros) {
            System.out.println("-----"+s);
        }*/
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        if (this.esMain==true){
            System.out.println("Es la funcion Main");
            tablaLocal.addAll(ts);
            for (Instruccion instruccion : listaInstrucciones) {
                instruccion.ejecutar(tablaLocal);
            }
        }
        else if (this.listaParametros!=null){
            System.out.println("Funcion con parametros");
            ts.add(new Simbolo(this.id,Tipo.FUNCION));
            new Asignacion(this.id,this.listaInstrucciones,this.listaParametros).ejecutar(ts);
        }
        else if(this.listaParametros==null){
            System.out.println("Funcion Procedimiento");
            ts.add(new Simbolo(this.id,Tipo.FUNCION));
            new Asignacion(this.id,this.listaInstrucciones).ejecutar(ts);

        }
        return null;
    }

}
