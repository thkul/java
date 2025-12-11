package patterns.gof_behavioral;


// The skeleton is fixed, the details are customizable.
// You define a general algorithm in a base class, 
// and allow subclasses to override specific steps.

public class template {
  // The skeleton of the algorithm
  abstract class DataImporter {
    // Template Method (final avoids overriding flow)
    public final void importData() {
      readData();
      transformData();
      saveData();
    }
    protected abstract void readData(); // customizable step
    protected abstract void transformData(); // customizable step
    protected void saveData() { // shared default behavior
      System.out.println("Saving data...");
    }
  }

  // Concrete variation 1
  class CsvImporter extends DataImporter {
    @Override
    protected void readData() {
      System.out.println("Reading CSV file...");
    }
    @Override
    protected void transformData() {
      System.out.println("Transforming CSV data...");
    }
  }

  // Concrete variation 2
  class ApiImporter extends DataImporter {
    @Override
    protected void readData() {
      System.out.println("Fetching data from API...");
    }
    @Override
    protected void transformData() {
      System.out.println("Parsing API response...");
    }
  }
}
