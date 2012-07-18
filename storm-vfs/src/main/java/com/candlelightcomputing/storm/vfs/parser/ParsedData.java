package com.candlelightcomputing.storm.vfs.parser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple container for data parsed from files.
 * 
 * @author Steve
 */
public class ParsedData implements Serializable {
    
    private final static long serialVersionUID = 1L;
    
    private Map<String, String> data = new HashMap<>();

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
    
    
}
