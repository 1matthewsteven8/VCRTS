public class User {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String toString()
	{
		String output = "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Phone Number: " + phoneNumber + "\n Email: " + email + "\n Username: ";
		return output;
	}
	
}
