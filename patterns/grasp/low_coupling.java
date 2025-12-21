package patterns.grasp;

// Minimize dependencies between classes to reduce changes in one affecting others.

public class low_coupling {
  // Low Coupling: Deligates responsibility to separate services.
  class PaymentService {
    public void processPayment(double amount) { System.out.println("Processing payment of $" + amount); }
  }

  class InventoryService {
    public boolean isProductAvailable(String product) { return true; } // Simulate availability
    class Order {
      private String product; private int quantity; private PaymentService paymentService; private InventoryService inventoryService;
      Order(String product, int quantity, PaymentService paymentService, InventoryService inventoryService) {
        this.product = product; 
        this.quantity = quantity; 
        this.paymentService = paymentService; 
        this.inventoryService = inventoryService;
      }
      public void placeOrder() {
        if (inventoryService.isProductAvailable(product)) {
          paymentService.processPayment(quantity * 50);
          System.out.println("Order placed: " + product + " x" + quantity);
        } else {
          System.out.println("Product out of stock.");
        }
      }
    }
  }

  // anti-pattern: Order depends directly on services (high coupling).
  class HighCouplingOrder {
    private String product; private int quantity;
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void placeOrder() {
      PaymentService paymentService = new PaymentService();
      InventoryService inventoryService = new InventoryService();
      if (inventoryService.isProductAvailable(product)) {
        paymentService.processPayment(quantity * 50);
        System.out.println("Order placed: " + product + " x" + quantity);
      } else {
        System.out.println("Product out of stock.");
      }
    }
  }
}
