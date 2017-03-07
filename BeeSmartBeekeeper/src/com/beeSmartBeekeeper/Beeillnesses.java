package com.beeSmartBeekeeper;

public class Beeillnesses {
	
	private int id;
	private String name;
	private double minTemperature;
	private String decision;
	
	public Beeillnesses(int id, String name, double minTemperature,
			String decision) {
		super();
		this.id = id;
		this.name = name;
		this.minTemperature = minTemperature;
		this.decision = decision;
	}

	public Beeillnesses() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	

}
