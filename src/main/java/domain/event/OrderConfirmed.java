package domain.event;

import domain.OrderId;

// Domain Event
public class OrderConfirmed extends DomainEvent {

	private final OrderId orderId;
	
	public OrderConfirmed(
			final OrderId orderId) {
		this.orderId = orderId;
	}
	
	public OrderId getOrderId() {
		return orderId;
	}
	
}
