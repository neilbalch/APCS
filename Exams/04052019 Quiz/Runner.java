import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		John j = new John();
		System.out.println(j.getName());
		System.out.println(j.getAddress());
		
		System.out.println();
		ArrayList<Monster> list = new ArrayList<>();
		list.add(new Vampire("Elvira"));
		list.add(new Mummy("Frank"));
		
		for(Monster m : list) {
			System.out.println(m.getInfo());
		}
	}
}