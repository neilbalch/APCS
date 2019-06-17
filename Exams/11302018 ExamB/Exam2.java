public class Exam2 {
	public String getScore(int a, int b) {
		if(a%2 != 0 && b%2 != 0) {
			return "A";
		} else if(a%2 != 0 || b%2 != 0) {
			return "B";
		} else {
			return "C";
		}
	}
	
	public void count(int min, int max) {
		int i = min;
		
		while(i <= max) {
			System.out.println("Counter: " + i);
			i++;
		}
	}
	
	public void printArray(int[] list) {
		for(int i : list)
			System.out.println("List Element: " + i);
	}
	
	public int sumArray(int[] list) {
		int count = 0;
		for(int i = 0; i < list.length; i++) {
			count += list[i];
		}
		
		return count;
	}
}