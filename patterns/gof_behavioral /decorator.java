package patterns.gof_behavioral;

public class decorator {
  interface Payable {
    void pay(double amount);
  }

  class StripePaymentProcessor implements Payable {
    @Override
    public void pay(double amount) {
      System.out.println("Stripe: processing " + amount);
    }
  }

  // decorator
  class LoggingPaymentDecorator implements Payable {
    private final Payable wrappee;
    public LoggingPaymentDecorator(Payable wrappee) {
      this.wrappee = wrappee;
    }
    @Override
    public void pay(double amount) {
      System.out.println("[LOG] Payment started: " + amount);
      wrappee.pay(amount);
      System.out.println("[LOG] Payment finished: " + amount);
    }
  }
}

Payable processor = new LoggingPaymentDecorator(new StripePaymentProcessor());
processor.pay(100.0);




