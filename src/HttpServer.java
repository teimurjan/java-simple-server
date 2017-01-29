import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public void run() throws Throwable {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
            Socket socket = serverSocket.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(socket)).start();
        }
    }
}