
import java.util.Scanner;

/*
 * @author Jonathan Land
 */

public class TheaterSeatTester 
{	//main method
	public static void main(String[] args) 
	{	
		//load the array with specific seating ($$) values
		//reverse 2d array so that numbering is correct
		//seating needs to be reversed because best seating starts at
		//0 and continues out from stage
		int[][] theaterSeats =
		{{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 },
		{ 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
		{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
		{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
		{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
		{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
		{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	    { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
		{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }};
		
		//constructor named theaterGame that passes the 2d array into another class
		TheaterSeatSeller theaterGame = new TheaterSeatSeller(theaterSeats);
				 
		//create new scanner called reader to receive user input
		//create needed instance variables that will be used to manipulate data
		Scanner reader = new Scanner(System.in);
		char choice = ' '; 
		int totalSold = 0;
		//find out how many total seats there are
		//this is x 
		int totalRows = theaterSeats.length;
		//this is y
		int totalSeats = theaterSeats[0].length;
		//while loop that continually presents options for user to choose from
		//while loop continues as long as user doesn't enter 'Q' to quit program
		while (choice != 'Q')
		{
			//continues to print the array using printSeats() method in neighboring class
			theaterGame.printSeats();
			System.out.println();
			//user options section 'P'(price), 'L'(location), 'B'(best available), 'Q'(quit)
			System.out.println("Welcome! Please choose one of the following: " + "\n");
			System.out.println("Type 'P' to search for seat by price");
			System.out.println("Type 'L' to search for seat by location");
			System.out.println("Type 'B' to search for the best seat available");
			System.out.println("Type 'Q' to exit program");
			//accept data from user and responds only to the options listed above
			choice = reader.next().trim().charAt(0);	
			System.out.println(); 
			//if user enter P
			if (choice == 'P') 
			{	//then present these options on console to the user
				System.out.println("You entered 'P' (search seats by price)");
				System.out.print("Choose from the prices below ");
				System.out.println("and type the amount to check for availability");
				System.out.println("Note: Enter amount as 10, 20, 30, 40, 50, without adding $ in front of the value");
				System.out.println("$10, $20, $30, $40, or $50");
				//variable named price to recieve an int from user
				int price = reader.nextInt();
				System.out.println("Searching for a $" + price + " seat");
				//if the price entered is not available in the array, inform the user
				 if (!theaterGame.getByPrice(price))
				 {
					 System.out.println("Couldn't find a seat for that price");
				 }
				 //else a seat was found and sold to the user
				 //incrementally totalSold
				 else 
				 {
					 totalSold++;
				 }
			}
			//if 'L' is entered, then prompt the user for a row and seat number
			else if (choice == 'L')
			{
				System.out.println("You entered 'L' (search seats by location)");
				System.out.println("Enter the row and seat number below.");
				System.out.print("    Row: ");
				//variable named row to recieve an int from user
				int row = reader.nextInt();
				System.out.print("    Seat: " );
				int seat = reader.nextInt();
				//if that row and seat is taken, inform the user
			    if (!theaterGame.getByLoc(row, seat))
			    {
			    	System.out.println("That seat is unavailable");
			    }
			    //else a seat was found and sold to the user
				//incrementally totalSold
			    else 
			    {
			    	totalSold++;
			    }
			}
			//if char 'B' is chosen, then output a message reminding user what option was chosen
			else if (choice == 'B')
			{
				System.out.println("You entered 'B' (search for best priced seats available)");
				//call method to get best seat available. If no seat available, inform the user
				if (!theaterGame.getBest())
			    {
			    	System.out.println("That seat is unavailable");
			    }
				//else a seat was found and sold to the user
				//incrementally totalSold
			    else 
			    {
			    	totalSold++;
			    }
			}
			//inform the user that their input is unknown 
			else 
			{
				System.out.println("Unknown input:" + choice);
			}
			System.out.println();
			System.out.println();	
			//if total sold is greater than or equal to total seats in the theater, inform the user and exit
			if (totalSold >= (totalRows * totalSeats))
			{
				System.out.println("All seats have been sold");
				System.exit(0);
			}
		}
		//if 'Q' is entered
		System.out.println("Goodbye");
	}		
}


	
