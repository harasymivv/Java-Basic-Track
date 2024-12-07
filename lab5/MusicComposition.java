package lab5;

// Abstract parent class for music compositions
public abstract class MusicComposition {
  private String title;       // Composition title
  private String artist;      // Artist name
  private int duration;       // Duration in seconds
  private String style;       // Music style

  /**
   * Constructor for creating a music composition
   * 
   * @param title     composition title
   * @param artist    artist name
   * @param duration  composition duration in seconds
   * @param style     music style
   */
  public MusicComposition(String title, String artist, int duration, String style) {
      this.title = title;
      this.artist = artist;
      this.duration = duration;
      this.style = style;
  }

  // Getters and setters
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getArtist() { return artist; }
  public void setArtist(String artist) { this.artist = artist; }
  public int getDuration() { return duration; }
  public void setDuration(int duration) { this.duration = duration; }
  public String getStyle() { return style; }
  public void setStyle(String style) { this.style = style; }

  /**
   * Abstract method to get detailed information about the composition
   * 
   * @return string with composition information
   */
  public abstract String getInfo();
}
