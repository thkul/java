package patterns.creational;

// Creates new objects by copying an existing one.

public class prototype {
  class Order implements Cloneable {
    String product;
    int quantity;
    Order(String product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }
    public Order clone() {
      return new Order(product, quantity);
    }
    public String toString() {
      return product + " x" + quantity;
    }
  }

  public static void main(String[] args) {
    Order original = new Order("Book", 2);
    Order copy = original.clone();

    copy.quantity = 5;

    System.out.println(original);
    System.out.println(copy);
  }
}
