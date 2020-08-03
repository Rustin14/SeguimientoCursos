package DataAccess;

import Dominio.PlanDeCurso;
import Dominio.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TemaDAO {
    private final ConnectDB connectDB;
    private Connection connection;
    private Statement consultation;
    private ResultSet results;
    java.util.Date utilDate = new java.util.Date();
    
    public TemaDAO() {
        connectDB = new ConnectDB();
    }
    
    public void guardarTema(Tema tema) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "INSERT INTO tema (nombreTema, fechaEstablecida, fechaFinalizacion, idPlan) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        utilDate = tema.getFechaEstablecida();
        java.sql.Date fechaEstablecida = new java.sql.Date(utilDate.getTime());
        utilDate = tema.getFechaFinTema();
        java.sql.Date fechaFinTema = new java.sql.Date(utilDate.getTime());
        statement.setString(1, tema.getNombreTema());
        statement.setDate(2, fechaEstablecida);
        statement.setDate(3, fechaFinTema);
        statement.setInt(4, tema.getIdPlan());
        statement.executeUpdate();
    }
    
    public void actualizarTema(Tema tema) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "update tema set idAvance = ?, porcentajeAvance = ?, observaciones = ? where idTema = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, tema.getIdAvance());
        statement.setString(2, tema.getPorcentajeAvance());
        statement.setString(3, tema.getObservaciones());
        statement.setInt(4, tema.getIdTema());
        statement.executeUpdate();
    }
    
    public Tema leerTemaConNombreTema(String nombreTema) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Tema tema = null;
        String query = "SELECT * FROM tema WHERE nombreTema LIKE '%?%'";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "nombreTema");
        results = statement.executeQuery();
        while (results.next()) {
            tema = new Tema();
            tema.setIdTema(results.getInt("idTema"));
            tema.setNombreTema(results.getString("nombreTema"));
            tema.setFechaEstablecida(results.getDate("fechaEstablecida"));
            tema.setFechaFinTema(results.getDate("fechaFinalizacion"));
            tema.setIdPlan(results.getInt("idPlan"));
        }
        return tema;
    }
    
    public ArrayList<Tema> leerTodosLosTemas() throws SQLException, ClassNotFoundException{
        connection = connectDB.getConnection();
        Tema tema = null;
        ArrayList<Tema> todosLosTemas = new ArrayList<Tema>();
        String query = "SELECT * FROM tema";
        PreparedStatement statement = connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            tema = new Tema();
            tema.setIdTema(results.getInt("idTema"));
            tema.setNombreTema(results.getString("nombreTema"));
            tema.setFechaEstablecida(results.getDate("fechaEstablecida"));
            tema.setIdPlan(results.getInt("idPlan"));
            todosLosTemas.add(tema);
        }
        return todosLosTemas;
    }
}
