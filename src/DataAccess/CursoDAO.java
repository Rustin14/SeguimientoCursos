package DataAccess;

import Dominio.Curso;
import Dominio.Docente;
import Dominio.PlanDeCurso;
import InterfacesDAO.ICursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CursoDAO implements ICursoDAO {
    
    private ConnectDB connectDB;
    private Connection connection;
    private Statement statement;
    private ResultSet results;
    
    public CursoDAO () {
        connectDB = new ConnectDB();
    }
 
    @Override
    public ArrayList<Curso> leerTodosLosCursos() throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Curso curso = null;
        ArrayList<Curso> todosLosCursos = new ArrayList<Curso>();
        String query = "SELECT * FROM curso";
        PreparedStatement statement = connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            curso = new Curso();
            curso.setNrc(results.getString("nrc"));
            curso.setNombre(results.getString("nombreCurso"));
            curso.setPeriodo(results.getString("periodo"));
            curso.setTurno(results.getString("turno"));
            curso.setNumeroDePersonal(results.getString("numeroDePersonal"));
            curso.setNombreCatalogo(results.getString("nombreCatalogo"));
            todosLosCursos.add(curso);
        }
        return todosLosCursos;
    }
    
    public void actualizarEstadoCurso (String NRC) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Curso curso = null;
        String query = "UPDATE curso set estado = 1 where nrc = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, NRC);
        statement.executeUpdate();
    }
    
    public ArrayList<Curso> leerTodosLosCursosPorNumPersonal(String numPersonal) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Curso curso = null;
        ArrayList<Curso> todosLosCursos = new ArrayList<Curso>();
        String query = "SELECT * FROM curso where numeroDePersonal = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, numPersonal);
        results = statement.executeQuery();
        while (results.next()) {
            curso = new Curso();
            curso.setNrc(results.getString("nrc"));
            curso.setNombre(results.getString("nombreCurso"));
            curso.setPeriodo(results.getString("periodo"));
            curso.setTurno(results.getString("turno"));
            curso.setNumeroDePersonal(results.getString("numeroDePersonal"));
            curso.setNombreCatalogo(results.getString("nombreCatalogo"));
            curso.setEstado(results.getInt("estado"));
            todosLosCursos.add(curso);
        }
        return todosLosCursos;
    }
    
    public Curso leerCursoPorNombre(String nombreCurso) throws SQLException, ClassNotFoundException {
        connection = connectDB.getConnection();
        Curso curso = null;
        String query = "SELECT * FROM curso where nombrecurso LIKE '%?%'";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nombreCurso);
        results = statement.executeQuery();
        while (results.next()) {
            curso = new Curso();
            curso.setNrc(results.getString("nrc"));
            curso.setNombre(results.getString("nombreCurso"));
            curso.setPeriodo(results.getString("periodo"));
            curso.setTurno(results.getString("turno"));
            curso.setNumeroDePersonal(results.getString("numeroDePersonal"));
            curso.setNombreCatalogo(results.getString("nombreCatalogo"));
        }
        return curso;
    }
}
