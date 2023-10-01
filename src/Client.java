import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", Main.LOCALHOST_PORT);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            printWriter.println("Привет! Вот и встретились");
        }
    }
}
