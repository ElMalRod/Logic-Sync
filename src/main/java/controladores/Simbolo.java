package controladores;

public class Simbolo {
    private final Tipo tipo;
    private final String id;
    private Object valor;
    private Object valor2;
    public Simbolo(String id, Tipo tipo) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getTipo() {
        System.out.println("tipo: "+tipo);
        return tipo.toString();
    }

    public String getId() {
        return id;
    }
    public Object getValor() {
        return valor;
    }
    public Object getValor2() {
        return valor2;
    }
    void setValor(Object v) {
        valor=v;
    }
    void setValor(Object v, Object v2) {
        valor=v;
        valor2=v2;
    }
    public static enum Tipo{
        NUMERO,
        CARACTER,
        DECIMAL,
        FUNCION
    }
}

