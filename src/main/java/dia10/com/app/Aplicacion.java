package dia10.com.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {
    MenuHelper menu;

    public Aplicacion() throws SQLException {
        menu = new MenuHelper();

    }

    public void ejecutarMenu() throws SQLException{
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        while(opcion != 4) {
            System.out.println("Presiona 1 para listar a los usuarios.\n" +
                    "Presiona 2 para crear a un usuario.\n" +
                    "Presiona 3 para eliminar un usuario.\n" +
                    "Presiona 4 para salir.\n" +
                    "--->");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menu.listarUsuarios();
                    break;
                case 2:
                    menu.crearUsuario();
                    break;
                case 3:
                    menu.eliminarUsuario();
                    break;
            }
        }
        System.out.println("Saliendo del sistema...");
    }
}
