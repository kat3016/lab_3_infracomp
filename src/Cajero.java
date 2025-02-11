import java.util.HashMap;

public class Cajero extends Thread {
    private Integer id;
    private Double factorDeCansancio = 1.0;

    public Cajero(Integer id) {
        this.id = id;
    }

    public void run() {
        System.out.println(" Cajero " + id + " iniciado");

        while (true) {
            HashMap<String, Integer> cliente = App.fila.retirarCliente();
            if (cliente == null) break;
            double tiempoDeProcesamiento = cliente.get("procesamientoBasico") * factorDeCansancio;
            long tiempoDormir = Math.round(cliente.get("procesamientoBasico") * 0.01 + factorDeCansancio);
            
            try {
                Thread.sleep(tiempoDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" El cajero " + id + " atiende al cliente " +
                cliente.get("uid") + " (tiempo base: " + cliente.get("procesamientoBasico") +
                "ms) | Cansancio: " + factorDeCansancio + " | Tiempo real: " +
                tiempoDeProcesamiento);
        }
        
        System.out.println("Cajero " + id + " ha terminado.");
    }
}
