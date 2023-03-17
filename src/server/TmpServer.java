package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TmpServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        DataBaseLoader.load();
        Executor executor= Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;
        new TmpThread("Save").start();
        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("clients:  " + (++count));
            executor.execute(new ClientThread(clientSocket));
        }
    }
}
