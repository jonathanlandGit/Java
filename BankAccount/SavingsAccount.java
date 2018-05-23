//author: Jonathan Land
//inheritance of base class BankAccount via extends keyword called SavingsAccount
public class SavingsAccount extends BankAccount 
{
	//variable of type double to hold interest
	double interest; 
	//variable to hold account type
	String accountType;

	//constructor with two parameters/arguments passed in
	public SavingsAccount(String accountName, double initialBalance)
	{	
		//inovokes constructor of paraent class/superclass/base class
	    super();
	    //account type variable is initialized to "Savings"
	    accountType = "Savings";
	    //interest variable is initialized to 0 
	    interest = 0;
	    deposit(initialBalance);
	    setName(accountName);
	}
	//method to calcuate simple interest with two parameters
	public double simpleInterest(double principle, double rate)
	{
		double interest = (principle*rate)/100;
        return interest;  
	}
	//method to apply interest to deposited amount via
	//the get balance method 
	public void applyInterest()
	{
		deposit(simpleInterest(getBalance(), 1));
	}
}
