package jquery.datatables.model;

public class Company {
	
	static int nextID = 17;

    public Company(String name, String address, String town)
    {
        id = nextID++;
        this.name = name;
        this.address = address;
        this.town = town;
       
    }
      
    private int id;
    private String name;
    private String address;
    private String town;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
}
