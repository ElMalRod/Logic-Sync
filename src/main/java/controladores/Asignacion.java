package controladores;

public class Asignacion implements Instruccion{
    private final String id;
    private final Operacion valor;
    public Asignacion(String a, Operacion b) {
        this.id=a;
        this.valor=b;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        ts.setValor(id,valor.ejecutar(ts));
        return null;
    }

}
