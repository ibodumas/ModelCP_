package jquery.datatables.model;

public class ShoppingCart {
	
	static int nextID = 17;

    public ShoppingCart(String productCode, String name, String description, double price, int quantity)
    {
        id = nextID++;
        this.productCode = productCode; 
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
       
    }
      
    private int id;
    private String productCode;
    private String name;
    private String description;
    private int quantity;
    private double price;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
