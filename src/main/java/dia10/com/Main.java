package dia10.com;

import dia10.com.app.Aplicacion;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        try {
            Aplicacion app = new Aplicacion();
            app.ejecutarMenu();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.toString());
        }

    }
}
