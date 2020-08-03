package DataAccess;

import Dominio.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ActividadDAO {
    private final ConnectDB connectDB;
    private Connection connection;
    private Statement consultation;
    private ResultSet results;
    
    public ActividadDAO() {
        connectDB = new ConnectDB();
    }
    
    public void guardarActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "INSERT INTO actividad (nombreActividad, nombreTema, idTema) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, actividad.getNombreActividad());
        statement.setString(2, actividad.getNombreTema());
        statement.setInt(3, actividad.getIdTema());
        statement.executeUpdate();
    }
    
    public void actualizarActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "update actividad set idAvance = ?, porcentajeAvance = ?, observacionesActividad = ? where idActividad = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, actividad.getIdAvance());
        statement.setString(2, actividad.getPorcentajeAvance());
        statement.setString(3, actividad.getObservaciones());
        statement.setInt(4, actividad.getIdActividad());
        statement.executeUpdate();
    }
    
    public ArrayList<Actividad> leerTodasLasActividades() throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Actividad actividad = null;
        ArrayList<Actividad> todasLasActividades = new ArrayList<Actividad>();
        String query = "SELECT * from actividad";
        PreparedStatement statement = connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            actividad = new Actividad();
            actividad.setIdActividad(results.getInt("idActividad"));
            actividad.setNombreActividad(results.getString("nombreActividad"));
            actividad.setNombreTema(results.getString("nombreTema"));
            actividad.setIdTema(results.getInt("idTema"));
            todasLasActividades.add(actividad);
        }
        return todasLasActividades;
    }
}
