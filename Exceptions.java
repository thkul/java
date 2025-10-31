public class Exceptions {
  public static void main(String[] args) {
    // Custom exception with error code
    class InvalidPaymentException extends Exception {
      private final int code; // numeric error code for API
      private final String detail; // optional dynamic detail

      // Constructor with code and dynamic detail
      public InvalidPaymentException(int code, String detail) {
        super("Payment error " + code + ": " + detail); // optional message for logs
        this.code = code;
        this.detail = detail;
      }

      // Constructor with only code
      public InvalidPaymentException(int code) {
        this(code, ""); // empty detail
      }

      public int getCode() {
        return code;
      }

      public String getDetail() {
        return detail;
      }
    }

    // Payment service simulating API behavior
    class PaymentService {
      private double balance = 100;

      // Payment method throws exception with code and detail
      public void pay(double amount) throws InvalidPaymentException {
        if (amount > balance) {
          // dynamic detail included
          throw new InvalidPaymentException(1001, "Insufficient funds: " + balance);
        }
        balance -= amount;
      }

      public double getBalance() {
        return balance;
      }
    }

    // Main simulating API call
    PaymentService service = new PaymentService();

    try {
      service.pay(50); // valid
      service.pay(60); // invalid triggers exception
    } catch (InvalidPaymentException e) {
      // API could use e.getCode() for client response
      System.out.println("Payment failed: code=" + e.getCode() + ", detail=" + e.getDetail());
    }

    System.out.println("Remaining balance: " + service.getBalance());
  }
}
