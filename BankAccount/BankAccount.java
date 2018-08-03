//author: Jonathan Land

public class BankAccount 
{
	private double balance;
	private String name; 
	private int accountNumber;
	//note: private static 
	private static int lastAssignedNumber; 
	public static final double OVERDRAFT_FEE = 20.00;
	
	//constructor to initialize instance variables
	public BankAccount()
	{
		balance = 0;
		accountNumber = 0;
		//increases variable by 1 
		lastAssignedNumber++;
		//sets account number to last assigned number *
		accountNumber = lastAssignedNumber;
	}
	
	//parameterized constructor that accepts a double from user
	//and sets the balance equal to initial balance
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	
	//method that adds values entered in amount that accepts a double
	//from user
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	
	//boolean method that returns true or false depending on
	//whether or not user input has withdrawn too much
	//accepts type double as parameter
	public boolean withdraw(double amount)
	{		
		//if balance - the amount is less than 0
		if (balance - amount < 0)
		{
			//then apply overdraft fee
			balance = balance-OVERDRAFT_FEE;
			return false;
		}
		//otherwise
		else 
		{
			//don't apply overdraft just subtract the amount from balance
			balance = balance - amount;
			return true;
		}
	}
	
	//getter/accessor method to return balance 
	public double getBalance()
	{
		return balance;
	}
	
	//getter/accessor method to return account number
	public int getaccountNumber()
	{
		return accountNumber;
	}
	
	//getter/accessor method to return name 
	public String getName()
	{
		return name;
	}
	
	//setter/mutator method for user to alter name input 
	public void setName(String name)
	{
		this.name = name;
	}
	
	//setter/mutator method to charge overdraft fee
	public void overDraftFee(double overdraft)
	{
		overdraft = balance + OVERDRAFT_FEE;
	}
}
	

