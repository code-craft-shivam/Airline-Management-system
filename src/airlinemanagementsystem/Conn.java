package airlinemanagementsystem;
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;


    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Registering Driver
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Aa@123456");//create connection string
            s=c.createStatement();//create stratement

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
