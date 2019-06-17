public class StringTest {
	private String email;
	
	public StringTest(String email) { this.email = email; }
	
	private int getLength() { return email.length(); }
	
	public void printInfo() {
		System.out.println(email);
		System.out.println(getLength());
	}
	
	public int countChar(char query) {
		int count = 0;
		for(int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == query) count++;
		}
		return count;
	}
}