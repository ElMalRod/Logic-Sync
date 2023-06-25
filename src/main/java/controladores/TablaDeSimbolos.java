package controladores;
import java.util.LinkedList;

public class TablaDeSimbolos extends LinkedList<Simbolo>{
    public TablaDeSimbolos() {
        super();
    }
    Object getValor(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor();
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada!!!");
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
    }
    Object getValor2(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor2();
            }
        }
        System.out.println("!!!La variable "+id+" no esta declarada!!!");
        return "Desconocido";
    }
}
