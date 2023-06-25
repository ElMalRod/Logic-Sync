package controladores;

import java.util.LinkedList;

public class Para implements Instruccion {
    private final Operacion inicializacion;
    private final Operacion condicion;
    private final Operacion incremento;
    private final LinkedList<Instruccion> listaInstrucciones;

    public Para(Operacion inicializacion, Operacion condicion, Operacion incremento, LinkedList<Instruccion> listaInstrucciones) {
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.incremento = incremento;
        this.listaInstrucciones = listaInstrucciones;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);

        inicializacion.ejecutar(tablaLocal);
        String i = inicializacion.ejecutar(tablaLocal).toString();
        double a = Double.parseDouble(i);

        String e = condicion.ejecutar(tablaLocal).toString();
        double a1 = Double.parseDouble(e);

        String o = incremento.ejecutar(tablaLocal).toString();
        double a2 = Double.parseDouble(o);

        for (double j = a; j <=a1; j = j + a2) {
            System.out.println("j: " + j);
            for (Instruccion instruccion : listaInstrucciones) {
                instruccion.ejecutar(tablaLocal);
            }
        }


        return null;
    }

}

