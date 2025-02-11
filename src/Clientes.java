import java.util.Random;
import java.util.HashMap;

public class Clientes extends Thread {
    private Integer numeroDeClientes;

    public Clientes(Integer numeroDeClientes) {
        this.numeroDeClientes = numeroDeClientes;
    }

    public void run(){
        for(int i = 0; i < numeroDeClientes; i++){
            System.out.println("Creando cliente " + i);
            Integer procesamientoBasico = new Random().nextInt(2000);
            
            HashMap<String, Integer> cliente = new HashMap<>();
            cliente.put("uid", i);
            cliente.put("procesamientoBasico", procesamientoBasico);
            App.fila.agregarCliente(cliente);

            System.out.println("Cliente " + i + " agregado a la fila (tiempo de procesamiento: " + procesamientoBasico + "ms)");
            
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}