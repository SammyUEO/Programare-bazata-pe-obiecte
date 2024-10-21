package ro.emanuel.pojo;

public class Violin {
	private String brand;
	private String model;
	private int strings;
	
	public Violin(String brand, String model, int strings) {
		super();
		this.brand = brand;
		this.model = model;
		this.strings = strings;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getStrings() {
		return strings;
	}
	
}
