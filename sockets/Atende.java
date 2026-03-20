import java.net.Socket;
import java.util.Scanner;

public class Atende extends Thread {
    Socket client;
    boolean ligada = true;

    public Atende(Socket socket) {
        client = socket;
    }

    public void parar() {
        ligada = false;
    }

    @Override
    public void run() {
        Scanner scanner;
        super.run();
        // comunicação
        try {
            scanner = new Scanner(client.getInputStream());
            String msg = scanner.nextLine();
            System.out.println("Recebido: " + msg);
            while (ligada) {

            }
            System.out.println("Finalizada...");
        } catch (Exception e) {
            System.out.println("Erro na comunicação");
        }
    }

}
