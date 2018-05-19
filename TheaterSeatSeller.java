/*
 * @author Jonathan Land
 * 
 * Program that simulates purchasing concert tickets
 */

public class TheaterSeatSeller 
{
	//declare a 2d array variable of type int called myTheaterSeats
	int [][] myTheaterSeats; 
	
	//set myTheaterSeats equal to theaterSeats after passing it to constructor 
	 public TheaterSeatSeller(int [][] theaterSeats)
	 {	
		 //copy path parameter into local variable
		 myTheaterSeats = theaterSeats; 
	 }
	 //method to keep printing seats to console 
	 public void printSeats()
	 {	 //rows need to print out in reverse order
		 for (int j = myTheaterSeats.length-1; j >= 0; j--) 
		  {  
				for (int k = 0; k < myTheaterSeats[0].length; k++) 
				{  
					System.out.print("$" +  myTheaterSeats[j][k] + "\t");
				} 
				System.out.print("\n");
				System.out.print("\n");
		  }
	 }
	 //public boolean that returns true if seat is available and false, if otherwise
	 //input variable is the desired row and seat number
	 public boolean getByLoc(int row, int seat)
	 {	 //if array location does not equal 0
		 if (myTheaterSeats[row][seat] != 0)
		 {	
			 //inform the user of the seat they selected and the price of that seat
			System.out.print("The seat at ");
			System.out.print("(Row:  " + row);
			System.out.print(" Seat:  " + seat +"),");
			System.out.println(" is available at a price of $" + myTheaterSeats[row-1][seat-1]);
			System.out.println("Thank you for your business");
			//mark seat as sold
			//Java arrays start at 0, however humans would start at 1
			myTheaterSeats[row-1][seat-1] = 0;
			//boolean to return true to indicate seat was avaialable
			return true; 
		  }
		//if seat unavailable then return false  
		 return false; 
	 }
	 //boolean method to search for a seat by price
	 //input variable is the users desired price
	 public boolean getByPrice(int seatPrice)
	 {
		 //we need to know size of array
		 int rows = myTheaterSeats.length;
		 int seats = myTheaterSeats[0].length;
		 //starting at the front of the theater, far left, and scan through 
		 //each seat in the theater
		 for (int i = 0; i < rows; i++) 
		 {		
			 for(int j = 0; j < seats; j++) 
		     {	//the first seat found at desired price
		        if (myTheaterSeats[i][j] == seatPrice)
		        {
		        	//inform the user the seat they are purchasing
		        	System.out.println("Found the seat at row: " + (i+1) + " seat: "+ (j+1));
		        	//mark that seat as sold
		        	myTheaterSeats[i][j] = 0;
		        	//return true indicating seat found for purchase
			 		return true; 
		         } 	
		      }
		  }
		 //return false = no seat found at desired price
		 return false; 
	 }
	 //boolean method to get the best seat available
	 //available means highest price seat closest to the stage
	 public boolean getBest() 
	 {   
		 //we need to know how many seats are in the theater
		 int numberRows = myTheaterSeats.length;
		 int numberSeats = myTheaterSeats[0].length;
		 //create a variable to save the price of a seat
		 //set a default value to indicate no seat found
		 int price = 0;
		 //create a variable to save the location of the seat and set them at -1
		 //to indicate no found location
		 int row = -1;
		 int seat = -1;
		 //since we do not know the maximum price, loop through every seat in
		 //the theater
		 for (int i = 0; i < numberRows; i++)
		 {
			 for (int j = 0; j <numberSeats; j++)
			 {
				 //if the current seat has a greater value than variable price
				 if (myTheaterSeats[i][j] > price) 
				 {	 //then this is currently the most expensive seat available, therefore,
					 //the price equal to the seat
					 price = myTheaterSeats[i][j];
					 //set the row number
					 row = i;
					 //set the seat number
					 seat = j;
				 }
			 }
		 }
		 //if row is greater than -1, then we found something
		 if (row >= 0)
		 {	//inform the user of the row and seat number and the price of that seat
			 System.out.print("Seat found at row: " + (row+1) + " seat: " + (seat+1));
			 System.out.println(" Price: $" + price);
			 System.out.println("This seat will be reserved");
			 //mark that seat as sold
			 myTheaterSeats[row][seat] = 0;
			 //return true to indicate that a seat was found
			 return true;
		 }
		 //return false to indicate no seat was found
	     return false;
	  }
}
