import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final Integer LOCALHOST_PORT = 8080;

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)) {
            System.out.println("Сервер запущен");
            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    final String line = reader.readLine();
                    System.out.println("Подключение! Информация от клиента " + line + ". Мой порт " + client.getPort());
                }
            }
        }
    }
}