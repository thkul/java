package calc.operations;

public class DivisionOperation implements Operation {
  @Override
  public String getName() {
    return "Division";
  }

  @Override
  public int getRequiredArgCount() {
    return 2;
  }

  @Override
  public void validate(double... numbers) {
    if (numbers[1] == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
  }

  @Override
  public double apply(double... numbers) {
    return numbers[0] / numbers[1];
  }
}
