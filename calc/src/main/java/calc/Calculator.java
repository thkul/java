package calc;

import calc.operations.Operation;
import java.util.List;

public class Calculator {
  private final List<Operation> operations;

  public Calculator(List<Operation> operations) {
    this.operations = operations;
  }

  public double performOperation(Operation operation, double... numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("No numbers provided");
    }
    return operation.execute(numbers);
  }

  public List<Operation> getOperations() {
    return operations;
  }
}
