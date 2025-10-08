
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 2 (Paralelismo):
 * @author Luis Angel de la Torre Gómez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static BigInteger sumaTotal = BigInteger.ZERO; 
    public static void main(String[] args) {  
        
        // Obtener el número de núcleos o procesadores lógicos disponibles para la JVM
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores disponibles: " + numCores);
        
        ExecutorService executor = Executors.newFixedThreadPool(4); 
        
        int [] num = {1,250,251,500,501,750,751,1000}; //Sacaremos la suma de todos los factoriales de este numero
        
        // Lista para guardar los objetos Future, que contendrán los resultados
        List<Future<BigInteger>> resultados = new ArrayList<>();
        
        // Se crearan 4 hilos para cada suma, se dividirá en 4 subpartes igual num
        for(int i = 0; i < 4; i++) {
            int inicio = num[i * 2];
            int fin = num[i * 2 + 1];
            String noHilo = String.valueOf(i + 1);
            
            HiloCalculadorFactorial tarea = new HiloCalculadorFactorial(inicio, fin, noHilo);
            
            // Envía la tarea al ExecutorService y guarda el objeto Future
            Future<BigInteger> futuro = executor.submit(tarea);
            resultados.add(futuro);
        }
        
        
        // 3. Agregación: El Hilo Principal espera y suma los resultados
        System.out.println("\n--- Hilo Principal esperando resultados ---");
        try {
            for (Future<BigInteger> futuro : resultados) {
                //.get() Bloquea el Hilo Principal hasta que los HilosCalculadorFactorial finalicen
                // El Hilo Principal espera a que todos los hilos terminen.
                BigInteger sumaParcial = futuro.get(); 
                
                //Suma los resultados parciales al total
                sumaTotal = sumaTotal.add(sumaParcial); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Es crucial apagar el ExecutorService
            executor.shutdown();
        }
        
        // 4. Mostrar el Resultado Final
        System.out.println("\n==============================================");
        System.out.println("Suma final de los factoriales: (1! + ... + 1000!)");
        System.out.println(sumaTotal);
        System.out.println("==============================================");
    }
    
}
