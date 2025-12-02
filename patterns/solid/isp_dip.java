package patterns;

// Interface Segregation Principle: 
// Do not force a Client to implement methods it does not need.
// Dependency Inversion Principle: 
// Higher-level Modules must not depend on lower-level details.

public class isp_dip {
  // pattern ISP
  interface Payable { void pay(double amount); }

  interface Refundable { void refund(String paymentId); }

  class StripeProcessor implements Payable, Refundable {
    @Override
    public void pay(double amount) { System.out.println("Stripe: pay " + amount); }
    @Override
    public void refund(String paymentId) { System.out.println("Stripe: refund"); }
  }

  class FreePaymentProcessor implements Payable {
    @Override
    public void pay(double amount) { System.out.println("Free: pay"); }
  }

  // anti-pattern
  interface PaymentGateway {
    void pay(double amount);
    void refund(String paymentId);
  }

  class FreePaymentProcessor2 implements PaymentGateway {
    @Override
    public void pay(double amount) { System.out.println("Free payment processed"); }
    @Override
    public void refund(String paymentId) { throw new RuntimeException("Free can't refund"); }
  }

  // pattern DIP
  interface PaymentProcessor { void pay(double amount); }

  class StripePayment implements PaymentProcessor {
    public void pay(double amount) { System.out.println("Paying via Stripe"); }
  }

  class OrderService {
    private final PaymentProcessor payment;
    OrderService(PaymentProcessor payment) { this.payment = payment; }
    void placeOrder(double amount) { payment.pay(amount); }
  }

  // anti-pattern
  class StripePayment2 {
    void pay(double amount) { System.out.println("Paying via Stripe: " + amount); }
  }

  class OrderService2 {
    private final StripePayment payment;
    OrderService2() { this.payment = new StripePayment(); }
    void placeOrder(double amount) { payment.pay(amount); }
  }
}
