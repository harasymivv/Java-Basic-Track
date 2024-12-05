# Clothing Management Program

## Prerequisites

- **Java Development Kit (JDK)** installed on your system  
- **Visual Studio Code (VS Code)**  
- VS Code Extension: **Extension Pack for Java**

## Description

This program demonstrates operations on an array of `Clothing` objects. It provides functionality to:

1. Display a list of clothing items.  
2. Sort clothing items by price (ascending) and, in case of ties, by brand (descending).  
3. Search for a specific clothing item based on its attributes.  

Each clothing item is represented by a `Clothing` class, which includes attributes such as type, brand, price, color, and size.

---

## Running the Program in VS Code

1. **Clone or Download the Repository**  
   Clone the repository or download the Java files `Clothing.java` and `ClothingManager.java` into a folder named `lab3`.

2. **Open in VS Code**  
   - Launch VS Code and navigate to the folder containing the Java files.  
   - Open both `Clothing.java` and `ClothingManager.java` in the editor.

3. **Run the Program**  
   You can run the program using one of the following methods:

   ### Option 1: Using the VS Code "Run" Button  
   - Open `ClothingManager.java`.  
   - Click the green **Run** button above the `main` method.

   ### Option 2: Using the Terminal  
   - Open a terminal in VS Code (`Terminal -> New Terminal`).  
   - Navigate to the folder containing the Java files.  
   - Compile the Java files:  
     ```bash
     javac lab3/*.java
     ```  
   - Run the compiled program:  
     ```bash
     java lab3.ClothingManager
     ```

4. **Interact with the Program**  
   - The program will display the initial list of clothing items.  
   - It will then sort the items and display the sorted list.  
   - Finally, it will search for a specific item and display the result of the search.
