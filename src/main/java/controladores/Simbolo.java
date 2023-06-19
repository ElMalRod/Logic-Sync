package controladores;

public class Simbolo {
    private final Tipo tipo;
    private final String id;
    private Object valor;
    public Simbolo(String id, Tipo tipo) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public Object getValor() {
        return valor;
    }
    void setValor(Object v) {
        valor=v;
    }
    public static enum Tipo{
        NUMERO,
        CARACTER
    }
}

