//author: Jonathan Land
import java.util.Scanner; 
import java.util.ArrayList;
import java.math.RoundingMode;

//tester class
public class BankAccountTester 
{
	public static int numberOfAccounts = 5;
	//create array list checking account
	public static ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
	//create array list savings account
	public static ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	
	//method to empty checking account when 5 is reached
	public static void dumpCheckingAccounts()
	{
		for (int i= 0; i < numberOfAccounts; i++)
		{	
			System.out.print("Account name: " + checkingAccounts.get(i).getName()+ " Account balance: $"); 
			System.out.format("%.2f",checkingAccounts.get(i).getBalance());	
			System.out.println(" : Account number = " + checkingAccounts.get(i).getaccountNumber());
		}
		System.out.println();
	}
	
	//method to empty savings accoutn when 5 is reached
	public static void dumpSavingsAccounts()
	{
		for (int i= 0; i < numberOfAccounts; i++)
		{	
			System.out.print("Account name: " + savingsAccounts.get(i).getName()+ " Account balance: $"); 
			System.out.format("%.2f",savingsAccounts.get(i).getBalance());	
			System.out.println(" : Account number = " + savingsAccounts.get(i).getaccountNumber());
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		//ask for user input to enter five checking accounts
		System.out.println("Enter information for five checking accounts:" );
		//for loop to continue to ask for user input and edit 
		//amount so that it prints to the hundreds place (using Math.round)
		for (int i = 1; i < numberOfAccounts+1; i++)
		{
			System.out.println("Checking account #" + i);
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Account Name: ");
			String name = in.nextLine();
			System.out.print("Enter Account Balance: ");
			double balance = in.nextDouble();
			//round number two decimal places. If two decimal places already,
			//program will not change anything
			double roundedBalance = Math.round(balance*100)/100.0;
			System.out.println("Creating checking account #" + i + " '" + name + "' with initial balance of '$" + roundedBalance + "'");
			System.out.println();
			//adds checking account in each iteration with name and balance parameters
			checkingAccounts.add(new CheckingAccount(name, roundedBalance));	
		}
		
		//ask for user input to enter five savings accounts 
		System.out.println("Enter information for five savings accounts:" );
		//for loop to continue to ask for user input and edit 
		//amount so that it prints to the hundreds place (using Math.round)
		for (int i = 1; i < numberOfAccounts+1; i++)
		{
			System.out.println("Savings account #" + i);
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Account Name: ");
			String name = in.nextLine();
			System.out.print("Enter Account Balance: ");
			double balance = in.nextDouble();
			//return the name and price entered for initial balance
			double roundedBalance = Math.round(balance*100)/100.0;
			System.out.println();
			//adds savings account in each iteration with name and balance parameters
			SavingsAccount savingsAccount = new SavingsAccount(name, roundedBalance);
			savingsAccounts.add(savingsAccount);
			System.out.print("Creating savings account" + " '" + name + "'" + " : initial balance = " + roundedBalance + " Account number: " + savingsAccount.getaccountNumber());			
			System.out.println();
			System.out.println();
		}
		
		//collects the five entries entries above and prints them to console
		System.out.println("Checking Accounts");
		
		for (int i= 0; i < numberOfAccounts; i++)
		{	
			System.out.println("Account name: " + checkingAccounts.get(i).getName()+ " Account balance: $" + checkingAccounts.get(i).getBalance());		
		}
		System.out.println();
		
		//collects the five entries above and prints them to console
		System.out.println("Savings Accounts (Before Interest)");
		dumpSavingsAccounts();
		
		System.out.println();
		
		//for loop to apply interest method to user data entered
		for (int i= 0; i < numberOfAccounts; i++)
		{
			savingsAccounts.get(i).applyInterest();	
		}
		//for loop that calculates the amount after interest is applied
		System.out.println("Savings Accounts (After Interest)");
		dumpSavingsAccounts();
		System.out.println();
		//begining of checks sections in last section of assignment
		System.out.println("Enter eleven checks on our accounts");
		System.out.println("List of accounts");
		//call this method again
		dumpCheckingAccounts();
		
		//start at 0 because need to count until 11
		int numberOfChecks = 0;
		boolean anotherCheck = true;
		{
			//while loop to continue asking for check so that program can get to 11
			while(anotherCheck)
			{
				Scanner in = new Scanner(System.in);
				System.out.println("What is the account number for the check? (0 to quit)");
				int accountNumber = in.nextInt();
				//for user to exit program
				String exit = in.nextLine();
				
				//if account number is equal 0
				if (accountNumber == 0) 
				{
					anotherCheck = false;
				}
				//otherwise
				else 
				{
					//set currentAccount to null
					CheckingAccount currentAccount = null;
					//search for account the user entered 
					for(int j = 0; j < checkingAccounts.size(); j++)
					{
						//if the account number entered by the user matches one in the checking accounts arrayList
						//and the checks are less then or equal to 10
						if (checkingAccounts.get(j).getaccountNumber()==accountNumber)
						{
							//found account
							currentAccount = checkingAccounts.get(j);
						}
					}
					//if the current account is not equal to null
					if (currentAccount != null)
					{	
						//perform console tasks to get data entered by user
						System.out.println("Account name: " + currentAccount.getName() + " Account balance: $" + currentAccount.getBalance());		
						System.out.print("Enter a check on account " + currentAccount.getaccountNumber());
						double checkAmount = in.nextDouble();
						System.out.println("Processing check " + checkAmount + " on account " + currentAccount.getaccountNumber());
						currentAccount.processCheck(checkAmount);
						numberOfChecks ++;
						System.out.println("Account name: " + currentAccount.getName() + " Account balance: $" + currentAccount.getBalance());		
						//if number of checks entere is greater than or equal to 11
						if (numberOfChecks >= 11)
						{	
							//dont run the while loop - end the user input
							anotherCheck = false;
						}
					}
					//otherwise if user enters something other than account number, then
					//give statement that the account could not be found
					else
					{
						System.out.println("Never found an account");
					}			
				}
			}
		}
	}
}
	


