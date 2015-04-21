/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stipe.goeuro.util;

import com.google.gson.InstanceCreator;
import com.stipe.goeuro.model.GeoPosition;
import java.lang.reflect.Type;

/**
 *
 * @author StipeN
 */
public class GeoPositionInstanceCreator implements InstanceCreator<GeoPosition>{

    @Override
    public GeoPosition createInstance(Type type) {
        return new GeoPosition(0.00, 0.00);
    }
    
}
