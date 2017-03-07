package com.beeSmartBeekeeper;

import java.sql.Date;

public class Beehouseillness {
	
	public int id;
	public int beeillnessId;
	public int beehouseId;
	public Date date;
	
	public Beehouseillness(int id, int beeillnessId, int beehouseId, Date date) {
		super();
		this.id = id;
		this.beeillnessId = beeillnessId;
		this.beehouseId = beehouseId;
		this.date = date;
	}
	
	public Beehouseillness(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBeeillnessId() {
		return beeillnessId;
	}

	public void setBeeillnessId(int beeillnessId) {
		this.beeillnessId = beeillnessId;
	}

	public int getBeehouseId() {
		return beehouseId;
	}

	public void setBeehouseId(int beehouseId) {
		this.beehouseId = beehouseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
