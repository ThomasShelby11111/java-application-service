package domain;

import java.util.ArrayList;
import java.util.List;

import domain.event.DomainEvent;
import domain.event.OrderConfirmed;

// Aggregate
public final class Order {

	private final OrderId id;
	private OrderStatus status;
	private final Money total;
	private final List<DomainEvent> events;
	
	public Order(
			final OrderId id,
			final Money total) {
		this.id = id;
		this.total = total;
		this.status = OrderStatus.PENDING;
		this.events = new ArrayList<>();
	}
	
	public OrderId getId() {
		return id;
	}
	
	public void confirm(
			final PaymentReservationService paymentService) {
		checkStatusNotPending();
		paymentService.reserve(total);
		this.status = OrderStatus.CONFIRMED;
		this.events.add(new OrderConfirmed(this.id));
	}

	private void checkStatusNotPending() {
		if(this.status != OrderStatus.PENDING) {
			String msg = "Order cannot be confirmed";
			throw new IllegalStateException(msg);
		}
	}
	
	public List<DomainEvent> pullEvents() {
		List<DomainEvent> events = List.copyOf(this.events);
		this.events.clear();
		return events;
	}
	
}
