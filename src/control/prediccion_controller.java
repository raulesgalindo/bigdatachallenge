
package control;

import java.util.ArrayList;
import data.estructuras.*;

public class prediccion_controller {
    private ArrayList<ArrayList<String>> data_master;//La info de todos los partidos
    private ArrayList<ArrayList<String>> data_results;//La info de los resultados
    /*Para data Master
    1 year
    6 nombre equipo local
    7 nombre equipo visitante
    8 goles equipo local
    9 goles equipo vistiante*/
    /*Para data results
    0 codigo partida
    1 nombre equipo1
    2 nombre equipo2
    3 Probabilidad Ganar Equipo1
    4 Propabilidad Empate
    5 Probabilidad Ganar Equipo2*/

    public ArrayList<ArrayList<String>> getData_results() {
        return data_results;
    }
    
    public prediccion_controller(ArrayList<ArrayList<String>> data_master, ArrayList<ArrayList<String>> data_results) {
        this.data_master = data_master;
        this.data_results = data_results;
        int numero_partidos_a_predecir = data_results.size();
        int numero_partidos_master = 0;
        int indice_partido_a_predecir = 0;
        int indice_partido_master =0;
        //Empezamos de uno para saltar los headers
        for(indice_partido_a_predecir = 1; indice_partido_a_predecir <numero_partidos_a_predecir; indice_partido_a_predecir++){
            indice_partido_master = 0; 
            numero_partidos_master = data_master.size();
            ArrayList<String> tupla_result = data_results.get(indice_partido_a_predecir);
            String nombre_result_equipo01 =  tupla_result.get(1);
            String nombre_result_equipo02 = tupla_result.get(2);
            lista_estado lista_juego = new lista_estado();
            //Empezamos de uno para saltar los headers
            for(indice_partido_master = 1; indice_partido_master < numero_partidos_master; indice_partido_master++){
                ArrayList<String> tupla_master = data_master.get(indice_partido_master);
                String nombre_master_equipo01 =  tupla_master.get(6);
                String nombre_master_equipo02 = tupla_master.get(7);
                int goles_local = Integer.parseInt(tupla_master.get(8));
                int goles_visitante = Integer.parseInt(tupla_master.get(9));
                boolean estado_empate = false;
                boolean estado_equipo1 = false;
                boolean estado_equipo2 = false;
                // verificar si en la tupla master viene los equipos de la tupla result
                if((nombre_result_equipo01.equals(nombre_master_equipo01) && nombre_result_equipo02.equals(nombre_master_equipo02))){
                    System.out.println("Se encontro coincidencia:"+nombre_result_equipo01+"-"+nombre_result_equipo02);
                    //nombre_result_equipo01 es local y nombre_result_equipo02 es visitante  
                    //goles local pertenece a result 01 y vistante a result 02
                    if(goles_local > goles_visitante){
                       estado_equipo1 = true; 
                    }else if(goles_local < goles_visitante){
                        estado_equipo2 = true;
                    }else{
                        estado_empate = true;
                    }
                    lista_juego.add_estado(new estado(estado_equipo1,estado_equipo2,estado_empate));
                }else if((nombre_result_equipo01.equals(nombre_master_equipo02) && nombre_result_equipo02.equals(nombre_master_equipo01))){
                    System.out.println("Se encontro coincidencia:"+nombre_result_equipo01+"-"+nombre_result_equipo02);
                    //nombre_result_equipo02 es local y nombre_result_equipo01 es visitante
                    //goles local pertenece a result 02 y vistante a result 01
                    if(goles_local > goles_visitante){
                        estado_equipo2 = true;
                    }else if(goles_local < goles_visitante){
                        estado_equipo1 = true;
                    }else{
                        estado_empate = true;
                    }
                    lista_juego.add_estado(new estado(estado_equipo1,estado_equipo2,estado_empate));
                }   
            }
                //Calculamos la probabilidad
                porcentaje porcentaje_juego = lista_juego.get_porcentaje();
                //Metemos los valores a la lista
                tupla_result.set(3, porcentaje_juego.getPorcentaje_equipo1()+"");
                tupla_result.set(5, porcentaje_juego.getPorcentaje_equipo2()+"");
                tupla_result.set(4, porcentaje_juego.getPorcentaje_empate()+"");
                //Actualizamos el elemento de la lista
                data_results.set(indice_partido_a_predecir, tupla_result);
            
        }
    
    
    }
}
