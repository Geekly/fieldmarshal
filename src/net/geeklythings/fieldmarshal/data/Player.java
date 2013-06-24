package net.geeklythings.fieldmarshal.data;

public class Player {

	private String firstName;
	private String lastName;
	
	public Player()
	{
		
	}
	
	public Player(String firstName, String lastName )
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
