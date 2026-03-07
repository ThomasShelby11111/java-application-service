package application.command;

public class ConfirmOrderCommand {

	private final String orderId;
	
	public ConfirmOrderCommand(
			final String orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
}
