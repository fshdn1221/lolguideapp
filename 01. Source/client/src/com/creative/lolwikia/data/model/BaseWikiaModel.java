package com.creative.lolwikia.data.model;

import com.creative.lolwikia.utils.json.JsonKeyword;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Base League of legend wwikia data model
 * @author FSHDN
 * @since Sep 21, 2015
 */
public class BaseWikiaModel {

    /**
     * primary key value of a record
     */
    private String id;
    /**
     * The miliseconds value of the last time data was updated
     */
    private long version;

    /**
     * Getter of {@link BaseWikiaModel#id} field. Which corresponding with value
     * of {@link JsonKeyword#KEY_ID} in json object
     * 
     * @return value of {@link BaseWikiaModel#id} field
     */
    @JsonGetter(JsonKeyword.KEY_ID)
    public String getId() {
        return id;
    }

    /**
     * Setter of {@link BaseWikiaModel#id} field. Which corresponding with value
     * of {@link JsonKeyword#KEY_ID} in json object
     * @param id value to set
     */
    @JsonSetter(JsonKeyword.KEY_ID)
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter of {@link BaseWikiaModel#version} field. Which corresponding with value
     * of {@link JsonKeyword#KEY_VERSION} in json object
     * 
     * @return value of {@link BaseWikiaModel#version} field
     */
    @JsonGetter(JsonKeyword.KEY_VERSION)
    public long getVersion() {
        return version;
    }

    /**
     * Setter of {@link BaseWikiaModel#version} field. Which corresponding with value
     * of {@link JsonKeyword#KEY_VERSION} in json object
     * @param version value to set
     */
    @JsonSetter(JsonKeyword.KEY_VERSION)
    public void setVersion(long version) {
        this.version = version;
    }

    
}
