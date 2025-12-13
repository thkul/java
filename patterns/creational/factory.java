package patterns.creational;

// Defines an interface for creating objects, but lets subclasses decide 
// which concrete class to instantiate. Creation logic is moved out of client code.

public class factory {

  // Creates objects via a factory method, not via new.
  interface PaymentProcessor {
    void process(double amount);
  }

  class StripeProcessor implements PaymentProcessor {
    public void process(double amount) { 
      System.out.println("Stripe processing " + amount); 
    }
  }

  class PaypalProcessor implements PaymentProcessor {
    public void process(double amount) { 
      System.out.println("PayPal processing " + amount); 
    }
  }

  abstract class PaymentService { // Creator
    public void pay(double amount) {
      PaymentProcessor p = createProcessor(); p.process(amount);
    }
    protected abstract PaymentProcessor createProcessor();
  }

  class StripePaymentService extends PaymentService { // Concrete creators
    protected PaymentProcessor createProcessor() { return new StripeProcessor(); }
  }

  class PaypalPaymentService extends PaymentService {
    protected PaymentProcessor createProcessor() { return new PaypalProcessor(); }
  }

  public static void main(String[] args) {
    PaymentService s1 = new StripePaymentService();
    PaymentService s2 = new PaypalPaymentService();
    s1.pay(100); s2.pay(200);
  }
}
