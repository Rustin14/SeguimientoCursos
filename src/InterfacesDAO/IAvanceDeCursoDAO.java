
package InterfacesDAO;

import Dominio.AvanceDeCurso;
import java.sql.SQLException;


public interface IAvanceDeCursoDAO {
    public void guardarAvanceDeCurso(AvanceDeCurso avance) throws SQLException, ClassNotFoundException;
}
