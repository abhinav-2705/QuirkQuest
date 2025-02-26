package com.quirkquest.engine;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quirkquest.model.GameState;
import com.quirkquest.model.Room;
import com.quirkquest.model.Item;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;

public class JSONLoader {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static Map<String, Room> rooms = new HashMap<>();
    private static Map<String, Item> items = new HashMap<>();

    static {
        try {
            // Load rooms
            InputStream roomsStream = JSONLoader.class.getResourceAsStream("/rooms.json");
            rooms = mapper.readValue(roomsStream, new TypeReference<Map<String, Room>>() {});
            
            // Load items
            InputStream itemsStream = JSONLoader.class.getResourceAsStream("/items.json");
            items = mapper.readValue(itemsStream, new TypeReference<Map<String, Item>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Room getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public static Item getItem(String itemId) {
        return items.get(itemId);
    }

    public static GameState newGame() {
        GameState state = new GameState();
        state.setCurrentRoomId("start");
        return state;
    }
}