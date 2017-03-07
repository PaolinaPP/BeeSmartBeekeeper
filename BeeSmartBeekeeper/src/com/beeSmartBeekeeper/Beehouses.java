package com.beeSmartBeekeeper;

public class Beehouses {

	private int id;
	private String arduinoId;
	private int ownerId;
	public Beehouses(int id, String arduinoId, int ownerId) {
		super();
		this.id = id;
		this.arduinoId = arduinoId;
		this.ownerId = ownerId;
	}
	
	public Beehouses(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArduinoId() {
		return arduinoId;
	}

	public void setArduinoId(String arduinoId) {
		this.arduinoId = arduinoId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	
	
}
