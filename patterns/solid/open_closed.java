package patterns;

// Single Responsibility Principle:
// One class = one job.
// Open-Closed Principle:
// A class should be open for extension but closed for modification.

public class open_closed {
  
  // pattern
  interface PaymentMethod { Receipt process(double amount); }

  public class CreditCardPayment implements PaymentMethod {
    @Override
    public Receipt process(double amount) {
      System.out.println("Charging credit card for " + amount);
      return new Receipt("CREDIT_CARD", amount, "Approved");
    }
  }

  public class PayPalPayment implements PaymentMethod {
    @Override
    public Receipt process(double amount) {
      System.out.println("Processing PayPal payment for " + amount);
      return new Receipt("PAYPAL", amount, "Approved via PayPal");
    }
  }

  public class PaymentHandler {
    public Receipt process(PaymentMethod method, double amount) {
      return method.process(amount);
    }
  }

  public class Receipt {
    private String type; private double amount; private String status;
    public Receipt(String type, double amount, String status) {
      this.type = type; this.amount = amount; this.status = status;
    }
    @Override
    public String toString() {
      return "Receipt{" +
          "type='" + type + '\'' +
          ", amount=" + amount +
          ", status='" + status + '\'' +
          '}';
    }
  }

  // anti-pattern
  class PaymentProcessor {
    public void process(Payment payment) {
      if (payment.getType() == PaymentType.CREDIT_CARD) {
        processCreditCard(payment);
      } else if (payment.getType() == PaymentType.PAYPAL) {
        processPayPal(payment);
      } else if (payment.getType() == PaymentType.CRYPTO) {
        processCrypto(payment);
      }
    }

    private void processCreditCard(Payment p) {
      System.out.println("Processing credit card for amount " + p.getAmount());
    }
    private void processPayPal(Payment p) {
      System.out.println("Processing PayPal for amount " + p.getAmount());
    }
    private void processCrypto(Payment p) {
      System.out.println("Processing crypto for amount " + p.getAmount());
    }
  }

  enum PaymentType { CREDIT_CARD, PAYPAL, CRYPTO }

  class Payment {
    private PaymentType type; private double amount;
    public Payment(PaymentType type, double amount) {
      this.type = type; this.amount = amount;
    }

    public PaymentType getType() { return type; }

    public double getAmount() { return amount; }
  }
}
