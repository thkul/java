package calc.operations;

import java.util.List;

public class OperationFactory {
  public static List<Operation> createAll() {
    return List.of(
        new AdditionOperation(),
        new SubtractionOperation(),
        new MultiplicationOperation(),
        new DivisionOperation());
  }
}
