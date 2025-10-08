
import java.util.Random;



/**
 *
 * @author Luis Angel
 */
public class Productor implements Runnable {
    String noProd;
    public Productor(String noPr) {
        this.noProd = noPr;
    }
    
    /**
     * Agrega un pan a la lista compartida, notifica a los hilos que estén
     * esperando por un "pan"
     */
    public void cocinarPan(Object elemento) {
        synchronized(main.lock) {
            main.listaPanes.insertar(elemento);
            main.lock.notify();
        }
        
    }
    
    @Override
    public void run() {
       Random random = new Random();
      try {
            while(true) {
                Object Pan = "Pan";
                //Simula un tiempo de espera de preparacion del pan
                int tiempoAtencion = random.nextInt(10) + 1;
                Thread.sleep(tiempoAtencion * 1000);
                cocinarPan(Pan);
                System.out.println("El " + this.noProd + " ha cocinado un Pan. (Tiempo: " + tiempoAtencion + "s)");
            }          
        }catch(InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
       
    }
    
}
