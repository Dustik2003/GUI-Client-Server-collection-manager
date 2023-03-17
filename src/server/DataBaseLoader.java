package server;
import worker.*;
import java.sql.*;

public class DataBaseLoader {

    public static void load() throws SQLException, ClassNotFoundException {
        long maxId=1;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tmp","postgres", "ITMO");
        Statement st= connection.createStatement();
        ResultSet rs=st.executeQuery("select * from workers;");
        while(rs.next()){
            if(Long.parseLong(rs.getString(2))>maxId)maxId=Long.parseLong(rs.getString(2));

            String[] tmp=rs.getString(4).split(",");
            float x=Float.parseFloat(tmp[0].replace("(",""));
            double y=Double.parseDouble(tmp[1].replace(")",""));
            tmp=rs.getString(10).split(",");
            int emCount=Integer.parseInt(tmp[0].replace("(",""));

            java.sql.Date tmpDate=rs.getDate(7);

            MapWorker.getWorkers().put(Long.parseLong(rs.getString(2)),new Worker(rs.getString(3),new Coordinates(x,y),rs.getDate(5),rs.getDouble(6), tmpDate == null ?null:tmpDate.toLocalDate(), rs.getString(8)==null?null:Position.valueOf(rs.getString(8)), rs.getString(9)==null?null:Status.valueOf(rs.getString(9)),new Organization(emCount,OrganizationType.valueOf(tmp[1].replace(")",""))),rs.getString(1)));
        }


        MapWorker.id=maxId;
        connection.close();
    }



}
