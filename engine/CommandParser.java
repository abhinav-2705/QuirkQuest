package com.quirkquest.engine;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private static final List<String> VERBS = Arrays.asList(
        "go", "take", "drop", "use", "look", "inventory", "quit"
    );

    public static ParsedCommand parse(String input) {
        String[] parts = input.toLowerCase().split("\\s+");
        if (parts.length == 0) return null;

        String verb = findVerb(parts);
        if (verb == null) return null;

        String target = input.substring(verb.length()).trim();
        return new ParsedCommand(verb, target);
    }

    private static String findVerb(String[] parts) {
        for (String word : parts) {
            if (VERBS.contains(word)) {
                return word;
            }
        }
        return null;
    }

    public static class ParsedCommand {
        public final String verb;
        public final String target;

        public ParsedCommand(String verb, String target) {
            this.verb = verb;
            this.target = target;
        }
    }
}