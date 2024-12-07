package lab5;

// Descendant class: Electronic Composition
public class ElectronicComposition extends MusicComposition {
  private String synthesizer;  // Used synthesizer

  public ElectronicComposition(String title, String artist, int duration, 
                               String style, String synthesizer) {
      super(title, artist, duration, style);
      this.synthesizer = synthesizer;
  }

  @Override
  public String getInfo() {
      return String.format("Electronic Composition: %s by %s, Duration: %d sec, Synth: %s", 
                           getTitle(), getArtist(), getDuration(), synthesizer);
  }

  public String getSynthesizer() { return synthesizer; }
}