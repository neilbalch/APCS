public class Runner
{
   public static void main(String args[])
   {
		int num1;
		int num2;
		int num3;
		
		//Version B
		
		//1) 10 Points - Constructors and Instance Variables
		System.out.println("\n\n1) Constructors and Instance Variables");
		//The class Final2 has an instance String variable called myName
		//The initialization constructor sets up myName
		//The default sets the instance variable, myName  to "World".
		Final2 myObject = new Final2("Hello");
		Final2 myObjectDefault = new Final2();
		
		
		//Prints out  "Hello " + myName given through the initialization constructor
		//Prints out  "Hello " + myName given through the default constructor
		//Method - printHello() : void
		System.out.print("Initialization: ");
		myObject.printHello();
		System.out.print("Default: ");
		myObjectDefault.printHello();
		
	
		
		//2) 10 Points - Number operations and the Math library
		//Given the formula for c of the pythagorean theorem
		//c is the square root of a^2 + b^2 
		//return the calculation of c given a and b using the Math Library for square root and power.
		//Method - getC(int, int) : double
		System.out.println("\n\n2) Number operations and the Math library");
		int a = (int) (Math.random() * 9) + 1;
		int b = (int) (Math.random() * 9) + 1;
		System.out.println("Find c:");
		System.out.println("a: " + a + ", b: " + b);
		double cValue = myObject.getC(a, b);
		System.out.println(cValue);
		
		

		//3) 10 Points - Logical Operator and Modulus
		System.out.println("\n\n3) Logical Operator and Modulus");
		//Using Logical Operator test if at least 2 of the 3 numbers are odd
		//Return true if they are and false otherwise.
		//Method - checkAll(int, int, int) : boolean
		num1 = (int) (Math.random() * 4);
		num2 = (int) (Math.random() * 4);
		num3 = (int) (Math.random() * 4);
		System.out.println("num1: " +num1 + ", num2: " + num2 + ", num3: " + num3);
		boolean check = myObject.checkAll(num1, num2, num3);
		System.out.println("result:" + check);
		
		
		//4) 10 Points - Random Numbers
		//Method - getRandomInt(int, int) : int
		System.out.println("\n\n4) Random Numbers");
		int min = (int) (Math.random() * 101);
		int max = (int) (Math.random() * 101) + min;
		System.out.println("min: " +min + ", max: " + max);
		//Return a random number between min and max inclusive.
		int randNum = myObject.getRandomInt(min, max);
		System.out.println("randNum: " + randNum);
		
		
		//5) Switch and if-else
		//Method - getIfElse(int, int) : int
		//Method - printSwitch(int) : void
		System.out.println("\n\n5) switch if-else-if");
		num1 = (int) (Math.random() * 4);
		num2 = (int) (Math.random() * 4);
		System.out.println("num1: " + num1 + ", num2: " + num2);
		
		//Use if-else-if. If two of them are the same return 10. If one of them is a 3 return 5. Otherwise return 0. 
		int result = myObject.getIfElse(num1, num2);
		System.out.println("if-else-if result: " + result);
		
		//Use a switch for num2. Given 1 print "car", Given 2 print "door", Given 3 print "rm522", Given anything else print "java"
		System.out.print("switch result: ");
		myObject.printSwitch(num2);
		
		
		//6) 10 Points - While loop
		System.out.println("\n\n6) while loop");
		//You must use a while loop
		//You will print counting up from num1 to num2 (inclusive) by 1 assuming num2 is always greater than num1.
		//Method - countWhile(int,int) : void
		num1 = (int) (Math.random() * 11);
		num2 = (int) (Math.random() * 11) + 11;
		System.out.println("num1: " + num1 + ", num2: " + num2);
		myObject.countWhile(num1, num2);
		
		
		//7) 10 Points - For Loop 
		System.out.println("\n\n7) for loop 1");
		//You must use a for loop. Return the factorial.
		//That means multiplying all the numbers from 1 to that number inclusive.
		//Method - getFactorial(int) : int
		num1 = (int) (Math.random() * 6 + 1);
		System.out.println("num1: "  + num1);
		int factorial = myObject.getFactorial(num1);
		System.out.println("factorial: " + factorial);
		
		
		//8) 10 Points - For Loop
		System.out.println("\n\n8) for loop 2");
		//You must use a for loop. Return the summation.
		//That means to add all the numbers from 1 to that number inclusive.
		//Method - getSummation(int) : int
		num1 = (int) (Math.random() * 6 + 1);
		System.out.println("num1: "  + num1);
		int summation = myObject.getSummation(num1);
		System.out.println("summation:" +summation);
		
		
		
		
		//9) Array Exercise 1
		//Multiply all the numbers in the array with the exception of the number 13
		//and return the result.
		//Method - getProduct(int[]) : int
		System.out.println("\n\n9) Array 1");
		int[] array1 = {4,3,13,5,6};
		int[] array2 = {4,1,5,2,9};
		
		int result1 = myObject.getProduct(array1);
		System.out.println("result1:"+result1);
		
		int result2 = myObject.getProduct(array2);
		System.out.println("result2:"+result2);
		
		
		//10) Array Exercise 1
		//Return true if there are no 1's and no 2's.
		//Method - check12(int[]) : boolean
		System.out.println("\n\n10) Array 2");
		int[] array3 = {4,3,2,3,1}; //->false
		int[] array4 = {4,3,2,3,7}; //->false
		int[] array5 = {4,3,4,3,7}; //->true
		
		boolean result3 = myObject.check12(array3);
		System.out.println("result3:"+result3);
		
		boolean result4 = myObject.check12(array4);
		System.out.println("result4:"+result4);
		
		boolean result5 = myObject.check12(array5);
		System.out.println("result5:"+result5);
		
		

   }//End Main 
}//End Class
