# Music Album Management Program

## Prerequisites

- **Java Development Kit (JDK)** installed on your system
- **Visual Studio Code (VS Code)**
- VS Code Extension: **Extension Pack for Java**

## Description

This program demonstrates a comprehensive music album management system using object-oriented programming principles in Java. It provides functionality to:

1. Create musical compositions of different types (Rock, Classical, Electronic)
2. Calculate the total duration of an album
3. Sort compositions by music style
4. Find compositions within a specific duration range

The system uses an abstract `MusicComposition` class as a base for three specific composition types, each with unique attributes:
- `RockComposition`: Includes guitar type
- `ClassicalComposition`: Includes orchestra name
- `ElectronicComposition`: Includes synthesizer information

---

## Running the Program in VS Code

1. **Clone or Download the Repository**
   Clone the repository or download the following Java files:
   - `MusicComposition.java`
   - `RockComposition.java`
   - `ClassicalComposition.java`
   - `ElectronicComposition.java`
   - `MusicAlbum.java`
   - `MusicAlbumMain.java`

2. **Open in VS Code**
   - Launch VS Code and navigate to the folder containing the Java files.
   - Open all Java files in the editor.

3. **Run the Program**
   You can run the program using one of the following methods:

   ### Option 1: Using the VS Code "Run" Button
   - Open `MusicAlbumMain.java`.
   - Click the green **Run** button above the `main` method.

   ### Option 2: Using the Terminal
   - Open a terminal in VS Code (`Terminal -> New Terminal`).
   - Navigate to the folder containing the Java files.
   - Compile the Java files:
     ```bash
     javac *.java
     ```
   - Run the compiled program:
     ```bash
     java MusicAlbumMain
     ```

4. **Program Functionality**
   When you run the program, it will:
   - Create an album with three different music compositions
   - Display the total album duration
   - Show the original album composition list
   - Sort compositions by style
   - Display sorted compositions
   - Find and display compositions within a 400-500 second duration range
