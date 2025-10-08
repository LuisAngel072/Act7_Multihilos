
import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 *
 * @author luis89pun
 */
public class HiloCalculadorFactorial implements Callable<BigInteger> {
    protected int inicio = 0;
    protected int fin = 0;
    protected BigInteger sumaAcumulada = BigInteger.ZERO;
    protected long t1 = 0; //Tiempo de inicio de realización de la tarea
    protected String noHilo = "";
    
    public HiloCalculadorFactorial(int inicio, int fin, String noHilo) {
        this.inicio = inicio;
        this.fin = fin;
        this.noHilo = noHilo;
    }
    /**
     * Esta es una función recursiva la cual se encargará de calcular los
     * factoriales.
     * @param n número al cual se le va a calcular el factorial
     * @return 
     */
    public BigInteger calcularFactorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }
    
    public BigInteger getSumaAcumulada() {
        return this.sumaAcumulada;
    }
    
    // 
    @Override
    public BigInteger call() throws Exception { // 💡 Cambia de run() a call()
        try {
            this.t1 = System.nanoTime();
            for (int i = this.inicio; i <= this.fin; i++) { 
                this.sumaAcumulada = this.sumaAcumulada.add(calcularFactorial(i));
            }
        } finally {
            long t2 = System.nanoTime();
            System.out.println("Suma de factoriales: " + this.sumaAcumulada);
            System.out.println("Hilo " + this.noHilo + " finalizó la suma de factoriales. Rango: [" + this.inicio + ", " + this.fin + "]");
            System.out.println("Tiempo de realización de la suma de factoriales: " + ((t2 - this.t1) / 1_000_000) + "ms");
        }
        // Devuelve el resultado al Hilo Principal
        return this.sumaAcumulada;
    }
}
