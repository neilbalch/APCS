public class Programmer extends Profile {
	private String hobby;
	
	public Programmer(String name, String hobby) {
		super(name, "coding");
		this.hobby = hobby;
	}
	
	public void speak() {
		super.speak();
		System.out.println("My specialty is " + super.specialty());
	}
	
	public void printInfo() {
		speak();
		System.out.println("My hobby is " + hobby);
	}
}