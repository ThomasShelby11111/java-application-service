package application.usecase;

import application.command.ConfirmOrderCommand;
import application.port.EventPublisher;
import domain.Order;
import domain.OrderId;
import domain.PaymentReservationService;
import domain.port.OrderRepository;

// Application Service!!
public class ConfirmOrderUseCase {

	private final OrderRepository orderRepository;
	private final PaymentReservationService paymentService;
	private final EventPublisher eventPublisher;
	
	public ConfirmOrderUseCase(
			final OrderRepository orderRepository,
			final PaymentReservationService paymentService,
			final EventPublisher eventPublisher) {
		this.orderRepository = orderRepository;
		this.paymentService = paymentService;
		this.eventPublisher = eventPublisher;
	}
	
	public void confirmOrder(
			final ConfirmOrderCommand command) {
		
		Order order = orderRepository
				.findById(OrderId.ofString(command.getOrderId()))
				.orElseThrow(() -> new IllegalArgumentException("Order not found"));
		
		order.confirm(paymentService);
		orderRepository.save(order);
		eventPublisher.publish(order.pullEvents());
	}
	
}
