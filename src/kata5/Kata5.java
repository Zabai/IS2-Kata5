package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.*;

public class Kata5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        //Class.forName("org.sqlite.JDBC");
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","username","password");
        //Connection c = DriverManager.getConnection("jdbc:sqlite:DB");
        Statement state = c.createStatement();
        ResultSet rs = state.executeQuery("select * from MAIL");
        
        while(rs.next()){
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("MAIL = " + rs.getString("MAIL"));
        }
        
        /*
        String nameFile = "E:\\Java\\Proyectos\\Kata5\\Data\\emailsfilev1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(nameFile));
        String mail;
        while((mail = reader.readLine())!= null){
            String query = "insert into MAIL(MAIL) values ('" + mail + "')";
            state.executeUpdate(query);
        }*/
        rs.close();
        state.close();
        c.close();
    }
}
