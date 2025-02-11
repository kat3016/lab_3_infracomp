import java.util.ArrayList;
import java.util.HashMap;

public class Fila {
    private ArrayList<HashMap<String, Integer>> filaClientes = new ArrayList<>();
    private int totalClientes; 
    private int clientesAtendidos = 0; 

    public synchronized void agregarCliente(HashMap<String, Integer> cliente) {
        filaClientes.add(cliente);
        totalClientes++;
        notifyAll();
    }

    public synchronized HashMap<String, Integer> retirarCliente() {
        while (filaClientes.isEmpty() && clientesAtendidos < totalClientes) {
            try {
                System.out.println("Un cajero está esperando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (clientesAtendidos >= totalClientes) {
            return null; 
        }

        HashMap<String, Integer> cliente = filaClientes.remove(0);
        clientesAtendidos++;
        return cliente;
    }
}
