
import java.util.ArrayList;
import java.util.HashMap;

public class Fila {
    
    public static ArrayList<HashMap<String, Integer>> filaClientes = new ArrayList<HashMap<String, Integer>>();

    public Fila() {
    }

    public synchronized void agregarCliente(HashMap<String, Integer> cliente) {
        
        filaClientes.add(cliente);
        if (filaClientes.size() == 1) {
            notify();
        }
    }

    
    public synchronized HashMap<String, Integer> atenderCliente(Integer uid){   
        if (filaClientes.isEmpty()){
           System.out.println("No hay clientes en la fila");
        } 
        for (HashMap<String, Integer> cliente : filaClientes) {
            if (cliente.get("uid") == uid) {
                return cliente;
            }
        }  
        return null;
    }


    public synchronized Integer retirarCliente(){
        while(filaClientes.isEmpty()){
            try {
                System.out.println("Entró al wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        HashMap<String, Integer> cliente = filaClientes.getLast();
        Integer uid = cliente.get("uid");   
        filaClientes.remove(cliente);
        return uid;
        }
 }
        