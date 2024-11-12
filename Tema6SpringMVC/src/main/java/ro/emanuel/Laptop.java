package ro.emanuel;

public class Laptop {
    private String brand;
    private double price;
    private int ram;

    public Laptop(String brand, double price, int ram) {
        this.brand = brand;
        this.price = price;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }
}
