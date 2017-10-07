package jquery.datatables.model;





public class CustomersDetails {

	static int nextID = 17;

	public CustomersDetails(int customerNumber,  String customerName,  String contactLastName,
			String contactFirstName, 
			String phone, String addressLine1, String addressLine2,
			String city, String state, String postalCode, String country, 
			int salesRepEmployeeNumber, double creditLimit, String repLastName, String repFirstName, 
			String repEmail, String repOfficeCode, String repCity, String repState, String repPhone) {
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
		this.repLastName = repLastName;
		this.repFirstName = repFirstName;
		this.repEmail = repEmail;
		this.repOfficeCode = repOfficeCode;
		this.repCity = repCity;
		this.repState = repState;
		this.repPhone = repPhone;
		
		
 
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
	private String repLastName;
	private String repFirstName;
	private String repEmail;
	private String repOfficeCode;
	private String repCity;
	private String repState;
	private String repPhone;


	

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
	public String getrepLastName() {
		return repLastName;
	}

	public void setrepLastName(String repLastName) {
		this.repLastName = repLastName;
	}
	public String getrepFirstName() {
		return repFirstName;
	}

	public void setrepFirstName(String repFirstName) {
		this.repFirstName = repFirstName;
	}
	
	public String getrepEmail() {
		return repEmail;
	}

	public void setrepEmail(String repEmail) {
		this.repEmail = repEmail;
	}
	public String getrepOfficeCode() {
		return repOfficeCode;
	}

	public void setrepOfficeCode(String repOfficeCode) {
		this.repOfficeCode = repOfficeCode;
	}
	public String getrepCity() {
		return repCity;
	}

	public void setrepCity(String repCity) {
		this.repCity = repCity;
	}
	public String getrepState() {
		return repState;
	}

	public void setrepState(String repState) {
		this.repState = repState;
	}
	public String getrepPhone() {
		return repPhone;
	}

	public void setrepPhone(String repPhone) {
		this.repPhone = repPhone;
	}

	
	
}