package calc.ui;

import java.util.List;
import calc.operations.Operation;

public interface View {
  void printMenu(List<Operation> operations);

  void printExit();

  void printError(String message);

  void printResult(String operationName, double result, double[] numbers);

  int readIntWithMin(String prompt, int min);

  double readDouble(String prompt);
}
