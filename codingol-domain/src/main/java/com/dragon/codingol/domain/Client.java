package com.dragon.codingol.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Jon Brisbin
 */
@Entity
public class Client {

	@Id
	@GeneratedValue
	private Long   id;
	@Column(nullable = false)
	private String name;
	@Column
	private Long   tradeCount;

	protected Client() {
	}

	public Client(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getTradeCount() {
		return tradeCount;
	}

	public Client setTradeCount(Long tradeCount) {
		this.tradeCount = tradeCount;
		return this;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", name='" + name + '\'' +
				", tradeCount=" + tradeCount +
				'}';
	}

}
