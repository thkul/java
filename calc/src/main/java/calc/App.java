package calc;

public class App {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    View view = new View(new java.util.Scanner(System.in));

    Menu menu = new Menu(view, calculator);
    menu.run();
  }
}

// view жорстко привʼязане до консольного сканеру
// чому взагалі Вью оперує сканером? Треба перевірити, щоб всі модулі програми
// були незалежні
