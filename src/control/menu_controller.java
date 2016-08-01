package control;
import java.util.ArrayList;
import java.util.Scanner;
import data.read_csv;
import data.write_csv;

public class menu_controller {
    private ArrayList<ArrayList<String>> data_master;//La info de todos los partidos
    private ArrayList<ArrayList<String>> data_results;//La info de los resultados
    
    private void setData_master(ArrayList<ArrayList<String>> data_master) {
        this.data_master = data_master;
    }

    private void setData_results(ArrayList<ArrayList<String>> data_results) {
        this.data_results = data_results;
    }

    public ArrayList<ArrayList<String>> getData_master() {
        return data_master;
    }

    public ArrayList<ArrayList<String>> getData_results() {
        return data_results;
    }
    
    
    
    public menu_controller() {
        data_master = null;
        data_results = null;
        
    }
    public void menu_init(){
        int opcion = -1;
        Scanner reader = new Scanner(System.in);  // Reading from System.in 
        //Leemos la opcion
        while (opcion != 0) {
            imprimir_menu();
            opcion = reader.nextInt();
            switch(opcion){
                case 1:
                    carga_datos();
                    break;
                case 2:
                    carga_encuentros();
                    break;
                case 3:
                    realizar_prediccion();
                    break;
                case 4:
                    exportar_prediccion_csv();
                    break;
                case 5:
                    quick_test();
                    break;
            }
        }
        System.out.print("Adios, Feliz Dia");
    }
    private void quick_test(){
        String path1 = "/home/raul/Dropbox/Projects/thebigdatachallenge/csv/Datos_Futbol_Europeo_raulgalindo.csv";
        String path2 = "/home/raul/Dropbox/Projects/thebigdatachallenge/csv/Codigos_Partidos_raulgalindo.csv";
        String path3 = "/home/raul/Dropbox/Projects/thebigdatachallenge/csv/resultados.csv";
        read_csv reader = new read_csv();
        setData_master(reader.csv_to_arraylist(path1));
        reader = new read_csv();
        setData_results(reader.csv_to_arraylist(path2));
        if(validacion_data()){
        //Se realiza la prediccion
        prediccion_controller prediccion = new prediccion_controller(getData_master(), getData_results());
        setData_results(prediccion.getData_results());
        System.out.println(getData_results()+"");
        write_csv write = new write_csv();
        write.arraylist_to_csv(getData_results(), path3);
        }
        System.out.println("Quick test completado");
    }
    private void imprimir_menu(){
        System.out.println("1-Carga Datos");
        System.out.println("2-Carga Encuentros");
        System.out.println("3-Realizar Predicion");
        System.out.println("4-Exportar Prediccion a CSV");
        System.out.println("5-Quick Test");
        System.out.println("0-Salida");
        System.out.print("Opcion:");
    }
    private void carga_datos(){
        System.out.print("Escriba path de archivo csv de datos:");
        Scanner scan_path = new Scanner(System.in);
        String path_csv_datos = scan_path.nextLine();
        read_csv reader = new read_csv();
        setData_master(reader.csv_to_arraylist(path_csv_datos));
    }
    private void carga_encuentros(){
        System.out.print("Escriba path de archivo csv de encuentros:");
        Scanner scan_path = new Scanner(System.in);
        String path_csv_datos = scan_path.nextLine();
        read_csv reader = new read_csv();
        setData_results(reader.csv_to_arraylist(path_csv_datos));
    }
    private void realizar_prediccion(){
        if(validacion_data()){
        //Se realiza la prediccion
        prediccion_controller prediccion = new prediccion_controller(getData_master(), getData_results());
        setData_results(prediccion.getData_results());
        System.out.println(getData_results()+"");
        }
    }
    private void exportar_prediccion_csv(){
        if(validacion_data()){
        //Se exporta la prediccion
        }
    }
    private boolean validacion_data(){
        boolean estado_data = true;
        if(getData_master() == null){ 
            estado_data =false;
            System.out.println("No se ha cargado data master");
        }
        if(getData_results() == null){
            estado_data = false;
            System.out.println("No se ha cargado data results");
        }
        return estado_data;
    }
        
    
}

    
    
    

