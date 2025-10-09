/**
 * Hilo sumador
 * 
 * Suma un contador compartido según el número de iteraciones especificadas
 * @author Luis Angel
 */
public class HiloSumador implements Runnable {
    int num_iteraciones = 0;
    String noHilo = "";
    public HiloSumador(int nIteraciones, String nombre) {
        this.num_iteraciones = nIteraciones;
        this.noHilo = nombre;
    }
    /**
     * Para manejar la condición de carrera y los locks para la sincronización
     * al acceso de un recurso compartido, opté por un LOCK GRUESO, bloquea
     * hasta que el hilo termine de hacer su respectiva tarea en el respectivo
     * recurso compartido
     */
    @Override
    public void run() {
        main.lock.lock();
        try {
            for(int i = 0; i < this.num_iteraciones; i++) {
                main.contadorCompartido++;
            }

        } finally { 
            main.lock.unlock();
            System.out.println("El hilo " + noHilo + " finalizó la suma del contador");
        }
    }
    
}
