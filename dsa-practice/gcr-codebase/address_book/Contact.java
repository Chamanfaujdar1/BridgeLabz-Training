// package gcr_codebase.address_book;

public class Contact implements Comparable<Contact> {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String number;
	private String email;
	
	public Contact(String firstName, String lastName, String address, String city, String state, String zip, String number, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.number = number;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}

	public String getZip(){
		return zip;
	}

	public String getPhoneNumber(){
		return number;
	}

	public String getEmail(){
		return email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setPhonenumber(String number) {
		this.number = number;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	// UC7 - Override equals for duplicate check
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Contact contact = (Contact) obj;
		return firstName.equalsIgnoreCase(contact.firstName) && lastName.equalsIgnoreCase(contact.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
	}

	// UC11 - Sorting contacts alphabetically by full name
	@Override
	public int compareTo(Contact other){
		String thisFullName = this.firstName + " " + this.lastName;
		String otherFullName = other.firstName + " " + other.lastName;
		return thisFullName.compareToIgnoreCase(otherFullName);
	}
	
	public String toString() {
		return "Contact Details {" +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Address='" + address + '\'' +
                ", City='" + city + '\'' +
                ", State='" + state + '\'' +
                ", Zip='" + zip + '\'' +
                ", Phone Number='" + number + '\'' +
                ", Email='" + email + '\'' +
                '}'; 
	}
}
