package controladores;

public class Decremento implements Instruccion{

    private final String id;

    public Decremento(String id) {
        this.id = id;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id.toString());
        ts.setValor(id,((Double)tmp - 1));
        return tmp;
    }
}
