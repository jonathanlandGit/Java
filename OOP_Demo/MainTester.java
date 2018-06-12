/**
 * @author Jonathan Land 
 * May 17, 2017
 * 
 * Tester class to test methods in Employee, Manager, and Executive
 * 
 */
public class MainTester 
{
	public static void main(String[] args) 
	{
		//create Employee object including explicit parameters
		Employee m1 = new Employee("Linus Torvalds", 700000.50);
		//print
		System.out.println(m1);
		System.out.println();
		//create Manager object including explicit parameters
		Manager m2 = new Manager("James Gosling", 700000.51, "Software");
		//print
		System.out.println(m2);
		System.out.println();
		//create Executive object including explicit parameters
		Executive m3 = new Executive("Bjarne Stroustrup", 7000000.52, "Software");
		//print
		System.out.println(m3);
		System.out.println();
	}
}
