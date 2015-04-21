/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stipe.goeuro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.stipe.goeuro.model.City;
import com.stipe.goeuro.model.GeoPosition;
import com.stipe.goeuro.services.GetJSONService;
import com.stipe.goeuro.services.PutJSONToCSVService;
import com.stipe.goeuro.util.GeoPositionInstanceCreator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author StipeN
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // get JsonObjects
            JsonArray fetchedJsonArray = GetJSONService.getJsonArrayForCity(args[0]);
            
            // print info
            System.out.println("INFO: Fetched elements number: " + fetchedJsonArray.size());
            
            // build Gson
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(GeoPosition.class, new GeoPositionInstanceCreator());
            Gson gson = gsonBuilder.create();
            
            // put Json result to a list of City objects
            List cityList = new ArrayList();            
            for(int i = 0; i < fetchedJsonArray.size(); i++) {
                cityList.add(gson.fromJson(fetchedJsonArray.get(i), City.class));                
            }
            
            // create CSV file
            PutJSONToCSVService.createCSVfileFromListOfCities(cityList, args[0]);
            System.out.println("INFO: CSV file created! File created in: " + System.getProperty("java.io.tmpdir") + " with name: " + args[0] + ".txt");
            
            // print results
            System.out.println("INFO: RESULTS for term: " + args[0]);
            for (Object cityList1 : cityList) {
                System.out.println(cityList1.toString());
            }
            
            
        // error handling            
        } catch (MalformedURLException ex) {
            System.out.println("ERROR: MalformedURL Exception - no internet connection or host is not on");
        } catch (IOException ex) {
            System.out.println("ERROR: IO exception - could not parse to InputStream from URL request, or something wrong with CSV file");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ERROR: no input argument");
        }
        
    }
    
}
