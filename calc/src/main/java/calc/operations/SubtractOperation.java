package calc.operations;

public class SubtractOperation implements Operation {
  @Override
  public double apply(double... numbers) {
    if (numbers.length == 0)
      return 0;
    double result = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      result -= numbers[i];
    }
    return result;
  }

  @Override
  public String getName() {
    return "subtract";
  }
}
