package patterns.grasp;

// Assign responsibility for handling system events to a controller class.

public class controller {
  class Order {
    private final String product;
    private final int quantity;
    Order(String product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }

    public String getProduct() {
      return product;
    }
    public int getQuantity() {
      return quantity;
    }
  }

  class OrderController {
    private Order order;
    public void createOrder(String product, int quantity) {
      order = new Order(product, quantity); // Controller creates the Order
    }
    public void showOrderDetails() {
      System.out.println("Product: " + order.getProduct());
      System.out.println("Quantity: " + order.getQuantity());
    }
  }

    public static void main(String[] args) {
      OrderController controller = new OrderController();
      controller.createOrder("Book", 2);
      controller.showOrderDetails();
    }
  }
