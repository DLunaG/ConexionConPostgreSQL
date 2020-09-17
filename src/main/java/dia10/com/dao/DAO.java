package dia10.com.dao;

import dia10.com.usuarios.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private Connection cn;

    public DAO() {


        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase encontrada.");
            cn = java.sql.DriverManager.getConnection("jdbc:postgresql://192.168.56.2/empresa", "postgres", "abc");
        } catch (
                ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        } catch (
                SQLException e) {
            System.out.println("SQL Error: " + e.toString());
        }
    }

    public List<Usuario> cargarUsuarios() throws SQLException{
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Statement st = cn.createStatement();
        ResultSet cursor = st.executeQuery("SELECT * FROM usuario;");
        while(cursor.next()){
            int id = cursor.getInt("id");
            String nombre = cursor.getString("nombre");
            String apellidos = cursor.getString("apellidos");
            String departamento = cursor.getString("departamento");
            String ciudad = cursor.getString("ciudad");

            Usuario user = new Usuario(id, nombre, apellidos, departamento, ciudad);
            listaUsuarios.add(user);
        }
        return listaUsuarios;
    }

    public String annadirUsuario(Usuario usuario) throws SQLException{
        Statement st = cn.createStatement();
        StringBuilder sbSQL = new StringBuilder("INSERT INTO usuario (nombre, apellidos, departamento, ciudad) VALUES ('");
        sbSQL.append(usuario.getName()).append("', '")
                .append(usuario.getLastName()).append("', '")
                .append(usuario.getDepartment()).append("', '")
                .append(usuario.getCity()).append("');");
        st.executeUpdate(sbSQL.toString());

        return "Usuario creado";
    }

    public String eliminarUsuario(int id) throws SQLException{
        Statement st = cn.createStatement();
        StringBuilder sbSQL = new StringBuilder("DELETE FROM usuario WHERE id = '").append(id).append("';");
        st.executeUpdate(sbSQL.toString());
        return "Usuario eliminado";

    }


}
