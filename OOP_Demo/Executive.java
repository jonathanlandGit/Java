/**
 * @author Jonathan Land 
 * May 17, 2017
 * 
 * Subclass to extend Manager methods in order to add Executive class
 * 
 */

public class Executive extends Manager 
{
	/**
	 * Three arg constructor that recieves a String, double, and another String
	 * Inherits from Manager
	 * 
	 * @param empN is the executive's name
	 * @param empS is the executive's salary
	 * @param dep is the executive's department
	 */
	public Executive(String empN, double empS, String dep) 
	{
		super(empN, empS, dep);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method returns a String representation of object in order to produce information 
	 * when used as explicit parameter (in Tester). 
	 * 
	 * @return the Executive's name, department, and salary 
	 */
	public String toString() 
	{
		return name + " | " + department + " | " + Double.toString(salary);
	}
}
