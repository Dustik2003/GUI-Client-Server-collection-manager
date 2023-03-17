package server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Signation {


    public static boolean signIn(String login,String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tmp","postgres", "ITMO");
        Statement st= connection.createStatement();
        ResultSet rs=st.executeQuery("select password from logandpass where login=\'"+login+"\';");
        if(!rs.next()){
            connection.close();
            return false;
        }
        if(!rs.getString(1).equals(Signation.md2Hash(password))){
            connection.close();
            return false;
        }
        connection.close();
        return true;
    }
    public static boolean signUp(String login,String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tmp","postgres", "ITMO");
        Statement st= connection.createStatement();
        ResultSet rs=st.executeQuery("select password from logandpass where login=\'"+login+"\';");
        if(rs.next()){
            connection.close();
            return false;
        }
        st.execute("insert into logandpass(login,password)values(\'"+login+ "\',\'"+Signation.md2Hash(password)+"\');");
        connection.close();
        return true;
    }
    public static String md2Hash(String password){
        String hashtext=null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
             hashtext= no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashtext;
    }
}
