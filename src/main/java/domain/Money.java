package domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {

	private final BigDecimal amount;
	
	private Money(
			final BigDecimal amount) {
		this.ensurePositive(amount);
		this.amount = amount;
	}
	
	private void ensurePositive(
			final BigDecimal value) {
		if(value.signum() == -1 ) {
			String msg = "Amount cannot be negative";
			throw new IllegalArgumentException(msg);
		}
	}
	
	public Money add(
			final Money other) {
		BigDecimal v = this.amount.add(other.amount);
		return new Money(v);
	}
	
	public Money subtract(
			final Money other) {
		BigDecimal v = this.amount.subtract(other.amount);
		return new Money(v);
	}
	
	public Money multiply(
			final Money other) {
		BigDecimal v = this.amount.multiply(other.amount);
		return new Money(v);
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}
	
}
