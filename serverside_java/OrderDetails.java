package jquery.datatables.model;

public class OrderDetails {
	
	static int nextID = 17;

    public OrderDetails(int orderNumber, String productCode, int quantityOrdered,double priceEach)
    {
        id = nextID++;
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
       
    }
      
    private int id;
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;

	public int getId() {
		return id;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode){
		this.productCode = productCode;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public double getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}
}
