package com.quirkquest;

import com.quirkquest.engine.CommandParser;
import com.quirkquest.engine.JSONLoader;
import com.quirkquest.engine.ActionHandler;
import com.quirkquest.model.GameState;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameState state = JSONLoader.newGame();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to QuirkQuest!\n");
        ActionHandler.displayRoomDescription(state);

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine();
            
            CommandParser.ParsedCommand command = CommandParser.parse(input);
            if (command == null) {
                System.out.println("Invalid command!");
                continue;
            }
            
            ActionHandler.handle(state, command);
        }
    }
}