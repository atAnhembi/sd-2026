import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        final int PORTA = 9876;
        final String servidor = "localhost";
        // final String servidor = "10.159.129.42";
        PrintStream printStream;

        // conexão
        try {
            System.out.println("Buscando o servidor...");
            socket = new Socket(servidor, PORTA);
            System.out.println("Conectado.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }


        //  comunicação
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Boa noite from Prof!");
            while (true) {
                
            }
        } catch (Exception e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
        }

        // desconexão
        System.out.println("finalizando o cliente...");
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
