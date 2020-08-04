package LogicaDeNegocio;

public class ValidacionesCurso {
    
    boolean validarPorcentajeAvance;
    
    public boolean validarPorcentaje(String porcentajeAvance){
        String regex = "^(0*100{1,1}\\.?((?<=\\.)0*)?%?$)|(^0*\\d{0,2}\\.?((?<=\\.)\\d*)?%?)$";
        return validarPorcentajeAvance = porcentajeAvance.matches(regex);
    }
    
}
