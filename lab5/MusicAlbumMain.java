package lab5;

public class MusicAlbumMain {
    public static void main(String[] args) {

        int C13 = 4%13;
        System.out.println("C13 = " + C13 );

        try {
            // Creating compositions of different types
            MusicComposition[] compositions = {
                new RockComposition("Stairway to Heaven", "Led Zeppelin", 480, "Rock", "Electric Guitar"),
                new ClassicalComposition("Symphony No. 5", "Beethoven", 420, "Classical", "Vienna Philharmonic"),
                new ElectronicComposition("Strobe", "Deadmau5", 360, "Electronic", "Roland TB-303")
            };

            // Creating album
            MusicAlbum album = new MusicAlbum(compositions);

            // Demonstrating functionality
            System.out.println("Album Total Duration: " + album.calculateTotalDuration() + " seconds");
            
            System.out.println("\nOriginal Album:");
            album.printAlbumInfo();

            album.sortByStyle();
            System.out.println("\nAlbum Sorted by Style:");
            album.printAlbumInfo();

            System.out.println("\nCompositions between 300-500 seconds:");
            MusicComposition[] filteredCompositions = album.findCompositionsByDuration(400, 500);
            for (MusicComposition comp : filteredCompositions) {
                System.out.println(comp.getInfo());
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}