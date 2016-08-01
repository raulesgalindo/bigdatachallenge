package data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class read_csv{
	public ArrayList<ArrayList<String>> csv_to_arraylist(String path_csv) {
		
        BufferedReader csv_Buffer = null;
        ArrayList<ArrayList<String>> list_csv = new ArrayList();
        try {
            String csvLine;
            csv_Buffer = new BufferedReader(new FileReader(path_csv));

            // Lee linea CSV
            while ((csvLine = csv_Buffer.readLine()) != null) {
                    ArrayList<String> result  = lineCSVtoArrayList(csvLine);
                    System.out.println("Data from Line: " + result + "\n");
                    list_csv.add(result);
        }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (csv_Buffer != null) csv_Buffer.close();
                } catch (IOException IOException) {
                       IOException.printStackTrace();
                }
        }
        return list_csv;    
	}
	
	// Utility which converts CSV to ArrayList using Split Operation
	public  ArrayList<String> lineCSVtoArrayList(String crunchifyCSV) {
		ArrayList<String> result = new ArrayList<String>();		
		if (crunchifyCSV != null) {
			String[] splitData = crunchifyCSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                                    result.add(splitData[i].trim());
				}
			}
		}
		
		return result;
	}
	
}