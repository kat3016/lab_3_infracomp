public class App {
    public static Fila fila = new Fila();
    public static int numero_cajeros = 5; 
    public static int numero_clientes = 4;

    public static void main(String[] args) throws Exception {
        Clientes generadorClientes = new Clientes(numero_clientes);
        generadorClientes.start();
        generadorClientes.join(); 

        Cajero[] cajeros = new Cajero[numero_cajeros];

        for (int i = 0; i < numero_cajeros; i++) {
            cajeros[i] = new Cajero(i);
            cajeros[i].start();
        }

    
        for (int i = 0; i < numero_cajeros; i++) {
            cajeros[i].join();
        }

        System.out.println("Todos los cajeros han finalizado. Fin del programa.");
    }
}
