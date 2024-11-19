package ro.emanuel.pojo;

public class Order {
   private int id;
   private String customerName;
   private String product;
   private int quanity;
   private double price;

   public Order() {
   }

   public Order(int id, String customerName, String product, int quanity, double price) {
      this.id = id;
      this.customerName = customerName;
      this.product = product;
      this.quanity = quanity;
      this.price = price;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getCustomerName() {
      return this.customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public String getProduct() {
      return this.product;
   }

   public void setProduct(String product) {
      this.product = product;
   }

   public int getQuanity() {
      return this.quanity;
   }

   public void setQuanity(int quanity) {
      this.quanity = quanity;
   }

   public double getPrice() {
      return this.price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}