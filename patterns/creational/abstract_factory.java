package patterns.creational;

// Provides an interface for creating families of related objects.

public class abstract_factory {

  interface Button { void click(); }

  class WindowsButton implements Button {
    public void click() { 
      System.out.println("Windows Button clicked"); 
    }
  }

  class MacButton implements Button {
    public void click() { 
      System.out.println("Mac Button clicked"); 
    }
  }

  // Abstract Factory
  interface GUIFactory {
    Button createButton();
  }

  // Concrete Factories
  class WindowsFactory implements GUIFactory {
    public Button createButton() { 
      return new WindowsButton(); 
    }
  }

  class MacFactory implements GUIFactory {
    public Button createButton() {
      return new MacButton();
    }
  }
 }
