package com.quirkquest.model;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    private String currentRoomId;
    private Set<String> inventory = new HashSet<>();
    private Set<String> flags = new HashSet<>();

    // Getters and setters
    public String getCurrentRoomId() { return currentRoomId; }
    public void setCurrentRoomId(String roomId) { this.currentRoomId = roomId; }
    public Set<String> getInventory() { return inventory; }
    public Set<String> getFlags() { return flags; }
}