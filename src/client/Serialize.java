package client;

import java.io.*;

public class Serialize {


    public static byte[] getBytes(Object object) throws IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(object);
        return baos.toByteArray();
    }
    public static Object getObject(byte[] bytes) throws IOException, ClassNotFoundException {
        InputStream is=new ByteArrayInputStream(bytes);
        ObjectInputStream ois=new ObjectInputStream(is);
        return ois.readObject();
    }
}
