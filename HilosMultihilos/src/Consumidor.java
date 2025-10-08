

/**
 *
 * @author luis89pun
 */
public class Consumidor implements Runnable {
    String noCliente;
    
    public Consumidor(String noCl) {
        this.noCliente = noCl;
    }
    
    public Object consumirPan() throws Exception {
        synchronized(main.lock) {
        while(main.listaPanes.colaVacia()) {
            main.lock.wait();
            System.out.println("El cliente" + this.noCliente +" está esperando su pedido");
        }
        return main.listaPanes.quitar();
      }
    }

    @Override
    public void run() {
        try {
            while(true) {
                Object pan = consumirPan();
                System.out.println("El cliente " + this.noCliente + " consumió un pan");
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            System.getLogger(Consumidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
        
    
}
