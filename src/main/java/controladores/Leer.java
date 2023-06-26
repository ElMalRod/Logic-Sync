package controladores;

import javax.swing.*;

public class Leer implements Instruccion{
    private final String nombre;

    public Leer(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        String valor;
        valor = JOptionPane.showInputDialog("Ingresa el valor de "+nombre);
        if (tablaLocal.getTipo(nombre).equals("NUMERO") || tablaLocal.getTipo(nombre).equals("DECIMAL")){
            System.out.println("es enteroooooooo");
            tablaLocal.setValor(nombre, Double.parseDouble(valor));
        }
        if (tablaLocal.getTipo(nombre).equals("CARACTER")){
            tablaLocal.setValor(nombre, valor);
        }
        System.out.println("Hola "+nombre);
        return null;
    }
}
