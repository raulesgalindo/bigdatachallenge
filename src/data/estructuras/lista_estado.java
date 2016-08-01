
package data.estructuras;
import java.util.ArrayList;
public class lista_estado {
    ArrayList<estado> lista;
    public lista_estado(){
        lista = new ArrayList();
    }
    public void add_estado(estado elemento_estado){
        //Agragamos un estado a la lista
        lista.add(elemento_estado);
    }
    public porcentaje get_porcentaje(){
    //Obtenemos el numero de elementos en la lista
    int number_of_elementos = lista.size();
    int indice_elemento = 0;
    int resultado_equipo1 = 0 ;
    int resultado_equipo2 = 0;
    int resultado_empate = 0;
    for(indice_elemento = 0; indice_elemento<number_of_elementos; indice_elemento++){
        resultado_equipo1 = (lista.get(indice_elemento).isEstado_equipo1()) ? resultado_equipo1+1 : resultado_equipo1;
        resultado_equipo2 = (lista.get(indice_elemento).isEstado_equipo2()) ? resultado_equipo2+1 : resultado_equipo2;
        resultado_empate = (lista.get(indice_elemento).isEmpate()) ? resultado_empate+1 : resultado_empate;    
    }
    //En dado caso que nunca se hayan enfrentado tienen la misma posibilidad todos, deberia de mejorarse
    if(number_of_elementos == 0){
        porcentaje porcentaje_actual = new porcentaje(0.3,0.3,0.4);
        return porcentaje_actual;
    }
    double porcentaje_equipo1 = (double)resultado_equipo1/(double)number_of_elementos;
    double porcentaje_equipo2 = (double)resultado_equipo2/(double)number_of_elementos;
    double porcentaje_empate = (double)resultado_empate/(double)number_of_elementos;
    porcentaje porcentaje_actual = new porcentaje(porcentaje_equipo1,porcentaje_equipo2,porcentaje_empate);
    return porcentaje_actual;
    
    }
}
