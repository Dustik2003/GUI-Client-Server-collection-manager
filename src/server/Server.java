package server;

import commands.Command;
import commands.Exit;
import commands.History;
import worker.FileReader;
import worker.MapWorker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String st=System.getenv("CollectionFile");
        try{
            FileReader.readFile(st);
        }catch (Exception e){
            System.out.println("FIle was empty or variable wasn't set.(Set the variable CollectionFile by command export)");
            System.out.println("Now Collection is empty!!!");
        }
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;
        new TmpThread("Save").start();
//        ObjectOutputStream oos=new ObjectOutputStream(clientSocket.getOutputStream());
        while (true){
            Socket clientSocket = serverSocket.accept();
        System.out.print("clients:  " + (++count));
        while (true) {
            ObjectInputStream commandReader = new ObjectInputStream(clientSocket.getInputStream());
            Command cmd = ((Command) commandReader.readObject());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());


            String res = cmd.execute();
            oos.writeObject(res);
            if (res.equals("java eto p****")) break;
        }
    }
    }
}
