package dia10.com.app;

import dia10.com.dao.DAO;
import dia10.com.usuarios.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {
    DAO dao;
    public MenuHelper() throws SQLException{
        this.dao = new DAO();
    }

    public void listarUsuarios() throws SQLException{
        List<Usuario> listaUsuarios = dao.cargarUsuarios();
        System.out.println("Id - Nombre - Apellidos    -    Departamento  -  Ciudadd");
        System.out.println("=======================================================");
        for (Usuario u: listaUsuarios){
            System.out.println(u.getId() + " - " + u.getName() + " - " + u.getLastName() + " - " + u.getDepartment() + " - " + u.getCity());
        }
    }

    public void eliminarUsuario() throws SQLException{
        System.out.println("Dime el id del usuario que quieres eliminar: ");
        Scanner sc = new Scanner(System.in);
        int idElegido = sc.nextInt();
        System.out.println(dao.eliminarUsuario(idElegido));
    }

    public void crearUsuario() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el nombre del nuevo usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Dime los apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Dime el departamento en el que trabaja: ");
        String departamento = sc.nextLine();
        System.out.println("Por último, la ciudad en la que se sitúa: ");
        String ciudad = sc.nextLine();

        Usuario usuario = new Usuario(-1, nombre,apellidos,departamento,ciudad);
        System.out.println(dao.annadirUsuario(usuario));
    }
}
