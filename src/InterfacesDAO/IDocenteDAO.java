
package InterfacesDAO;

import Dominio.Docente;
import java.sql.SQLException;
import java.util.ArrayList;


public interface IDocenteDAO {
    public void guardarDocente (String numPersonal, String nombre, String apellidoMaterno, String apellidoPaterno, String curp, String rfc, String fechaNacimiento, String sexo, String correo, String contraseña) throws SQLException, ClassNotFoundException;
    public ArrayList<Docente> leerTodosLosDocentes() throws SQLException, ClassNotFoundException;
}
