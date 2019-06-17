public class Profile {
	private String name;
	private String specialty;
	
	public Profile(String name, String specialty) {
		this.name = name;
		this.specialty = specialty;
	}
	
	public void speak() { System.out.println("Hi, my name is " + name); }
	
	public String specialty() { return specialty; }
}