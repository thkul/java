package patterns.gof_behavioral;

// Behavior changes by swapping internal state objects

public class state {
  interface OrderState {  // State interface
    void pay(Order ctx); void ship(Order ctx);
  }

  class Order { // Context
    private OrderState state = new NewState();
    void setState(OrderState s) { state = s; }
    void pay() { state.pay(this); }
    void ship() { state.ship(this); }
  }

  class NewState implements OrderState { // States
    public void pay(Order ctx) {
      System.out.println("Paid.");
      ctx.setState(new PaidState());
    }
    public void ship(Order ctx) {
      System.out.println("Cannot ship: not paid.");
    }
  }

  class PaidState implements OrderState {
    public void pay(Order ctx) { System.out.println("Already paid."); }
    public void ship(Order ctx) {
      System.out.println("Shipped.");
      ctx.setState(new ShippedState());
    }
  }

  class ShippedState implements OrderState {
    public void pay(Order ctx) {
      System.out.println("Cannot pay: shipped.");
    }
    public void ship(Order ctx) {
      System.out.println("Already shipped.");
    }
  }
}
