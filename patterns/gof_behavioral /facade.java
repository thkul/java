package patterns.gof_behavioral;

public class facade {
  // Subsystem 1
  class PaymentService {
    public void pay(String item, double amount) {
      System.out.println("Processing payment of " + amount + " for " + item);
    }
  }

  // Subsystem 2
  class ShippingService {
    public void ship(String item) {
      System.out.println("Shipping item: " + item);
    }
  }

  // Facade
  public class OrderFacade {
    private final PaymentService payment = new PaymentService();
    private final ShippingService shipping = new ShippingService();
    public void placeOrder(String item, double amount) {
      payment.pay(item, amount);
      shipping.ship(item);
    }
  }
}
