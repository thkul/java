package patterns.grasp;

// Assign responsibility for creating an instance of a class to the class that holds the required data.

public class creator {
  class Product {
    private final String name;
    Product(String name) {
      this.name = name;
    }
    public String getName() {
      return name;
    }
  }

  class Order {
    private final Product product;
    Order(Product product) {
      this.product = product;
    }
    public Product getProduct() {
      return product;
    }
  }

  // Creator assigns the responsibility of creating the Product to Order
  public class creator {
    public static void main(String[] args) {
      Product p = new Product("Book");
      Order o = new Order(p);
      System.out.println("Order contains: " + o.getProduct().getName());
    }
  }
}
