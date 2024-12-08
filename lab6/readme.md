# Music Composition List Management System

## Project Overview

This Java project implements a custom generic linked list (`MusicCompositionList`) specifically designed for managing music compositions. 

## Key Features

- Custom generic linked list implementation
- Support for different types of music compositions
- Full implementation of Java `List` interface methods
- Type-safe handling of `MusicComposition` objects
- Advanced list operations and traversal

## Prerequisites

- **Java Development Kit (JDK)** installed on your system
- **Visual Studio Code (VS Code)**
- VS Code Extension: **Extension Pack for Java**

## Building and Running

1. Compile all Java files in the project
2. Run `MusicAlbumMain` as the entry point

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

## Project Structure

The project consists of the following key classes:

- `MusicComposition` (Abstract Base Class)
  - Represents core attributes of a musical composition
  - Defines abstract `getInfo()` method

- Composition Type Classes:
  - `RockComposition`
  - `ClassicalComposition`
  - `ElectronicComposition`

- `MusicCompositionList<T>`
  - Custom generic linked list implementation
  - Implements full `List<T>` interface

## Key Implemented Methods

The `MusicCompositionList` supports numerous list operations:
- `add()`
- `remove()`
- `get()`
- `set()`
- `contains()`
- `indexOf()`
- `iterator()`
- `toArray()`
- Bulk operations like `addAll()`, `removeAll()`