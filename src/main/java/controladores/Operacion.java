package controladores;
import java.util.LinkedList;

public class Operacion implements Instruccion{
    public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        NUMERO,
        DECIMAL,
        CARACTER,
        IDENTIFICADOR,
        CADENA,
        MAYOR_QUE,
        MENOR_QUE,
        CONCATENACION
    }
    private final Tipo_operacion tipo;
    private Operacion operadorIzq;
    private Operacion operadorDer;
    private Object valor;
    public Operacion(Operacion operadorIzq, Operacion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }
    public Operacion(Operacion operadorIzq, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }
    public Operacion(String a, Tipo_operacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }
    public Operacion(Double a) {
        this.valor=a;
        this.tipo = Tipo_operacion.NUMERO;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if(tipo== Tipo_operacion.DIVISION){
            return (Double)operadorIzq.ejecutar(ts) / (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            return (Double)operadorIzq.ejecutar(ts) * (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.RESTA){
            return (Double)operadorIzq.ejecutar(ts) - (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.SUMA){
            return (Double)operadorIzq.ejecutar(ts) + (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.NEGATIVO){
            return (Double)operadorIzq.ejecutar(ts) * -1;

        }
        else if(tipo == Tipo_operacion.NUMERO){
            return new Double(valor.toString());
        }else if(tipo == Tipo_operacion.DECIMAL){
            return new Double(valor.toString());
        }else if(tipo == Tipo_operacion.IDENTIFICADOR){
            return ts.getValor(valor.toString());
        }else if(tipo == Tipo_operacion.CADENA){
            return valor.toString();
        }else if(tipo == Tipo_operacion.CARACTER){
            return generarChar();
        }
        else if(tipo== Tipo_operacion.MAYOR_QUE){
            return ((Double)operadorIzq.ejecutar(ts)).doubleValue()>((Double)operadorDer.ejecutar(ts)).doubleValue();
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            return ((Double)operadorIzq.ejecutar(ts)).doubleValue()<((Double)operadorDer.ejecutar(ts)).doubleValue();
        }else if(tipo== Tipo_operacion.CONCATENACION){
            return operadorIzq.ejecutar(ts).toString()+operadorDer.ejecutar(ts).toString();
        }else{
            return null;
        }
    }

    private char generarChar()
    {
        String cad = this.valor.toString().substring(1, this.valor.toString().length()-1);
        switch(cad)
        {
            case "\\n":
                return '\n';
            case "\\'":
                return '\'';
            case "\\\"":
                return '\"';
            case "\\\\":
                return '\\';
            default:
                return cad.isEmpty() ? '\0' : cad.charAt(0);
        }
    }
}