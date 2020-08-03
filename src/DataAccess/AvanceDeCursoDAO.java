package DataAccess;

import Dominio.AvanceDeCurso;
import InterfacesDAO.IAvanceDeCursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class AvanceDeCursoDAO implements IAvanceDeCursoDAO {
    private final ConnectDB connectDB;
    private Connection connection;
    private Statement consultation;
    private ResultSet results;
    java.util.Date utilDate = new java.util.Date();
    
    public AvanceDeCursoDAO() {
        connectDB = new ConnectDB();
    }
    
    @Override
    public void guardarAvanceDeCurso(AvanceDeCurso avance) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "INSERT INTO avance_de_curso (fechaAvance, idPlan, NRC) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        utilDate = avance.getFechaAvance();
        java.sql.Date fechaAvance = new java.sql.Date(utilDate.getTime());
        statement.setDate(1, fechaAvance);
        statement.setInt(2, avance.getIdPlan());
        statement.setString(3, avance.getNRCCurso());
        statement.executeUpdate();
    }
    
    public AvanceDeCurso leerAvanceDeCursoPorIDPlan(int idPlan) throws SQLException, ClassNotFoundException {
        AvanceDeCurso avance = new AvanceDeCurso();
        connection = connectDB.getConnection();
        String query = "select idAvance, idPlan from avance_de_curso where idPlan = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idPlan);
        results = statement.executeQuery();
        while (results.next()) {
            avance = new AvanceDeCurso();
            avance.setIdAvance(results.getInt("idAvance"));
            avance.setIdPlan(results.getInt("idPlan"));
        }
        return avance;
    } 
    
    public ArrayList<AvanceDeCurso> leerTodosLosAvances () throws SQLException, ClassNotFoundException {
        ArrayList<AvanceDeCurso> todosLosAvances = new ArrayList<AvanceDeCurso>();
        AvanceDeCurso avanceDeCurso = null;
        connection = ConnectDB.getConnection();
        String query = "select * from avance_de_curso";
        PreparedStatement statement = connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            avanceDeCurso = new AvanceDeCurso();
            avanceDeCurso.setIdAvance(results.getInt("idAvance"));
            todosLosAvances.add(avanceDeCurso);
        }
        return todosLosAvances;
    }
}
