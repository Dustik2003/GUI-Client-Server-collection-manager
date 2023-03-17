package server;

import client.LogAndPass;
import commands.Command;
import worker.MapWorker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ForkJoinPool;

public class ClientThread extends Thread {
    Socket clientSocket;


    public void run(){
        try {
            ObjectInputStream ois=new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos=new ObjectOutputStream(clientSocket.getOutputStream());
            LogAndPass logAndPass=(LogAndPass) ois.readObject();
            boolean tmp;
            if(logAndPass.getAutOrReg()){
                tmp=Signation.signUp(logAndPass.getLogin(), logAndPass.getPassword());
            }else{
                tmp=Signation.signIn(logAndPass.getLogin(),logAndPass.getPassword());
            }
            oos.writeObject(tmp);
            if(!tmp){
                return;
            }
            ois=new ObjectInputStream(clientSocket.getInputStream());
            oos=new ObjectOutputStream(clientSocket.getOutputStream());
            ois.readObject();
            oos.writeObject(MapWorker.workers);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        while(true){
            String res = null;
            try {
                ObjectInputStream commandReader = new ObjectInputStream(clientSocket.getInputStream());
                Command cmd = ((Command) commandReader.readObject());
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ForkJoinPool forkJoinPool=new ForkJoinPool();
                res =forkJoinPool.invoke(cmd);
                if(res.equals("update")){
                    oos.writeObject(MapWorker.getWorkers());
                    System.out.println(MapWorker.getWorkers());
                    continue;
                }
                else oos.writeObject(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (res.endsWith(
                    "　　　　　／＞　    フ\n" +
                    "　　　　　| 　_　 _|\n" +
                    "　 　　　／`ミ _x 彡\n" +
                    "　　 　 /　　　 　 |\n" +
                    "　　　 /　 ヽ　　 ﾉ\n" +
                    "　／￣|　　 |　|　|\n" +
                    "　| (￣ヽ＿_ヽ_)_)\n" +
                    "　＼二つ.")) break;

        }
    }

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}
