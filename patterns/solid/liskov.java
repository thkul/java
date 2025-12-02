package patterns;

// Liskov Substitution Principle:
// An object of the parent type must work with any child.

public class liskov {
  public interface PaymentProcessor {
    void process(double amount);
  }

  // pattern
  // Regular payment processor: works with real payments
  class StripeProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) { System.out.println("Stripe: processing " + amount); }
  }

  // Dedicated service for handling free payments
  class FreePaymentService {
    public void process(long orderId) { System.out.println("Processing free order " + orderId); }
  }

  class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final FreePaymentService freePaymentService;

    public OrderService(PaymentProcessor paymentProcessor, FreePaymentService freePaymentService) {
      this.paymentProcessor = paymentProcessor; this.freePaymentService = freePaymentService;
    }

    public void pay(Order order) {
      if (order.getAmount() == 0) { freePaymentService.process(order.getId()); return; }
      paymentProcessor.process(order.getAmount());
    }
  }

  class Order {
    private final long id; private final double amount;
    public Order(long id, double amount) { this.id = id; this.amount = amount; }
    public long getId() { return id; }
    public double getAmount() { return amount; }
  }

  // anti-pattern
  public class FreePaymentProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
      if (amount > 0) {
        throw new IllegalArgumentException("Free payments cannot process positive amounts");
      }
      System.out.println("Processing free payment");
    }
  }
}
