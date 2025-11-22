package calc.operations;

import java.util.Arrays;

public class AdditionOperation implements Operation {
  @Override
  public String getName() {
    return "Addition";
  }

  @Override
  public int getRequiredArgCount() {
    return -1;
  }

  @Override
  public int getMinimumArgCount() {
    return 2;
  }

  @Override
  public void validate(double... numbers) {
    if (numbers.length < 2) {
      throw new IllegalArgumentException("Addition requires at least 2 operands.");
    }
  }

  @Override
  public double apply(double... numbers) {
    return Arrays.stream(numbers).sum();
  }
}
