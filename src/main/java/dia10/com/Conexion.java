package dia10.com;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    public static Connection connectPostgres() {

        Connection cn;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase encontrada.");
            cn = java.sql.DriverManager.getConnection("jdbc:postgresql://192.168.56.2/empresa", "postgres", "abc");
            return cn;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        } catch (SQLException e){
            System.out.println("SQL Error: " + e.toString());
        }
        return null;
    }
}
