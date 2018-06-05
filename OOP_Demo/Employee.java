/**
 * @author Jonathan Land
 * May 17, 2017
 * 
 * Superclass that serves as a template for an employee object with 
 * a name and salary, and returns both characteristics 
 */

public class Employee 
{
	//instance variables
	String name = null;
	double salary = 0;

	/**
	 * 2 arg constructor for the employee employee. Passes in implicit 
	 * parmater a String and double. 
	 *
	 * @param empN represents the employees name
	 * @param empS represents the employees salary
	 *
	 * "this" used to refer to the object Employee
	 */
	public Employee(String empN, double empS) 
	{
		this.name = empN;
		this.salary = empS;
	}

	/**
	 * Method returns a String representation of object in order to produce information 
	 * when used as explicit parameter (in Tester). 
	 * 
	 * @return the employees name and salary 
	 */
	public String toString() 
	{
		return name + " | " + Double.toString(salary);
	}
}


