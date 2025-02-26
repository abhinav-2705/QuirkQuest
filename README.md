## QuirkQuest: Java-Based Interactive Text Adventure Engine

# Overview
"QuirkQuest" is a lightweight, modular engine for creating text-based adventure games. It allows developers to design interactive stories using JSON files, eliminating the need for hardcoding game content. Players navigate through rooms, collect items, and solve puzzles using simple text commands like go north or take key.

# Key Features
JSON-Driven Content
Define rooms, items, and game logic in JSON files.
Modify game content without recompiling code.
Command Parsing

Supports verbs like go, take, use, and look.
Extensible system for adding custom commands.
Dynamic State Management

Track player inventory, room states, and game flags.
Save/load functionality (easily extendable).
Modular Architecture

Clear separation between engine logic and game content.
Easy to add new features (e.g., combat, NPC dialogue).

# Technical Components
Java 17+: Core logic and object-oriented design.
Jackson Library: Parse JSON files into Java objects.
Maven Build System: Dependency management and packaging.

# How It Works
Game Data: Rooms, items, and initial state are defined in JSON files.
Command Input: Players type commands (e.g., take key).
Engine Processing:
Parses commands.
Updates game state (inventory, room changes).
Renders descriptions and outcomes.

# Use Cases
Create retro-style text adventures.
Teach programming concepts (OOP, JSON parsing).
Prototype game narratives quickly.
