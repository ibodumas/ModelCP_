package jquery.datatables.model;

public class Product {
	
	static int nextID = 0;

    public Product(String productCode, String name,String productLine, String description, double price)
    {
        //id = nextID++;
        this.productCode = productCode; 
        this.name = name;
        this.productLine = productLine;
        this.description = description;
        this.price = price;
       
    }
      
  //  private int id;
    private String productCode;
    private String name;
    private String description;
    private String productLine;
    private double price;

	//public int getId() {
	//	return id;
	//}
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
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
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
