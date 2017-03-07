package com.beeSmartBeekeeper;

import java.sql.Date;

public class Honey {
	private int id;
	private int beehouseId;
	private double quantity;
	private Date date;
	public Honey(int id, int beehouseId, double quantity, Date date) {
		super();
		this.id = id;
		this.beehouseId = beehouseId;
		this.quantity = quantity;
		this.date = date;
	}
	
	public Honey(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBeehouseId() {
		return beehouseId;
	}

	public void setBeehouseId(int beehouseId) {
		this.beehouseId = beehouseId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
