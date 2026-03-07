package domain.port;

import java.util.Optional;

import domain.Order;
import domain.OrderId;

public interface OrderRepository {

	Optional<Order> findById(OrderId id);
	
	void save(Order order);
	
}
