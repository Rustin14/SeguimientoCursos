
package DataAccess;

import Dominio.PlanDeCurso;
import InterfacesDAO.IPlanDeCursoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlanDeCursoDAO implements IPlanDeCursoDAO {
    private final ConnectDB connectDB;
    private Connection connection;
    private Statement consultation;
    private ResultSet results;
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    
    public PlanDeCursoDAO() {
        connectDB = new ConnectDB();
    }

    @Override
    public void guardarPlanDeCurso(PlanDeCurso planDeCurso) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        String query = "INSERT INTO plan_de_curso (nombreCurso, fechaInicio, fechaFin, nrc) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        utilDate = planDeCurso.getFechaInicio();
        java.sql.Date fechaInicio = new java.sql.Date(utilDate.getTime());
        utilDate = planDeCurso.getFechaFin();
        java.sql.Date fechaFin = new java.sql.Date(utilDate.getTime());
        statement.setString(1, planDeCurso.getNombreCurso());
        statement.setDate(2, fechaInicio);
        statement.setDate(3, fechaFin);
        statement.setString(4, planDeCurso.getNRCCurso());
        statement.executeUpdate();
    }
    
    public PlanDeCurso leerPlanDeCursoConNombreCurso(String nombreCurso) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        PlanDeCurso planDeCurso = null;
        String query = "SELECT * FROM plan_de_curso WHERE nombreCurso LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + nombreCurso + "%");
        results = statement.executeQuery();
        while (results.next()) {
            planDeCurso = new PlanDeCurso();
            planDeCurso.setIdPlan(results.getInt("idPlan"));
            planDeCurso.setNombreCurso(results.getString("nombreCurso"));
            planDeCurso.setFechaInicio(results.getDate("fechaInicio"));
            planDeCurso.setFechaFin(results.getDate("fechaFin"));
            planDeCurso.setNRCCurso(results.getString("nrc"));
        }
        return planDeCurso;
    }
    
    public ArrayList<PlanDeCurso> leerTodosLosPlanes() throws SQLException, ClassNotFoundException{
        connection = connectDB.getConnection();
        PlanDeCurso planDeCurso = null;
        ArrayList<PlanDeCurso> todosLosPlanes = new ArrayList<PlanDeCurso>();
        String query = "SELECT * FROM plan_de_curso";
        PreparedStatement statement = connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            planDeCurso = new PlanDeCurso();
            planDeCurso.setIdPlan(results.getInt("idPlan"));
            planDeCurso.setNombreCurso(results.getString("nombreCurso"));
            planDeCurso.setFechaInicio(results.getDate("fechaInicio"));
            planDeCurso.setFechaFin(results.getDate("fechaFin"));
            planDeCurso.setNRCCurso(results.getString("nrc"));
            todosLosPlanes.add(planDeCurso);
        }
        return todosLosPlanes;
    }
    
        
}
