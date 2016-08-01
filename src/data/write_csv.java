/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raul
 */
public class write_csv {
    public void arraylist_to_csv(ArrayList<ArrayList<String>> list_csv, String file_path) {
           /*Para data results
    0 codigo partida
    1 nombre equipo1
    2 nombre equipo2
    3 Probabilidad Ganar Equipo1
    4 Propabilidad Empate
    5 Probabilidad Ganar Equipo2*/
        if(list_csv != null){
            int numero_lineas = list_csv.size();
            int indice_linea = 0;
            PrintWriter writer;
            try {
                writer = new PrintWriter(file_path, "UTF-8");
                for(indice_linea = 0; indice_linea < numero_lineas; indice_linea++){
                ArrayList<String> linea = list_csv.get(indice_linea);
                writer.println(linea.get(0)+","+linea.get(3)+","+linea.get(4)+","+linea.get(5));          
                }
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(write_csv.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(write_csv.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
        }
	}
	

    
}
