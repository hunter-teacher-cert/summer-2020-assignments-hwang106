
public class Person{
	
	private String lastName;
	private String firstName;
	private String phoneNumber;
	
	
	//constructors
	public Person(){
		lastName = null;
		firstName = null;
		phoneNumber = "unlisted";
	}
	
	public Person(String ln, String fn, String phone){
		lastName = ln;
		firstName = fn;
		phoneNumber = phone;
	}
	
	public Person(String ln, String fn){
		lastName = ln;
		firstName = fn;
		phoneNumber = "unlisted";
	}
	
	//getters
	public String getName(){
		return this.lastName + ", " + this.firstName;
	}
	
	public String getFN(){
		return this.firstName;
	}
	
	public String getLN(){
		return this.lastName;
	}
	
	public String getNumber(){
		return this.phoneNumber;
	}
	
	//setters
	public void setName(String ln, String fn){
		this.lastName = ln;
		this.firstName = fn;
	}
	
	public void setFN(String fn){
		this.firstName = fn;
	}
	
	public void setLN(String ln){
		this.lastName = ln;
	}
	
	public void setNumber(String phone){
		this.phoneNumber = phone;
	}
	
	//toString overwrite
	public String toString(){
		return this.lastName + ", " + this.firstName + ", " this.phoneNumber;
	}
	
}