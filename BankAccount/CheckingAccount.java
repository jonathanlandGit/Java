//author: Jonathan Land

public class CheckingAccount extends BankAccount 
{	
	//ivar to hold account type
	String accountType;
	//variable to hold number of checks written
	int numberOfChecksWritten;
	//varible to keep track of checking balance
	double checkingBalance;
	//constant variable with fee of $1 if surpassed/triggered
	public final double CHECKINGFEE = 1;
	
	//constructor for instance variables with two parameters accountName and initialBalance
	public CheckingAccount(String accountName, double initialBalance)
	{
		//invokes the constructor of immediate parent class/base class/superclass, 
		//so that all public variables are able to be used
	    super();
	    //initialized variables
	    accountType = "Checking";
	    numberOfChecksWritten = 0;
	    //sets original balance to checking account
	    deposit(initialBalance);
	    setName(accountName);
	}
	//mutator method to track the number of checks written with one parameter and/or argument
	public void processCheck(double checkAmount)
	{	
		//if there's a withdraw from checkamount
		if (withdraw(checkAmount))
		{
			//increase number of checks by 1
			numberOfChecksWritten++;
			//if number of checks surpasses 10 or is equal to zero
			if (numberOfChecksWritten %11 == 0)
			{	//apply checking fee
				withdraw(CHECKINGFEE);
			}
		}
	}
	//accessor method to clear number of checks written
	public void clear()
	{
		numberOfChecksWritten = 0;
	}
}

