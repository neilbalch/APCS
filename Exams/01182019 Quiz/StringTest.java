public class StringTest {
	private String email;
	
	public StringTest(String email) { this.email = email; }
	
	public String getName() {
		return email.substring(0, email.indexOf('@'));
	}
	
	public String getDomain() {
		return email.substring(email.indexOf('@') + 1, email.lastIndexOf('.'));
	}
	
	public String toString() {
		return "address: " + email;
	}
}