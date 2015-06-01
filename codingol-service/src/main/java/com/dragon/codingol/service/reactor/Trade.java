package com.dragon.codingol.service.reactor;

/**
 * @author Jon Brisbin
 */
public class Trade {

	private Long    id;
	private String  symbol;
	private Float   price;
	private Integer quantity;
	private Type    type;

	public Trade(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getSymbol() {
		return symbol;
	}

	public Trade setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public Float getPrice() {
		return price;
	}

	public Trade setPrice(Float price) {
		this.price = price;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Trade setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Type getType() {
		return type;
	}

	public Trade setType(Type type) {
		this.type = type;
		return this;
	}

	@Override
	public String toString() {
		return "Trade{" +
				"id=" + id +
				", symbol='" + symbol + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", type=" + type +
				'}';
	}

}
