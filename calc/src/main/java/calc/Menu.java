package calc;

import calc.operations.*;
import java.util.List;

public class Menu {
  private final View view;
  private final Calculator calculator;

  public Menu(View view, Calculator calculator) {
    this.view = view;
    this.calculator = calculator;
  }

  public void run() {
    boolean running = true;

    List<Operation> operations = calculator.getOperations();

    while (running) {
      view.printOptions(operations);
      int choice = view.readInt("");

      if (choice == 0) {
        view.exiting();
        running = false;
      } else {
        Operation operation = operations.get(choice - 1); // Оскільки індексація з 0
        if (operation != null) {
          int numCount = view.readInt("How many numbers would you like to input? ");
          double[] numbers = new double[numCount];
          for (int i = 0; i < numCount; i++) {
            numbers[i] = view.readDouble("Enter number " + (i + 1) + ": ");
          }
          double result = calculator.performOperation(operation.getName(), numbers);
          view.printResult(operation.getName(), result);
        } else {
          view.wrongAnswer();
        }
      }
    }
  }
}
