public class Runner {
	public static void main(String[] args) {
		StringTest st = new StringTest("tom.smith@mvla.net");
		st.printInfo();
		System.out.println(st.countChar('m'));
	}
}