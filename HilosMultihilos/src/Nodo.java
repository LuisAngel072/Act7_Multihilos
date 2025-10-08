
/**
 * Esta clase se encarga de declarar los espacios de memoria donde
 * se almacenara X información (por ello se declara object) en un
 * punto de memoria.
 * Trabaja en conjunto con la clase ColaLista para crear una Lista
 * enlazada tipo cola.
 * @author Luis Ángel
 */
public class Nodo {
    Object elemento; // La información almacenada en el espacio de memoria
    Nodo siguiente; // Referencia al siguiente espacio de memoria enlazado
    
    
    public Nodo(Object x) {
        elemento = x;
        siguiente = null;
    }
}
