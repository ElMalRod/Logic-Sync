package controladores;

import java.util.LinkedList;

public class Para implements Instruccion {
    private final Operacion inicializacion;
    private final Operacion condicion;
    private final Operacion incremento;
    private final LinkedList<Instruccion> listaInstrucciones;
    private final String id;

    public Para(Operacion inicializacion, Operacion condicion, Operacion incremento, LinkedList<Instruccion> listaInstrucciones, String id) {
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.incremento = incremento;
        this.listaInstrucciones = listaInstrucciones;
        this.id = id;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        System.out.println("id: " + id);
        //declarar id
        tablaLocal.add(new Simbolo(id, Simbolo.Tipo.NUMERO));
        //asignar valor a id
        tablaLocal.setValor(id, inicializacion.ejecutar(tablaLocal));

        inicializacion.ejecutar(tablaLocal);
        String i = inicializacion.ejecutar(tablaLocal).toString();
        double a = Double.parseDouble(i); //valor inicial

        String e = condicion.ejecutar(tablaLocal).toString();
        double a1 = Double.parseDouble(e); //valor final

        String o = incremento.ejecutar(tablaLocal).toString();
        double a2 = Double.parseDouble(o); //valor incremento

        for (double j = a; j <=a1; j = j + a2) {
            System.out.println("j: " + j);
            tablaLocal.setValor(id, j);
            for (Instruccion instruccion : listaInstrucciones) {
                instruccion.ejecutar(tablaLocal);
            }
        }


        return null;
    }

}

