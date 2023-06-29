package controladores;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumSet;

public class Leer implements Instruccion{
    private final String nombre;

    public Leer(String nombre) {
        this.nombre = nombre;
    }
    public void escribir(String a)
    {
        String rutaArchivo = "jiji.txt"; // Ruta del archivo existente


        try {
            FileWriter fileWriter = new FileWriter(rutaArchivo, true); // El segundo parámetro "true" habilita el modo de agregado
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String contenido = a;

            bufferedWriter.write(contenido);
            bufferedWriter.newLine();
            bufferedWriter.close(); // Cierra el BufferedWriter


        } catch (IOException e) {
            System.out.println("Ocurrió un error al agregar líneas al archivo: " + e.getMessage());
        }
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        String valor;
        valor = JOptionPane.showInputDialog("Ingresa el valor de "+nombre);
        if (tablaLocal.getTipo(nombre).equals("NUMERO") || tablaLocal.getTipo(nombre).equals("DECIMAL")){
            System.out.println("es entero");
            escribir("Es entero");
            tablaLocal.setValor(nombre, Double.parseDouble(valor));
        }
        if (tablaLocal.getTipo(nombre).equals("CARACTER")){
            tablaLocal.setValor(nombre, valor);
            escribir("Es caracter");
        }
        System.out.println("Hola "+nombre);
        return null;
    }
}
