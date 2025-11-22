package calc.ui;

import java.util.List;
import java.util.Scanner;
import calc.operations.Operation;

public class ConsoleView implements View {
  private final Scanner scanner = new Scanner(System.in);

  @Override
  public void printMenu(List<Operation> operations) {
    System.out.println("=== Menu ===");
    for (int i = 0; i < operations.size(); i++) {
      System.out.println((i + 1) + " - " + operations.get(i).getName());
    }
    System.out.println("0 - Exit");
  }

  @Override
  public void printExit() {
    System.out.println("Exiting calculator. Goodbye!");
  }

  @Override
  public void printError(String message) {
    System.out.println("[Error] " + message);
  }

  @Override
  public void printResult(String operationName, double result, double[] numbers) {
    System.out.println("\n--- Result ---");

    System.out.print(operationName + " of ");
    if (numbers.length == 1) {
      System.out.print(numbers[0]);
    } else {
      for (int i = 0; i < numbers.length; i++) {
        System.out.print(numbers[i]);
        if (i < numbers.length - 1) {
          System.out.print(", ");
        }
      }
    }

    System.out.println(" = " + result);
    System.out.println("--------------\n");
  }

  @Override
  public int readIntWithMin(String prompt, int min) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) {
        System.out.println("Please enter a number.");
        continue;
      }
      try {
        int value = Integer.parseInt(line);
        if (value >= min) {
          return value;
        } else {
          System.out.printf("Please enter a number >= %d.%n", min);
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
  }

  @Override
  public double readDouble(String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) {
        System.out.println("Please enter a number.");
        continue;
      }
      try {
        return Double.parseDouble(line);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }
}
