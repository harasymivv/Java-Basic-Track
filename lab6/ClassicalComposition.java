package lab6;

// Descendant class: Classical Composition
public class ClassicalComposition extends MusicComposition {
  private String orchestra;  // Orchestra name

  public ClassicalComposition(String title, String artist, int duration, 
                              String style, String orchestra) {
      super(title, artist, duration, style);
      this.orchestra = orchestra;
  }

  @Override
  public String getInfo() {
      return String.format("Classical Composition: %s by %s, Duration: %d sec, Orchestra: %s", 
                           getTitle(), getArtist(), getDuration(), orchestra);
  }

  public String getOrchestra() { return orchestra; }
}