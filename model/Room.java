package com.quirkquest.model;

import java.util.List;
import java.util.Map;

public class Room {
    private String id;
    private String description;
    private Map<String, String> exits;
    private List<String> items;
    
    // Getters and setters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public Map<String, String> getExits() { return exits; }
    public List<String> getItems() { return items; }
}