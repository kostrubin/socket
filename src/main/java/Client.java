import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT= 8080;

        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                out.println("GET / HTTP/1.1\n" + "Host: " + HOST + "\n\n\n");
                String resp = in.readLine();
                System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
