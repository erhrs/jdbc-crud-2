package jdbc_school_assignment.dto;

public class School {
	private int id;
	private String name;
	private String address;
	private int admission_fee;
	private String pattern;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAdmission_fee() {
		return admission_fee;
	}
	public void setAdmission_fee(int admission_fee) {
		this.admission_fee = admission_fee;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", admission_fee=" + admission_fee
				+ ", pattern=" + pattern + "]";
	}
	

}
