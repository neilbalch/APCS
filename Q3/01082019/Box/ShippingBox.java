//Challenge: What does this do?
package Box;

public class ShippingBox {
	public void printInfo() {
		System.out.println("Running inside ShippingBox: ");
		StandardBox b = new StandardBox();
		
		//Uncomment the code and answer. 
		
		//(4) Does companyName print? why?
		// YES: the companyName attribute is marked public
		//System.out.println(b.companyName);
		
		//(5) Does password print? why?
		// NO: the password attribute is marked private
		//System.out.println(b.password);
		
		//(6) Does address print? why?
		// YES: the address attribute is marked protected and is accessed from inside the package
		//System.out.println(b.address);
	}
}