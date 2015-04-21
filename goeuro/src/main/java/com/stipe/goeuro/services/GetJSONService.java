/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stipe.goeuro.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author StipeN
 */
public class GetJSONService {

    private static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static JsonArray getJsonArrayForCity(String city) throws MalformedURLException, IOException {
        String sURL = URL + city;

        // connect to URL - java native
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // convert to JSON Array
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonArray rootobj = root.getAsJsonArray();
        
        return rootobj;
    }
    
}
