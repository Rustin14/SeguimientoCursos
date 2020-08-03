package LogicaDeNegocio;

public class ValidacionesCurso {
    
    boolean validarPorcentajeAvance;
    
    public boolean validarPorcentaje(String porcentajeAvance){
        return validarPorcentajeAvance = porcentajeAvance.matches("\\d+(?:\\.\\d+)?%"); 
    }
    
}
