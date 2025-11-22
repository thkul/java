package calc;

import calc.operations.Operation;
import calc.ui.View;

public class Controller {
  private final Calculator calculator;
  private final View view;

  public Controller(View view, Calculator calculator) {
    this.calculator = calculator;
    this.view = view;
  }

  public void run() {
    while (true) {
      view.printMenu(calculator.getOperations());
      int choice = readMenuChoice();

      if (choice == 0) {
        view.printExit();
        break;
      }

      Operation operation = calculator.getOperations().get(choice - 1);
      double[] numbers = readOperands(operation);

      try {
        double result = calculator.performOperation(operation, numbers);
        view.printResult(operation.getName(), result, numbers);
      } catch (Exception e) {
        view.printError("[Error] " + e.getMessage());
      }
    }
  }

  private int readMenuChoice() {
    int maxOption = calculator.getOperations().size();
    while (true) {
      int choice = view.readIntWithMin("Choose option (0 for exit): ", 0);
      if (choice == 0 || (choice >= 1 && choice <= maxOption)) {
        return choice;
      }
      view.printError("Invalid option. Please enter a number between 0 and " + maxOption + ".");
    }
  }

  private double[] readOperands(Operation operation) {
    int required = operation.getRequiredArgCount();
    if (required == -1) {
      int min = operation.getMinimumArgCount();
      int count = view.readIntWithMin("Enter number of operands: ", min);
      return readNumbers(count);
    }
    return readNumbers(required);
  }

  private double[] readNumbers(int count) {
    double[] numbers = new double[count];
    for (int i = 0; i < count; i++) {
      numbers[i] = view.readDouble("Enter number " + (i + 1) + ": ");
    }
    return numbers;
  }
}
