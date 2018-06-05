/**
 * @author Jonathan Land
 * May 17, 2017
 * 
 * Subclasss Manager inherts/extends Employee class, and adds department variable
 *
 */
public class Manager extends Employee 
{
	//Instance variable
	String department = null;

	/**
	 * Three arg constructor that invokes methods of parent class/super class
	 * and also adds department implicit parameter
	 * 
	 * @param empN is manager's name
	 * @param empS is manager's salary
	 * @param dep is manager's department
	 * 
	 * "this" used to refer to the object Employee
	 */
	public Manager(String empN, double empS, String dep) 
	{
		super(empN, empS);
		this.department = dep;
	}

	/**
	 * Method returns a String representation of object in order to produce information 
	 * when used as explicit parameter (in Tester). 
	 * 
	 * @return the manager's name, department, and salary 
	 */
	public String toString() 
	{
		return name + " | " + department + " | " + Double.toString(salary) ;
	}
}

