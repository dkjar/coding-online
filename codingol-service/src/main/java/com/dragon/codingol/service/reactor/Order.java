package com.dragon.codingol.service.reactor;

/**
 * @author Jon Brisbin
 */
public class Order {

	private Long  id;
	private Trade trade;
	private Long  timestamp;

	public Order(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Trade getTrade() {
		return trade;
	}

	public Order setTrade(Trade trade) {
		this.trade = trade;
		return this;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public Order setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", trade=" + trade +
				", timestamp=" + timestamp +
				'}';
	}

}
