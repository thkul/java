package calc;

import calc.operations.OperationFactory;
import calc.ui.*;

public class App {
  public static void main(String[] args) {
    Calculator calculator = new Calculator(OperationFactory.createAll());
    View view = new ConsoleView();
    Controller menu = new Controller(view, calculator);
    menu.run();
  }
}
