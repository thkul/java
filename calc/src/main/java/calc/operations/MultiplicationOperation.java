package calc.operations;

import java.util.Arrays;

public class MultiplicationOperation implements Operation {
  @Override
  public String getName() {
    return "Multiplication";
  }

  @Override
  public int getRequiredArgCount() {
    return -1;
  }

  @Override
  public double apply(double... numbers) {
    return Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
  }
}
