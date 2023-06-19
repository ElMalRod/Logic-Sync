package controladores;

import java.util.LinkedList;

public class Segun implements Instruccion {
    private final Operacion op;
    private final LinkedList<Instruccion> listaCases;
    private final LinkedList<Integer> listaOps;
    public Segun(Operacion a,LinkedList<Integer> l, LinkedList<Instruccion> b) {
        op=a;
        listaCases=b;
        listaOps=l;
    }

    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);

        op.ejecutar(tablaLocal);
        String i = op.ejecutar(tablaLocal).toString();
        System.out.println("alsdjlasdjakls "+i);
        for(Integer in: listaOps){
            System.out.println("alsdjlasdjakls "+in);
        }
        return null;
    }
}
