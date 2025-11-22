package calc.operations;

public class SqrtOperation implements Operation {
  @Override
  public String getName() {
    return "Square Root";
  }

  @Override
  public int getRequiredArgCount() {
    return 1;
  }

  @Override
  public void validate(double... numbers) {
    if (numbers[0] < 0) {
      throw new IllegalArgumentException("Cannot take square root of a negative number.");
    }
  }

  @Override
  public double apply(double... numbers) {
    return Math.sqrt(numbers[0]);
  }
}