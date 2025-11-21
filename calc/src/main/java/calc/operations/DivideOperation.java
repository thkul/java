package calc.operations;

public class DivideOperation implements Operation {
  @Override
  public double apply(double... numbers) {
    if (numbers.length == 0)
      throw new ArithmeticException("No numbers to divide");
    double result = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] == 0)
        throw new ArithmeticException("Cannot divide by zero");
      result /= numbers[i];
    }
    return result;
  }

  @Override
  public String getName() {
    return "divide";
  }
}
