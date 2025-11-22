package calc.operations;

public class SubtractionOperation implements Operation {
  @Override
  public String getName() {
    return "Subtraction";
  }

  @Override
  public int getRequiredArgCount() {
    return 2;
  }

  @Override
  public double apply(double... numbers) {
    return numbers[0] - numbers[1];
  }
}
