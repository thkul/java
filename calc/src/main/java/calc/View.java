package calc;

import java.util.List;
import java.util.Scanner;
import calc.operations.Operation;

public class View {
  private final Scanner scanner;

  public View(Scanner scanner) {
    this.scanner = scanner;
  }

  public void print(String str) {
    System.out.println(str);
  }

  public void wrongAnswer() {
    System.out.println("Wrong decision, BOOM!");
  }

  public void exiting() {
    System.out.println("Exiting...");
  }

  public int readInt(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public double readDouble(String prompt) {
    System.out.print(prompt);
    return scanner.nextDouble();
  }

  public void printResult(String operationName, double result) {
    System.out.println("\n----------------------------");
    System.out.println("Operation: " + operationName);
    System.out.println("Result: " + result);
    System.out.println("----------------------------\n");
  }

  public void printOptions(List<Operation> operations) {
    System.out.println("\nPlease choose an operation:");
    System.out.println("0) Exit");
    for (int i = 0; i < operations.size(); i++) {
      System.out.println((i + 1) + ") " + operations.get(i).getName());
    }
    System.out.print("Please enter an option: ");
  }
}
