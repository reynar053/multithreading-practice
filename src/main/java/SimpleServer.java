import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private static final int PORT = 22;

    public SimpleServer(int port) {
        try (var serverSocket = new ServerSocket(port)) {
            while (true) {
                final var socket = serverSocket.accept();
                new Thread(() -> handle(socket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new SimpleServer(PORT);
    }

    public void handle(Socket socket) {
        System.out.println("Connection is ready! Socket: " + socket);
        try (var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("Enter something:");
            String line;
            while ((line = in.readLine()) != null) {
                out.println("Beep boop!");
                if (line.contains("quit")) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Was unable to establish or communicate with client socket:" + e.getMessage());
        }
    }
}
