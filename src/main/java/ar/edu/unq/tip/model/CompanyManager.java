package ar.edu.unq.tip.model;

public class CompanyManager extends Entity {
	
	private static final long serialVersionUID = 8737714551433572637L;
	private String nameAndSurname;
	private int phone;
	private String email;
	private String userName;
	private String password;
	private Company company;
	
	public CompanyManager() { }
	
	public CompanyManager(String nameAndSurname, int phone, String email, String userName, String password, Company company) {
		this.phone = phone;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.company = company;
	}
	
	public String getNameAndSurname() {
		return nameAndSurname;
	}
	
	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
}
