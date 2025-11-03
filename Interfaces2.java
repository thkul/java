public class Interfaces2 {
  public static void main(String[] args) {
    // Interface that defines a general payment action
    interface Payment {
      void pay(); // any payment method must implement this
    }

    // Implementation for credit card payment
    class CreditCardPayment implements Payment {
      public void pay() {
        System.out.println("Paid with credit card");
      }
    }

    // Implementation for PayPal payment
    class PayPalPayment implements Payment {
      public void pay() {
        System.out.println("Paid with PayPal");
      }
    }

    // Service that performs checkout using any payment method
    class CheckoutService {
      private Payment payment; // stores the payment implementation

      // Constructor — allows choosing which payment method to use
      public CheckoutService(Payment payment) {
        this.payment = payment;
      }

      // Performs checkout logic
      public void checkout() {
        // checkout may include additional logic, not just payment
        System.out.println("Checking order details...");
        System.out.println("Calculating totals...");
        payment.pay(); // delegates payment action to the chosen implementation
      }
    }

    // Create a checkout service with a CreditCardPayment
    CheckoutService c1 = new CheckoutService(new CreditCardPayment());
    c1.checkout(); // calls pay() from CreditCardPayment

    // Create a checkout service with a PayPalPayment
    CheckoutService c2 = new CheckoutService(new PayPalPayment());
    c2.checkout(); // calls pay() from PayPalPayment
  }
}

/*
 * Why create a separate checkout() method instead of calling pay() directly:
 * - checkout() represents a higher-level business process (placing an order).
 * - pay() is just one step inside that process.
 * - This allows adding more actions later (validation, logging, stock updates,
 * etc.)
 * without changing the Payment interface or its implementations.
 */
