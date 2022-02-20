package Model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cn;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/prueba";
        String user = "root";
        String pass = "river39tony";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection(url,user,pass);
            System.out.println("coneccion esxtosa");
        } catch (Exception e) {
            System.out.println("error de coneccion");
        }
        return cn;
    }

}
