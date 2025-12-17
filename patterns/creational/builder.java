package patterns.creational;

// Builds a complex object step by step.

public class builder {
  class Order {
    private final String product;
    private final int quantity;
    private Order(Builder b) {
      product = b.product;
      quantity = b.quantity;
    }
    public String toString() {
      return product + " x" + quantity;
    }

    static class Builder {
      String product;
      int quantity = 1;
      Builder product(String p) {
        product = p;
        return this;
      }
      Builder quantity(int q) {
        quantity = q;
        return this;
      }
      Order build() {
        return new Order(this);
      }
    }
  }

  public class builder {
    public static void main(String[] args) {
      Order o = new Order.Builder()
          .product("Book")
          .quantity(2)
          .build();
    }
  }
}
