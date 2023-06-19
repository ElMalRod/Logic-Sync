package controladores;

public class Declaracion implements Instruccion{
    private final String id;
    Simbolo.Tipo tipo;
    public Declaracion(String a, Simbolo.Tipo t) {
        id=a;
        tipo=t;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        ts.add(new Simbolo(id,tipo));
        return null;
    }

}

