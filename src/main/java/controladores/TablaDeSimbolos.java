package controladores;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class TablaDeSimbolos extends LinkedList<Simbolo>{
    public TablaDeSimbolos() {
        super();
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
    Object getValor(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor();
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada!!!");
        String a = "!!!La variable "+id+" no esta declarada!!!";
        escribir(a);
        return "Desconocido";
    }
    public String getTipo(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getTipo();
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada!!!");
        String a = "!!!La variable "+id+" no esta declarada!!!";
        escribir(a);
        return "Desconocido";
    }
    void setValor(String id, Object valor) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada, por lo "
                + "que no puede asignársele un valor!!!");
        String a = "!!!La variable "+id+" no esta declarada, por lo "
                + "que no puede asignársele un valor!!!";
        escribir(a);
    }
    void setValor2(String id, Object valor, Object valor2) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                s.setValor(valor, valor2);
                return;
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada, por lo "
                + "que no puede asignársele un valor!!!");
        String a = "!!!La variable "+id+" no esta declarada, por lo "
                + "que no puede asignársele un valor!!!";
        escribir(a);
    }
    Object getValor2(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor2();
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada!!!");
        String a = "!!!La variable "+id+" no esta declarada!!!";
        escribir(a);
        return "Desconocido";
    }
}
