package controladores;

import java.util.LinkedList;

public class Segun implements Instruccion {
    private final Operacion op;
    private final LinkedList<String> listaOps;
    private final LinkedList<Object> listaIns;
    private final LinkedList<Instruccion> listaDefecto;
    public Segun(Operacion op, LinkedList<String> listaOps, LinkedList<Object> listaIns, LinkedList<Instruccion> listaDefecto) {
        this.op = op;
        this.listaOps = listaOps;
        this.listaIns = listaIns;
        this.listaDefecto = listaDefecto;
    }



    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        System.out.println("encontro segun");
        double aux = (double) op.ejecutar(ts);
        int parteEntera = Double.valueOf(aux).intValue();
        System.out.println("op: "+parteEntera);
        String aux1 = String.valueOf(parteEntera);
        boolean bandera = false;

        for (String ops : listaOps) {
            System.out.println("ops: "+ops + " op: "+aux1);
            if (ops.equals(aux1)) {
                System.out.println("encontro caso");
                bandera= true;
                System.out.println("listaIns: "+(parteEntera-1));
                LinkedList<Instruccion> lista = (LinkedList<Instruccion>) listaIns.get(parteEntera-1);
                for (Instruccion instruccion : lista) {
                    instruccion.ejecutar(tablaLocal);
                }
                break;
            }
        }
        if(!bandera && listaDefecto != null){
            System.out.println("encontro defecto");
            for (Instruccion instruccion : listaDefecto) {
                instruccion.ejecutar(tablaLocal);
            }
        }


        return null;
    }
}
