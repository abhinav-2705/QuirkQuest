package com.quirkquest.engine;

import com.quirkquest.model.GameState;
import com.quirkquest.model.Room;
import com.quirkquest.model.Item;

public class ActionHandler {
    public static void handle(GameState state, CommandParser.ParsedCommand command) {
        switch (command.verb) {
            case "go":
                handleMovement(state, command.target);
                break;
            case "take":
                handleTakeItem(state, command.target);
                break;
            case "look":
                displayRoomDescription(state);
                break;
            case "inventory":
                displayInventory(state);
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                System.out.println("I don't understand that command.");
        }
    }

    private static void handleMovement(GameState state, String direction) {
        Room currentRoom = JSONLoader.getRoom(state.getCurrentRoomId());
        String newRoomId = currentRoom.getExits().get(direction);
        
        if (newRoomId != null) {
            state.setCurrentRoomId(newRoomId);
            displayRoomDescription(state);
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private static void handleTakeItem(GameState state, String itemId) {
        Room currentRoom = JSONLoader.getRoom(state.getCurrentRoomId());
        Item item = JSONLoader.getItem(itemId);
        
        if (item != null && currentRoom.getItems().contains(itemId) && item.isPortable()) {
            state.getInventory().add(itemId);
            currentRoom.getItems().remove(itemId);
            System.out.println("You took the " + itemId);
        } else {
            System.out.println("You can't take that!");
        }
    }

    private static void displayRoomDescription(GameState state) {
        Room room = JSONLoader.getRoom(state.getCurrentRoomId());
        System.out.println(room.getDescription());
        if (!room.getItems().isEmpty()) {
            System.out.println("Items here: " + String.join(", ", room.getItems()));
        }
    }

    private static void displayInventory(GameState state) {
        if (state.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + String.join(", ", state.getInventory()));
        }
    }
}