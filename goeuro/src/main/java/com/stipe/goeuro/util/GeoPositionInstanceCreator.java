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
