import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORTA = 9876; // define uma constante
        ServerSocket serverSocket = null;
        Socket socketClient = null;
        Scanner scanner;
        List<Atende> listAtende = new ArrayList<>();

        // bind
        try {
            System.out.println("Carregando o servidor na porta: " + PORTA);
            serverSocket = new ServerSocket(PORTA); // pede uma porta ao S.O.
        } catch (Exception e) {
            System.out.println("Erro: porta em uso");
            System.out.println(e.getMessage());
            return;
        }

        // criar as threads
        int atendimentos = 0;
        while (atendimentos < 3) {
            // conexão
            try {
                System.out.println("Aguardando o cliente....");
                socketClient = serverSocket.accept();
                System.out.println("Conectado com o cliente.");
                Atende atende = new Atende(socketClient);
                listAtende.add(atende);
                atende.start();
                atendimentos++;
            } catch (Exception e) {
                System.out.println("Erro na conexão");
            }
        }

        // desconexão
        System.out.println("Finalizando o servidor...");
        
        listAtende.forEach((atende)->atende.parar());

        if (serverSocket != null) {
            try {
                if (socketClient != null) {
                    socketClient.close();
                }
                serverSocket.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
