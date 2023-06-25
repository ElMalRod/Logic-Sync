package controladores;

import java.util.LinkedList;

public class EjecutarFuncion implements Instruccion{
    private final String id;
    private final LinkedList<Object> listaParams;
    public EjecutarFuncion(String id) {
        this.id = id;
        this.listaParams = null;
    }
    public EjecutarFuncion(String id, LinkedList listaParams) {
        System.out.println("ejecutando funcion: "+id);
        this.id = id;
        this.listaParams = listaParams;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        if (listaParams!=null){
            System.out.println("LISTA PARAMNS NO VACIA");
            LinkedList<String> listaParametros = (LinkedList<String>) ts.getValor2(id);
            for (int i = 0; i < listaParametros.size(); i++) {
                ts.add(new Simbolo(listaParametros.get(i), Simbolo.Tipo.NUMERO));
                ts.setValor(listaParametros.get(i), listaParams.get(i));
                System.out.println("asignando parametro: "+listaParametros.get(i)+" = "+listaParams.get(i));
            }
        }
        LinkedList<Instruccion> listaInstrucciones;
        listaInstrucciones = (LinkedList<Instruccion>) ts.getValor(id);
        for (Instruccion instruccion : listaInstrucciones) {
            instruccion.ejecutar(ts);
        }

        return null;
    }
}
