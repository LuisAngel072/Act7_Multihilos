/**
 *
 * @author Luis Angel de la Torre Gómez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static ColaLista listaPanes = new ColaLista();
    public static Object lock = new Object();
    public static void main(String[] args) {
     int NO_PRODUCTORES = 1;
     int NO_CONSUMIDORES = 3;
     
     for(int i = 0; i<= NO_CONSUMIDORES; i++) {
         Consumidor consumidor = new Consumidor("Consumidor " + (i+1));
         new Thread(consumidor).start();
     }
     
     for(int i = 0; i <= NO_PRODUCTORES; i++) {
         Productor productor = new Productor("Productor " + (i+1));
         new Thread(productor).start();
     }
     
     
        
    }
    
}
