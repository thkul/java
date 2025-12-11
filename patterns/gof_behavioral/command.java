package patterns.gof_behavioral;

// Turn a request into an object so you can queue it, log it, undo it, etc.

public class command {
  // The Command interface — every operation exposes execute()
  public interface Command { void execute(); }

  public class PaymentReceiver { // Receiver. The object performs the action
    public void processPayment(double amount) {
      System.out.println("Processing payment: " + amount);
    }
    public void refundPayment(String transactionId) {
      System.out.println("Refunding transaction: " + transactionId);
    }
  }

  // Concrete Command — executes a payment
  public class ProcessPaymentCommand implements Command {
    private final PaymentReceiver receiver;
    private final double amount;
    public ProcessPaymentCommand(PaymentReceiver receiver, double amount) {
      this.receiver = receiver; this.amount = amount;
    }
    @Override
    public void execute() { receiver.processPayment(amount); }
  }

  // Another Concrete Command — executes a refund
  public class RefundPaymentCommand implements Command {
    private final PaymentReceiver receiver;
    private final String transactionId;
    public RefundPaymentCommand(PaymentReceiver receiver, String transactionId) {
      this.receiver = receiver; this.transactionId = transactionId;
    }
    @Override
    public void execute() { receiver.refundPayment(transactionId); }
  }

  public class PaymentInvoker { // Invoker — the object that triggers commands
    // In real systems this could be a queue
    public void run(Command command) { command.execute(); }
  }
}
