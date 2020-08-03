
package InterfacesDAO;

import Dominio.PlanDeCurso;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlanDeCursoDAO {
    public void guardarPlanDeCurso(PlanDeCurso planDeCurso) throws SQLException, ClassNotFoundException;
    public ArrayList<PlanDeCurso> leerTodosLosPlanes() throws SQLException, ClassNotFoundException;
    
}
