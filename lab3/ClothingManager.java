package lab3;

import java.util.Arrays;
import java.util.Comparator;



/**
 * Class to demonstrate operations with an array of clothing objects.
 */
public class ClothingManager {
    /**
     * Main method to perform operations on an array of clothing items.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        int C11 = 4%11;
        System.out.println("C11 = " + C11);
        // Create an array of clothing objects
        Clothing[] clothes = {
            new Clothing("T-Shirt", "Nike", 29.99, "White", "M"),
            new Clothing("Jeans", "Levi's", 89.50, "Blue", "L"),
            new Clothing("Jacket", "Adidas", 129.99, "Black", "XL"),
            new Clothing("Shorts", "Zara", 39.99, "Gray", "S"),
            new Clothing("Sweatshirt", "H&M", 49.99, "Green", "M")
        };

        // Display the initial array
        System.out.println("Initial array:");
        printArray(clothes);

        // Sort by price in ascending order, then by brand in descending order
        Arrays.sort(clothes, new Comparator<Clothing>() {
            @Override
            public int compare(Clothing c1, Clothing c2) {
                // Compare by price (ascending order)
                int priceComparison = Double.compare(c1.getPrice(), c2.getPrice());
                if (priceComparison != 0) {
                    return priceComparison;
                }
                // If prices are equal, compare by brand (descending order)
                return c2.getBrand().compareTo(c1.getBrand());
            }

        });

                
        // Display the sorted array
        System.out.println("\nSorted array (by price ascending, then brand descending):");
        printArray(clothes);

        // Create a reference object for searching
        Clothing searchClothing = new Clothing("Jacket", "Adidas", 129.99, "Black", "XL");

        // Search for the object in the array
        int index = findClothing(clothes, searchClothing);

        // Display the search result
        if (index != -1) {
            System.out.println("\nFound object:");
            System.out.println(clothes[index]);
        } else {
            System.out.println("\nObject not found.");
        }

    }

    /**
     * Method to display an array of clothing items.
     * 
     * @param clothes Array to display
     */
    private static void printArray(Clothing[] clothes) {
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }
    }

     /**
     * Method to search for an object in the array.
     * 
     * @param clothes Array to search
     * @param searchClothing Object to find
     * @return Index of the found object or -1 if not found
     */
    private static int findClothing(Clothing[] clothes, Clothing searchClothing) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i].equals(searchClothing)) {
                return i;
            }
        }
        return -1;
    }
}
