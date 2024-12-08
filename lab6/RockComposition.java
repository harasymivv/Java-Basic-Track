package lab6;

// Descendant class: Rock Composition
public class RockComposition extends MusicComposition {
  private String guitarType;  // Type of guitar

  public RockComposition(String title, String artist, int duration, 
                         String style, String guitarType) {
      super(title, artist, duration, style);
      this.guitarType = guitarType;
  }

  @Override
  public String getInfo() {
      return String.format("Rock Composition: %s by %s, Duration: %d sec, Guitar: %s", 
                           getTitle(), getArtist(), getDuration(), guitarType);
  }

  public String getGuitarType() { return guitarType; }
}
