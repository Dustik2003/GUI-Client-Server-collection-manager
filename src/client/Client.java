package client;

import commands.*;
import worker.Worker;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{

        Scanner cin = new Scanner(System.in);
        SocketChannel clientSocket=null;
        try{
        clientSocket = SocketChannel.open();
        clientSocket.connect(new InetSocketAddress("127.0.0.1", 8000));
        clientSocket.configureBlocking(false);}
        catch (Exception e){
            System.out.println("Can't connect to server");
            System.exit(0);
        }
        boolean tmp=(CheckInput.checkInt("!!Enter any number for authorization!!\n!!Enter 0 for registration!!\n>>")==0);
        LogAndPass logAndPass=new LogAndPass(CheckInput.checkString("Enter Login\n>>"),CheckInput.checkString("Enter Password\n>>"),tmp);
        sendObj(logAndPass,clientSocket);
        if(!(boolean)getObject(clientSocket)){
            System.out.println("!!Failed!!");
            clientSocket.close();
            System.exit(0);
        }else {
            System.out.println("You have successfully logged in.");
            sendObj("qwer",clientSocket);
            LinkedHashMap<Long,Worker> workers=(LinkedHashMap<Long,Worker>) getObject(clientSocket);
//            LinkedHashMap<Long,Worker> workers= (LinkedHashMap<Long,Worker>) getObject(clientSocket);
            System.out.println(workers);
        }




        while(true){
            try{
                System.out.print(">>");
                String[] commandName = cin.nextLine().trim().split(" ");
                if(commandName[0].equals(""))continue;
                if (CommandsDict.getCommands().containsKey(commandName[0]) && !commandName[0].equals("save")) {
                    Command cmd = new CommandsDict().getCommandsManger().get(commandName[0]);
                    cmd.setLogin(logAndPass.getLogin());
                    if (commandName.length > 1) cmd.setArg(commandName[1]);
                    if (cmd.getArg() != null) {
                        if(commandName[0].trim().equals("execute_script")){
                            String path=cmd.getArg();
                            cmd.setArg(loadFile(path));
                        }
                        if(cmd instanceof CommandsWithElements)((CommandsWithElements) cmd).loadElem();
                        sendObj(cmd,clientSocket);
//                    History.move(commandName[0]);
                    } else {
                        System.out.println("Arg can't be null");
                        continue;
                    }
                } else {
                    System.out.println("The Command wasn't found");
                    continue;
                }

                String res=getObject(clientSocket).toString();

                System.out.println(res);
                if(res.endsWith(
                                "　　　　　／＞　    フ\n" +
                                "　　　　　| 　_　 _|\n" +
                                "　 　　　／`ミ _x 彡\n" +
                                "　　 　 /　　　 　 |\n" +
                                "　　　 /　 ヽ　　 ﾉ\n" +
                                "　／￣|　　 |　|　|\n" +
                                "　| (￣ヽ＿_ヽ_)_)\n" +
                                "　＼二つ.")){
                    clientSocket.close();
                    System.exit(0);
                }}catch(Exception e){
                System.exit(0);
            }
        }
    }

    public static Object getObject(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocate(5000);
        byte[] bytes;
        Object obj=new Object();
        boolean flag=true;
        while(flag){
            flag=false;
            socketChannel.read(byteBuffer);
            bytes=new byte[byteBuffer.position()];
            System.arraycopy(byteBuffer.array(),0,bytes,0,byteBuffer.position());
            try{
                obj=Serialize.getObject(bytes);
            }catch(IOException | ClassNotFoundException e){
                flag=true;
            }
        }
        byteBuffer.clear();
        return obj;
    }

    public static void sendObj(Object obj,SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.wrap(Serialize.getBytes(obj));

        socketChannel.write(byteBuffer);
    }


    public static String loadFile(String path) throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        } catch (FileNotFoundException e) {return "!!!The file wasn't found!!!";
        }
        String test;
        while((test= reader.readLine())!=null){
            if(test.contains("execute_script")){
                sb.append(test.trim().split(" ")[1].equals(path)?"!!!File exists command \"execute_scipt\" with entered filename!!!\n":loadFile(test.trim().split(" ")[1]));
                continue;
            }
            sb.append(test+"\n");
        }
        return sb.toString();
    }

}
