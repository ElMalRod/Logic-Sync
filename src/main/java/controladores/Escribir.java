package controladores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Escribir implements Instruccion{

    private final Instruccion contenido;
    public Escribir(Instruccion contenido) {
        this.contenido = contenido;
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
    public String ejecutar(TablaDeSimbolos ts) {
        Object resultado = contenido.ejecutar(ts);
        if (resultado instanceof Double) {
            double aux = (double) resultado;
            //System.out.println("ES UN DOUBLE");
            int parteEntera = Double.valueOf(aux).intValue();
            int parteDecimal = (int) ((aux - parteEntera) * 100);
            if (parteDecimal == 0) {
                //System.out.println("ES UN ENTERO");
                escribir(String.valueOf(parteEntera));

            } else {
                //System.out.println("ES UN DECIMAL");
                escribir(String.valueOf(aux));
            }
        } else {
            //System.out.println( contenido.ejecutar(ts).toString());
            escribir(contenido.ejecutar(ts).toString());
        }


        return null;
    }

}
