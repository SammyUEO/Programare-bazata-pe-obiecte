package ro.emanuel.pojo;

public class Car {
	private int id;
	private String brand;
	private String model;
	private double fabrication;

	public Car(int id, String brand, String model, double fabrication) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.fabrication = fabrication;
		
	}
	public int getId() {
		return id;
	}
	
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getFabrication() {
		return fabrication;
	}


}
