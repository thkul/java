package calc.operations;

public class MultiplyOperation implements Operation {
  @Override
  public double apply(double... numbers) {
    double result = 1;
    for (double num : numbers) {
      result *= num;
    }
    return result;
  }

  @Override
  public String getName() {
    return "multiply";
  }
}
