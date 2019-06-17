public class Runner {
	public static void main(String[] args) {
		StringTest st = new StringTest("tom.smith@mvla.net");
		System.out.println(st.getName());
		System.out.println(st.getDomain());
		System.out.println(st);
	}
}