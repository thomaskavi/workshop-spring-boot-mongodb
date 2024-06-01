package com.thomaskavi.workshopmongo.dto;

import java.io.Serializable;

import com.thomaskavi.workshopmongo.domain.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private String size;
	private Integer stockQuantity;
	private Double price;
	private Double totalMoneyInvested;

	public ProductDTO() {
	}

	public ProductDTO(Product obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		size = obj.getSize();
		stockQuantity = obj.getStockQuantity();
		setPrice(obj.getPrice());
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
}
