//author: Jonathan Land
public class SavingsAccount extends BankAccount 
{
	//variable of type double to hold interest
	double interest; 
	//variable to hold account type
	String accountType;

	//constructor that accesses constructor of parent class and accepts user initial balance and account name
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
