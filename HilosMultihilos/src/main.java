
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio 3 (Condición de carrera y locks):
 * Se implementa un LOCK granular para el desarrollo del ejercicio 3
 * @author Luis Angel de la Torre Gómez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static int contadorCompartido = 0; //Contador compartido
    static Lock lock = new ReentrantLock(false);
    
    public static void main(String[] args) {  
        int numHilos = 10;
        Thread[] hilosSuma = new Thread[numHilos];
        
        int num_iteraciones = 100_000;
        
        for (int i = 0; i < numHilos; i++) {
            String noHilo = String.valueOf(i+1);
            hilosSuma[i] = new Thread(new HiloSumador(num_iteraciones, noHilo));
        }
        
        for (int i = 0; i < numHilos; i++) {
            hilosSuma[i].start();
        }
        
        // Esperar a que todos terminen
        for (int i = 0; i < numHilos; i++) {
            try {
                hilosSuma[i].join(); //Espera que el hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        //El resultado esperado debe ser de 1_000_000 (un millón)
        System.out.println("El resultado final del contador compartido es: " + contadorCompartido);
    }
}
