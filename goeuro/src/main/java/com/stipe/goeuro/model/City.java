/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stipe.goeuro.model;

/**
 *
 * @author StipeN
 */
public class City {
    
    // _id, name, type, latitude, longitude...
    private Integer _id;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    private GeoPosition geo_position;
    private Integer locationId;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private double distance;

    public City(Integer id,
            String key,
            String name,
            String fullName,
            String iataAirportCode,
            String type,
            String country,
            GeoPosition geoPosition,
            Integer locationId,
            boolean inEurope, 
            String countryCode, 
            boolean coreCountry, 
            double distance) {
        this._id = id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iata_airport_code = iataAirportCode;
        this.type = type;
        this.country = country;
        this.geo_position = geoPosition;
        this.locationId = locationId;
        this.inEurope = inEurope;
        this.countryCode = countryCode;
        this.coreCountry = coreCountry;
        this.distance = distance;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIataAirportCode() {
        return this.iata_airport_code;
    }

    public void setIataAirportCode(String iataAirportCode) {
        this.iata_airport_code = iataAirportCode;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPosition getGeoPosition() {
        return this.geo_position;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geo_position = geoPosition;
    }

    public Integer getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return this.inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return this.coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + _id + ", name=" + this.name + ", type=" + this.type + ", latitude=" + this.geo_position.getLatitude() + ", longitude=" + this.geo_position.getLongitude() + '}';
    }
    
}
