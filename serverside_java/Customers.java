package jquery.datatables.model;



public class Customers {

	

	public Customers(int customerNumber,  String customerName,  String contactLastName,
			String contactFirstName, 
			String phone, String addressLine1, String addressLine2,
			String city, String state, String postalCode, String country, 
			int salesRepEmployeeNumber, double creditLimit) {
		// id = nextID++;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit =creditLimit;
	
		
 
	}

	
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	
	private String city;
	
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;

	

	public int getcustomerNumber() {
		return customerNumber;
	}
	public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getcontactLastName() {
		return contactLastName;
	}

	public void setcontactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	
	public String getcontactFirstName() {
		return contactFirstName;
	}

	public void setcontactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getaddressLine1() {
		return addressLine1;
	}

	public void setaddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getaddressLine2() {
		return addressLine2;
	}

	public void setaddressLine2(String addressLine2) {
		this.addressLine1 = addressLine2;
	}
	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}
	public String getstate() {
		return state;
	}

	public void setstate(String state) {
		this.state = state;
	}
	public String getpostalCode() {
		return postalCode;
	}

	public void setpostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getcountry() {
		return country;
	}

	public void setcountry(String country) {
		this.country = country;
	}
	
	public int getsalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setsalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}
	
	public double getcreditLimit() {
		return creditLimit;
	}

	public void setcreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	
	
}

