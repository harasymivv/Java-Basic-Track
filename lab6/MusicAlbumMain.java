package lab6;

import java.util.ArrayList;
import java.util.List;

public class MusicAlbumMain {

    public static void main(String[] args) {

        int C2 = 4%2;
        int C3 = 4%3;
    
        System.out.println("C2 = " + C2 + "\nC3 = " + C3 );

        // Create music compositions
        RockComposition rock1 = new RockComposition("Stairway", "Led Zeppelin", 480, "Rock", "Electric");
        RockComposition rock2 = new RockComposition("Sweet Child O' Mine", "Guns N' Roses", 356, "Rock", "Les Paul");
        ClassicalComposition classical = new ClassicalComposition("Symphony No. 5", "Beethoven", 420, "Classical", "Berlin Philharmonic");
        ElectronicComposition electronic = new ElectronicComposition("Strobe", "Deadmau5", 360, "Electronic", "TB-303");

        // Demonstrate different constructors
        System.out.println("--- Constructor Demonstrations ---");
        
        // Empty list constructor
        MusicCompositionList<MusicComposition> emptyList = new MusicCompositionList<>();
        System.out.println("Empty list size: " + emptyList.size());
        
        // Single element constructor
        MusicCompositionList<MusicComposition> singleElementList = new MusicCompositionList<>(rock1);
        System.out.println("Single element list size: " + singleElementList.size());

        // Collection constructor
        List<MusicComposition> initialCollection = new ArrayList<>();
        initialCollection.add(rock2);
        initialCollection.add(classical);
        
        // Demonstrate basic list operations
        System.out.println("\n--- Basic List Operations ---");
        MusicCompositionList<MusicComposition> list = new MusicCompositionList<>();
        
        // add() method
        list.add(rock1);
        list.add(classical);
        list.add(electronic);
        System.out.println("List size after adding: " + list.size());
        
        // get() method
        System.out.println("First composition: " + list.get(0).getInfo());
        
        // contains() method
        System.out.println("Contains rock1: " + list.contains(rock1));
        
        // indexOf() method
        System.out.println("Index of classical: " + list.indexOf(classical));
        
        // remove() methods
        System.out.println("\n--- Remove Operations ---");
        list.remove(classical);
        System.out.println("Size after removing classical: " + list.size());
        
        // add at index
        list.add(1, electronic);
        System.out.println("Composition at index 1 after insertion: " + list.get(1).getInfo());
        
        // iterator demonstration
        System.out.println("\n--- Iterator Demonstration ---");
        System.out.println("Iterating through list:");
        for (MusicComposition comp : list) {
            System.out.println(comp.getInfo());
        }
        
        // toArray() method
        System.out.println("\n--- toArray() Demonstration ---");
        Object[] compositionArray = list.toArray();
        System.out.println("Array length: " + compositionArray.length);
        
        // addAll() method
        System.out.println("\n--- addAll() Demonstration ---");
        List<MusicComposition> additionalCompositions = new ArrayList<>();
        additionalCompositions.add(rock2);
        list.addAll(additionalCompositions);
        System.out.println("List size after addAll(): " + list.size());
        
        // subList() method
        System.out.println("\n--- subList() Demonstration ---");
        List<MusicComposition> subList = list.subList(1, 3);
        System.out.println("Sublist size: " + subList.size());
        for (MusicComposition comp : subList) {
            System.out.println(comp.getInfo());
        }
        
        // Utility method demonstrations
        System.out.println("\n--- Utility Methods ---");
        System.out.println("Is list empty? " + list.isEmpty());
        list.clear();
        System.out.println("Size after clear(): " + list.size());
        System.out.println("Is list now empty? " + list.isEmpty());
    }
}