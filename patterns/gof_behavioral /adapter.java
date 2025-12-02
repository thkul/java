package patterns.gof_behavioral;

// It wraps legacy or external code so it finally behaves the way your system expects.

public class adapter {

	// Our existing contract used across the application
	public interface Payable {
		void pay(double amount);
	}

	// Third-party SDK we cannot modify
	class OldBankPaymentSDK {

		public void makeTransfer(int cents) {
			System.out.println("Old Bank: transferring " + cents + " cents");
		}
	}

	// Adapter: makes the SDK compatible with our Payable interface
	class OldBankPaymentAdapter implements Payable {
		private final OldBankPaymentSDK sdk;
		public OldBankPaymentAdapter(OldBankPaymentSDK sdk) {
			this.sdk = sdk;
		}
		@Override
		public void pay(double amount) {
			int cents = (int) (amount * 100);
			sdk.makeTransfer(cents);
		}
	}

	// OrderService stays unchanged and works with Payable abstraction
	class OrderService {
		private final Payable paymentProcessor;
		public OrderService(Payable paymentProcessor) {
			this.paymentProcessor = paymentProcessor;
		}
		public void pay(Order order) { paymentProcessor.pay(order.getAmount()); }
	}

	class Order {
		private final long id; private final double amount;
		public Order(long id, double amount) { this.id = id; this.amount = amount; }
		public long getId() { return id; }
		public double getAmount() { return amount; }
	}
}
