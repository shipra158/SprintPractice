package com.cg.apps.Spring.Items.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cg.apps.Spring.Customer.entity.Customer;

@Entity
public class Item {
	@Id
	private String itemId;

	private double price;
	private String description;
	private LocalDateTime addedDate;
	
	//@OneToMany
	//private Customer boughtBy;
	 

	public Item() {
		this.itemId = null;
		this.price = 0;
		this.description = null;
	}

	public Item(double price, String description, LocalDateTime addedDate) {
		this.price = price;
		this.description = description;
		this.addedDate = addedDate;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItem() {
		return String.valueOf(itemId);
	}

	public void setItem(String itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// public Customer getBoughtBy() {
	// return boughtBy;
	// }

	// public void setBoughtBy(Customer boughtBy) {
	// this.boughtBy = boughtBy;
	// }

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return ("item" + itemId + " " + "price" + price + " " + "description" + description);
	}
	
	public String generateID() {
		String chars = "0123456789";
		StringBuilder id = new StringBuilder();
		for(int i=0; i<10; i++) {
			id.append(chars.charAt((int)(Math.floor(Math.random()*10))));
		}
		return id.toString();
	}
}
