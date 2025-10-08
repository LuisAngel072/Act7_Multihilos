
/**
 *
 * @author Luis Ángel
 */
public class ColaLista {
    protected Nodo frente;
    protected Nodo fin;
    
    //Constructor para cola vacía
    public ColaLista() {
        fin = frente = null;
    }
    
    /**
     * Como toda cola, debe tener una función de inserción
     * Este método se encarga de insertar un objeto en la útlima posición
     * de la cola, moviendo la propiedad fin de posición.
     * 
     * Si la cola está vacía, entonces frente y fin tendrán el mismo valor y 
     * posición de memoria
     */
    public void insertar(Object elemento) {
        Nodo a;
        a = new Nodo(elemento);
        if(colaVacia()) {
            frente = a; 
        } else {
            fin.siguiente = a;
        }
        fin = a;
    }
    
    /**
     * Además de insertar, una cola debe poder quitar elementos de forma
     * FIFO (First In First Out), es decir, sale el primero que llega
     * Esto sucede si recorremos el puntero de frente a la siguiente posición,
     * eliminando la referencia del objeto anterior.
     * @return Elemento eliminado de la lista tipo object.
     */
    public Object quitar() throws Exception {
        Object aux; //Variable auxiliar, nos ayudara con los punteros de memoria
        if(!colaVacia()){ //Si la cola no está vacía
            aux = frente.elemento; //Almacena la información del frente
            frente = frente.siguiente; //Mueve la referencia del frente
            
        } else {
            throw new Exception("No se puede quitar elementos en una cola vacía");
        }
        return aux; //Retorna el elemento que fue quitado de la lista
    }
    
    /**
     * Vacía toda la cola recorriendo el nodo Frente al siguiente nodo
     * hasta que este nodo Frente se convierta en nulo
     */
    public void borrarCola() {
        for(; frente != null;) {
            frente = frente.siguiente;
        }
        System.gc();
    }
    
    public Object frenteElemento() throws Exception {
        if(colaVacia()) throw new Exception("Cola vacía");
        return frente.elemento;
    }
    
    
    /**
     * Si la cola está vacía, retorna verdadero.
     * Esto se determina si el frente no cuenta con ningún valor
     * en su respectivo espacio de memoria
     * @return verdadero si está vacía
     */
    public boolean colaVacia() { 
        return (frente == null);
    }
}
