package client;

import client.GUI.ChooseRegAut;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class GuiClient {
    static SocketChannel clientSocket;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        try{
            clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress("127.0.0.1", 8000));
            clientSocket.configureBlocking(false);}
        catch (Exception e){
            System.out.println("Can't connect to server");
            System.exit(0);
        }

        ChooseRegAut chooseRegAut=new ChooseRegAut();




    }





    public static void sendObj(Object obj) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.wrap(Serialize.getBytes(obj));

        clientSocket.write(byteBuffer);
    }
    public static Object getObject() throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocate(5000);
        byte[] bytes;
        Object obj=new Object();
        boolean flag=true;
        while(flag){
            flag=false;
            clientSocket.read(byteBuffer);
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
}
