package calc;

import calc.operations.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private final List<Operation> operations;

  public Calculator() {
    operations = new ArrayList<>();
    operations.add(new AddOperation());
    operations.add(new SubtractOperation());
    operations.add(new MultiplyOperation());
    operations.add(new DivideOperation());
  }

  public List<Operation> getOperations() {
    return operations;
  }

  public double performOperation(String operationName, double... numbers) {
    for (Operation operation : operations) {
      if (operation.getName().equals(operationName)) {
        return operation.apply(numbers);
      }
    }
    throw new IllegalArgumentException("Unknown operation");
  }
}
