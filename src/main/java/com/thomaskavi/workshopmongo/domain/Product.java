package com.thomaskavi.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String description;
	private String size;
	private Integer stockQuantity;
	private Double price;
	private Double totalMoneyInvested;

	public Product() {
	}

	public Product(String id, String name, String description, String size, Integer stockQuantity, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.size = size;
		this.stockQuantity = stockQuantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalMoneyInvested() {
		totalMoneyInvested = stockQuantity * price;
		return totalMoneyInvested;
	}

	public void setTotalMoneyInvested(Double totalMoneyInvested) {
		this.totalMoneyInvested = totalMoneyInvested;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
