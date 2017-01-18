package dto;

//class containing behavior and states associated with product order ordered by customer;
public class Order {
	//product order name, price, and quantity;
	private String name;
	private String price;
	private String quantity;

	//getter and setter methods for the above states;
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
