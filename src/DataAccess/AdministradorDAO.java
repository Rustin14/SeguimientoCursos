package DataAccess;

import Dominio.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministradorDAO {
    private ConnectDB connectDB;
    private Connection connection;
    private ResultSet results;
    
    public AdministradorDAO () {
        connectDB = new ConnectDB();
    }
    
    public ArrayList<Administrador> leerTodosLosAdministradores () throws SQLException, ClassNotFoundException {
        ArrayList<Administrador> todosLosDocentes = new ArrayList<Administrador>();
        Administrador admin = null;
        connection = connectDB.getConnection();
        String query = "SELECT * from administrador";
        PreparedStatement statement = connection.prepareStatement(query); 
        results = statement.executeQuery();
        while (results.next()) {
            admin = new Administrador();
            admin.setNombre(results.getString("nombre"));            
            admin.setCorreo(results.getString("correo"));
            admin.setContraseña(results.getString("contraseña"));
            todosLosDocentes.add(admin);
        }
        return todosLosDocentes;
    }
}
