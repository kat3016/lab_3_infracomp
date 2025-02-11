import java.util.Random;
import java.util.HashMap;

public class Clientes {

    private Integer numeroDeClientes;
    private Fila fila; 

    public Clientes(Integer numeroDeClientes, Fila fila) {
        this.numeroDeClientes = numeroDeClientes;
        this.fila = fila;
    }

    public void creacionClientes(){
        for(int i= 0; i < numeroDeClientes; i++){
            Integer procesamientoBasico = new Random().nextInt(2000);
            
            // Adicionar un cliente a la fila
            HashMap<String, Integer> cliente = new HashMap<>();
            
            cliente.put("uid", i);
            cliente.put("procesamientoBasico", procesamientoBasico);
            fila.agregarCliente(cliente);
            
            // Impresión de la creación de un cliente
            System.out.println("Cliente " + i + " agregado a la fila (tiempo de procesamiento: " + procesamientoBasico + "ms)");
            
            //Espera aleatoria entre la creación de clientes
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
