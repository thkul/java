package patterns.creational;

// Guarantees exactly one instance of a class and a global access point to it.

public class singleton {
  class Logger {
    private static Logger instance;
    private Logger() {
    } // prevent direct creation
    public static Logger getInstance() {
      if (instance == null) {
        instance = new Logger();
      }
      return instance;
    }
    public void log(String msg) {
      System.out.println("[LOG] " + msg);
    }
  }

  public static void main(String[] args) {
    Logger l1 = Logger.getInstance();
    Logger l2 = Logger.getInstance();

    l1.log("Hello");
    System.out.println(l1 == l2); // true
  }
}
