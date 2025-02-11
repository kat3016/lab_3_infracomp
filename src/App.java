public class App {

    public static Fila fila = new Fila();
    public static int numero_cajeros = 5; 
    public static int numero_clientes = 4;
    public static void main(String[] args) throws Exception {
        
        for(int i = 0; i < numero_cajeros ; i++){
            Cajero cajero = new Cajero(i);
        }
        
        Fila fila = new Fila();

        Clientes clientes = new Clientes( numero_clientes, fila);

    }
}
