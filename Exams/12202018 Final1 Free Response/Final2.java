public class Final2 {
	private String myName;

	public Final2() {
		myName = "World";
	}
	
	public Final2(String name) {
		myName = name;
	}
	
	public void printHello() {
		System.out.println("Hello " + myName);
	}
	
	public double getC(int a, int b) {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	public boolean checkAll(int num1, int num2, int num3) {
		int numOdd = 0;
		if(num1 % 2 != 0) {
			numOdd++;
		}
		if(num2 % 2 != 0) {
			numOdd++;
		}
		if(num3 % 2 != 0) {
			numOdd++;
		}
		
		if(numOdd >= 2) return true;
		else return false;
	}
	
	public int getRandomInt(int min, int max) {
		return (int)((max - min + 1) * Math.random() + min);
	}
	
	public int getIfElse(int num1, int num2) {
		if(num1 == num2) return 10;
		else if(num1 == 3 || num2 == 3) return 5;
		else return 0;
	}
	
	public void printSwitch(int num) {
		switch(num) {
			case 1:
				System.out.println("car");
				break;
			case 2:
				System.out.println("door");
				break;
			case 3:
				System.out.println("rm522");
				break;
			default:
				System.out.println("java");
				break;
		}
	}
	
	public void countWhile(int min, int max) {
		int count = min;
		while(count <= max) {
			System.out.println(count);
			count++;
		}
	}
	
	public int getFactorial(int num) {
		int count = 1;
		for(int i = num; i > 0; i--) {
			count *= i;
		}
		
		return count;
	}
	
	public int getSummation(int num) {
		int count = 0;
		for(int i = num; i > 0; i--) {
			count += i;
		}
		
		return count;
	}
	
	public int getProduct(int[] nums) {
		int count = 1;
		for(int i : nums) {
			if(i == 13) continue;
			count *= i;
		}
		
		return count;
	}
	
	public boolean check12(int[] nums) {
		for(int i : nums) {
			if(i == 1 || i == 2) return false;
		}
		
		return true;
	}
}