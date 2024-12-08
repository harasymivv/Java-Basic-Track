package lab6;

import java.util.Arrays;
import java.util.Comparator;

// Class for managing album
public class MusicAlbum {
    private MusicComposition[] compositions;

    /**
     * Constructor for creating an album
     * 
     * @param compositions array of music compositions
     * @throws IllegalArgumentException if array is empty
     */
    public MusicAlbum(MusicComposition[] compositions) {
        if (compositions == null || compositions.length == 0) {
            throw new IllegalArgumentException("Album must contain at least one composition");
        }
        this.compositions = compositions;
    }

    /**
     * Calculate total album duration
     * 
     * @return total duration in seconds
     */
    public int calculateTotalDuration() {
        int totalDuration = 0;
        for (MusicComposition composition : compositions) {
            totalDuration += composition.getDuration();
        }
        return totalDuration;
    }

    /**
     * Sort compositions by music style
     */
    public void sortByStyle() {
        Arrays.sort(compositions, Comparator.comparing(MusicComposition::getStyle));
    }

    /**
     * Find compositions within given duration range
     * 
     * @param minDuration minimum duration
     * @param maxDuration maximum duration
     * @return array of compositions matching the range
     */
    public MusicComposition[] findCompositionsByDuration(int minDuration, int maxDuration) {
        return Arrays.stream(compositions)
                     .filter(c -> c.getDuration() >= minDuration && c.getDuration() <= maxDuration)
                     .toArray(MusicComposition[]::new);
    }

    /**
     * Print information about all album compositions
     */
    public void printAlbumInfo() {
        for (MusicComposition composition : compositions) {
            System.out.println(composition.getInfo());
        }
    }
}