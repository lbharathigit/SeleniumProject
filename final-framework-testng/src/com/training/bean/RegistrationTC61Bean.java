package com.training.bean;

public class RegistrationTC61Bean {
	private String FirstName;
	private String LastName;
	private String Email;
	private String Telephone;
	private String Address1;
	private String Address2;
	private String City;
	private String PostalCode;
	private String Country;
	private String Region;
	private String Password;
	private String ConfirmPassword;

	public RegistrationTC61Bean() {
	}

	public RegistrationTC61Bean(String FirstName, String LastName, String Email, String Telephone, String Address1, String Address2, String City, String PostalCode, String Country, String Region, String Password, String ConfirmPassword) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.Telephone = Telephone;
		this.Address1 = Address1;
		this.Address2 = Address2;
		this.City = City;
		this.PostalCode = PostalCode;
		this.Country = Country;
		this.Region = Region;
		this.Password = Password;
		this.ConfirmPassword = ConfirmPassword;
				
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}	
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}
	
	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String Address1) {
		this.Address1 = Address1;
	}
	
	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}
	
	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}
	
	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String PostalCode) {
		this.PostalCode = PostalCode;
	}
	
	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public String getRegion() {
		return Region;
	}

	public void setRegion(String Region) {
		this.Region = Region;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String ConfirmPassword) {
		this.ConfirmPassword = ConfirmPassword;
	}

	@Override
	public String toString() {
		return "RegistrationTC61Bean [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Telephone=" + Telephone + ", Address1=" + Address1 + ", Address2=" + Address2 + ", City=" + City + ", PostalCode=" + PostalCode + ", Country=" + Country + ", Region=" + Region + ", Password=" + Password + ", ConfirmPassword=" + ConfirmPassword + "]";
	}

}
