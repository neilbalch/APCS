//Challenge: What does this do?
import Box.*;

public class Runner {
	public static void main (String args[]) {
		ShippingBox obj = new ShippingBox();
		obj.printInfo();
				
		System.out.println("\nRunning inside Runner: ");
		
		StandardBox obj2 = new StandardBox();
		
		//Uncomment the code and answer. 
		
		//(1) Does it print? why?
		// YES: the companyName attribute is marked public
		//System.out.println(obj2.companyName);
		
		//(2) Does it print? why?
		// NO: the password attribute is marked private
		//System.out.println(obj2.password);
		
		//(3) Does it print? why?
		// NO: the address attribute is marked protected and is attempted to be accessed from outside the package
		//System.out.println(obj2.address);
	}
}