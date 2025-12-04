package patterns.gof_behavioral;

// An object that controls access to another object — lazy loading, caching, protection, logging

public class proxy {
  // Subject interface
  public interface Image {
    void display();
  }

  // Real subject
  public class RealImage implements Image {
    private final String filename;
    public RealImage(String filename) {
      this.filename = filename;
      loadFromDisk();
    }
    private void loadFromDisk() {
      System.out.println("Loading " + filename);
    }
    @Override
    public void display() {
      System.out.println("Displaying " + filename);
    }
  }

  // Proxy
  public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;
    public ProxyImage(String filename) {
      this.filename = filename;
    }
    @Override
    public void display() {
      if (realImage == null) {
        realImage = new RealImage(filename); // lazy load
      }
      System.out.println("[Proxy] Delegating display...");
      realImage.display();
    }
  }
}
