package patterns.gof_behavioral;

// Strategy = “behavior as a pluggable module”. You extract an algorithm into 
// separate independent strategies and inject the needed one at runtime.

class strategy {
  // Strategy interface
  public interface PaymentStrategy { void pay(double amount); }

  // Concrete Strategies
  class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
      System.out.println("Paid " + amount + " using Credit Card");
    }
  }

  class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
      System.out.println("Paid " + amount + " using PayPal");
    }
  }

  // Context
  class CheckoutService {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void processOrder(double amount) {
      if (strategy == null) {
        throw new IllegalStateException("Payment strategy is not selected");
      }
      strategy.pay(amount);
    }
  }
}
