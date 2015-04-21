package com.stipe.goeuro.services;

import com.stipe.goeuro.model.City;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author StipeN
 */
public class PutJSONToCSVService {

    // dir to save CSV file
    private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    //Delimiter used in CSV file
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final Object[] FILE_HEADER = {"id", "name", "type", "latitude", "longitude"};

    public static void createCSVfileFromListOfCities(List<City> fetchedCities, String cityName) throws IOException {

        FileWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;

        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        
        //initialize FileWriter object
        fileWriter = new FileWriter(TEMP_DIRECTORY + cityName + ".txt");
        //initialize CSVPrinter object
        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
        
        //Create CSV file header
        csvFilePrinter.printRecord(FILE_HEADER);
        
        // adding objects to CSV printer
        for(int i = 0; i < fetchedCities.size(); i++) {
            List cityDataRecord = new ArrayList();
            cityDataRecord.add(String.valueOf(fetchedCities.get(i).getId()));
            cityDataRecord.add(fetchedCities.get(i).getName());
            cityDataRecord.add(fetchedCities.get(i).getType());
            cityDataRecord.add(fetchedCities.get(i).getGeoPosition().getLatitude());
            cityDataRecord.add(fetchedCities.get(i).getGeoPosition().getLongitude());
            csvFilePrinter.printRecord(cityDataRecord);
        }

        // close writers and printer
        fileWriter.flush();
        fileWriter.close();
        csvFilePrinter.close();

    }
    
}
