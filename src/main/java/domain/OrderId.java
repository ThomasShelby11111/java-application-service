package domain;

import java.util.UUID;

public final class OrderId {

	public static OrderId newId() {
		return new OrderId(UUID.randomUUID());
	}
	
	public static OrderId ofString(
			final String name) {
		return new OrderId(UUID.fromString(name));
	}
	
	private final UUID id;
	
	private OrderId(
			final UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
}
