import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    private int port;
    private ServerSocket serverSocket;
    private Socket server;

    public Server(int port) throws IOException {
        setPort(port);
        try {
            setServerSocket(new ServerSocket(getPort()));
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " " + e.getCause());
        }

//        while (true){
            ready();
//        }
    }

    private int getPort() {
        return port;
    }

    private void setPort(int port) {
        this.port = port;
    }

    private ServerSocket getServerSocket() {
        return serverSocket;
    }

    private void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void sendMessage(String message) throws IOException {
        OutputStream toUser = getServer().getOutputStream();
        PrintWriter sender = new PrintWriter(toUser);
        sender.println(message);
    }

    public String receiveMessage() throws IOException {

        String message;
        InputStream fromUser = getServer().getInputStream();
        DataInputStream receiver = new DataInputStream(fromUser);
        message = receiver.readLine();
        return message;
    }

    private Socket getServer() {
        return server;
    }

    private void setServer(Socket server) {
        this.server = server;
    }

    private void ready() throws IOException {
        setServer(getServerSocket().accept());
    }
}
