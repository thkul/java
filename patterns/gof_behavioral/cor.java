package patterns.gof_behavioral;

// A request moves through a chain of handlers, 
// each deciding to process it or pass it further.

// Base handler
abstract class Handler {
  private Handler next;
  public Handler next(Handler n) { this.next = n; return n;
}
  public void handle(double amount) {
    if (!check(amount)) return;
    if (next != null) next.handle(amount);
  }
  protected abstract boolean check(double amount);
}

// 1st Handler: validates amount > 0
class PositiveAmountHandler extends Handler {
  protected boolean check(double amount) {
    if (amount <= 0) {
      System.out.println("Error: amount must be positive");
      return false;
    }
    System.out.println("Amount OK");
    return true;
  }
}

// 2nd Handler: executes payment
class PaymentHandler extends Handler {
  protected boolean check(double amount) {
    System.out.println("Processing payment: " + amount);
    return true; // end of chain
  }
}

public class cor {
  public static void main(String[] args) {
    Handler chain = new PositiveAmountHandler()
        .next(new PaymentHandler());
    chain.handle(150); // valid
    chain.handle(-10); // rejected
  }
}
