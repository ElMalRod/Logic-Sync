package controladores;

public interface Instruccion {
    public Object ejecutar(TablaDeSimbolos ts);

    /*
        private final String id;
        private final LinkedList<Instruccion> listaInstrucciones;
        private final LinkedList<Instruccion> listaParametros;
        private final Simbolo.Tipo tipo;
        public Funcion(String id, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones, Simbolo.Tipo tipo) {
            this.id = id;
            this.listaInstrucciones = listaInstrucciones;
            this.listaParametros = listaParametros;
            this.tipo = tipo;
        }
    */

}
