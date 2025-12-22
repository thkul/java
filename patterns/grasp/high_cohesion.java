package patterns.grasp;

// High Cohesion: Class is focused on a single responsibility.

public class high_cohesion {
  class Order {
    private final String product;
    private final int quantity;
    Order(String product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }
    public void placeOrder() {
      System.out.println("Order placed: " + product + " x" + quantity);
    }
  }

  class PaymentProcessor {
    public void processPayment(Order order) {
      System.out.println("Processing payment for: " + order);
    }
  }

  public static void main(String[] args) {
    Order order = new Order("Book", 2);
    order.placeOrder();

    PaymentProcessor paymentProcessor = new PaymentProcessor();
    paymentProcessor.processPayment(order);
  }
}
