import java.util.HashMap;

public class Cajero extends Thread {
    private Integer id;
    private Double factorDeCansancio = 1.0;

    public Cajero(Integer id) {
        this.id = id;
    }

    public void run(){
        System.out.println("Cajero " + id + " iniciado");
        Integer cliente_uid = App.fila.retirarCliente();
        HashMap<String, Integer> cliente = App.fila.atenderCliente(cliente_uid);
        if(cliente != null) {
            Double tiempoDeProcesamiento =cliente.get("procesamientoBasico")* factorDeCansancio;
            Double tiempoDormir= cliente.get("procesamientoBasico")*0.01 + factorDeCansancio;
            
            try {
                Thread.sleep(tiempoDormir.longValue()); 
            
            } catch (InterruptedException e) {  
                e.printStackTrace();
            }
        System.out.println("El cajero" + id + " atiende al cliente " +
                cliente.get("id")  + "(tiempo de procesamiento base: " + cliente.get("procesamientoBasico") + "ms) factor de cansancio actual: "
                +  factorDeCansancio + " tiempo de procesamiento actual: "+ tiempoDeProcesamiento);
    }
}
}
