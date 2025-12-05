package patterns.gof_behavioral;

// One object broadcasts changes, many objects react

interface OrderSubject {
  void addObserver(OrderObserver observer);
  void removeObserver(OrderObserver observer);
  void notifyObservers(String newStatus);
}

interface OrderObserver { void update(String orderId, String newStatus); }

class OrderStatusTracker implements OrderSubject {
  private final String orderId;
  private final java.util.List<OrderObserver> observers = new java.util.ArrayList<>();
  public OrderStatusTracker(String orderId) { this.orderId = orderId; }
  @Override
  public void addObserver(OrderObserver observer) { observers.add(observer); }
  @Override
  public void removeObserver(OrderObserver observer) { observers.remove(observer); }
  @Override
  public void notifyObservers(String newStatus) {
    for (OrderObserver o : observers) { o.update(orderId, newStatus); }
  }

  // Domain business method
  public void changeStatus(String newStatus) {
    System.out.println("Order " + orderId + " changed status to: " + newStatus);
    notifyObservers(newStatus);
  }
}

// Concrete Observers
class EmailNotifier implements OrderObserver {
  @Override
  public void update(String orderId, String newStatus) {
    System.out.println("EMAIL: Order " + orderId + " is now " + newStatus);
  }
}

class SmsNotifier implements OrderObserver {
  @Override
  public void update(String orderId, String newStatus) {
    System.out.println("SMS: Order " + orderId + " is now " + newStatus);
  }
}
