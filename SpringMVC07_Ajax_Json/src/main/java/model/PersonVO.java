package model;

public class PersonVO {
	private String name;
	private String address;
	public PersonVO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public PersonVO() {
		super();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", address=" + address + "]";
	}
	
	
}
