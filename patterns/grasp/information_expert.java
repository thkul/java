package patterns.grasp;

// Assign responsibility to the class that has the needed data.

public class information_expert {
  class Order {
    private final int quantity;
    private final double price;
    Order(int quantity, double price) {
      this.quantity = quantity;
      this.price = price;
    }
    double total() {
      return quantity * price; // Order has the data → Order calculates
    }
  }

  class OrderService {
    double calculateTotal(Order o) {
      return o.total(); // delegates to the expert
    }
  }

  public class information_expert {
    public static void main(String[] args) {
      Order o = new Order(2, 50);
      System.out.println(o.total());
    }
  }
}
