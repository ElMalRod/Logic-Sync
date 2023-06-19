package controladores;

public class Incremento implements Instruccion {
    private final String id;

    public Incremento(String id) {
        this.id = id;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id);
        ts.setValor(id,((Double)tmp + 1));
        return tmp;
    }
}

