package ArrayList_methods;

import java.util.Collections; //need this one for sorting ArrayList
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @author Jonathan Land
 * 
 * Program that executes various methods using an arraylist data structure with randomized values each time the program runs.
 */

public class ArrayList_methods 
{
		//ArrayList to hold values to work on for lab
		private ArrayList<Integer> listValues;

		//ArrayList constructor
		public ArrayList_methods(ArrayList<Integer> initialValues) 
		{
			//note this shows how to make a copy of an array list
			//simply pass the old list in as an argument to 
			//the ArrayList constructor
			listValues = new ArrayList<Integer>(initialValues);
		}
		
		//set listValues to list passed as parm
		//use this method to "reset" our ArrayList data before each test
		public void setListValues(ArrayList<Integer> newValues) 
		{
			listValues = new ArrayList<Integer>(newValues);
		}
		
		//Accessor method to get the list values
		public ArrayList<Integer> getListValues() 
		{
			return listValues;
		}
		
		//method to print the current values in the ArrayList
		//or you can simply use println() with the array list as the
		//parameter
		public void printArrayList() 
		{
			System.out.println(listValues);
		}
		
		public void swapFirstAndLast() 
		{
			//save first element
			int temp = listValues.get(0);
			//move last element to first position (0)
			listValues.set(0,  listValues.get(listValues.size()-1));
			//put temp value into last position (size() -1)
			listValues.set(listValues.size()-1, temp);
		}
		
		public void shiftRight() 
		{
			//copy last element into temp var (length-1)
			int shiftRightTemp = listValues.get(listValues.size()-1);
			//traverse arrayList
			for (int i = listValues.size()-1; i > 0; i--)
			{
				//last element should be set to the second to last element
			    listValues.set(i,listValues.get(i-1)); 
			}
				//and first element set to last element
			    listValues.set(0, shiftRightTemp);     
		}
			
		//set all even elements to 0.
		public void setEvensToZero() 
		{
			//traverse arrayList
			for (int i = 0; i < listValues.size(); i++)
				//if values in arrayList have remainder of two and equal 0
				if (listValues.get(i) %2 == 0)
				{	
					//set each even number in arrayList to 0
					listValues.set(i,0);
				}		
		}	
			
		//replace each element except the first and last by larger of two 
		//around it
		public void largerOfAdjacents() 
		{		
			//declare int named leftHand and assign it to the first position of arrayList (listValues)
			int leftHand = listValues.get(0);
			//for loop to traverse the arrayList begininng at 1, going to the last element, 
			//and incrementing by one
			for (int i = 1; i < listValues.size()-1; i++)
			{	//if lefthand position is greater than the position next to it then, 
				if (leftHand > listValues.get(i+1))
				{	//swap positions
					int temp = listValues.get(i);
					listValues.set(i,leftHand);
					leftHand = temp;
				}
				
				else 
				{
					//since the right hand is largest, will change current value 
					//to the right hand which is i
					leftHand = listValues.get(i);
					listValues.set(i, listValues.get(i+1));
				}
			}
		}
		//remove middle el if odd length, else remove middle two els.
		public void removeMiddle() 
		{
			//Do not do remove anything if value is less than size 3
			if (listValues.size() < 3)
			{
				return;
			}
			//even length arrayList
			//if the listValues size in arrayList have a remainder of 2 and equal 0, then
			if (listValues.size() %2 == 0)
			{
				//accomplish tasks for even size arrayList
				//int variable named middle and assign it the listValues size divided by 2
				int middle = listValues.size()/2;
				//since the list is altered each time the remove is called, call the remove
				//twice
				listValues.remove(middle-1);
				listValues.remove(middle-1);
			}
			//otherwise remove middle
			else
			{
				int middle = listValues.size()/2;
				listValues.remove(middle);
			}	
		}
			
		//move all evens to front
		public void moveEvensToFront() 
		{
			//create variable of type int and initialize it to 0
			int temp = 0;
			//create another variable and initialize it to 0
			int evens = 0;
			// traverse full length of arrayList, incrementing 1 each time through the loop
			for (int i = 0; i < listValues.size(); i++) 
			{ 
				//if values have remainder of 2 and equal to 0 then,
				if (listValues.get(i) % 2 == 0) 
				{
					//traverse backwards in arrayList
					for (int j = i; j > evens; j--) 
					{
						//move evens to front of arrayList
						temp = listValues.get(j - 1); 
						listValues.set(j-1, listValues.get(j));
						listValues.set(j, temp);
					}
				}
			}
		}
		
		// return second largest el in array
		public int ret2ndLargest() 
		{
			//declare a variable of type int named largest and initialize it
			int largest = 0;
			//traverse the arrayList
			for (int i = 0; i < listValues.size(); i++) 
			{ 
				// if there are values larger than "largest", then
				if (listValues.get(i) > largest) 
				{ 
					//save this value as largest
					largest = listValues.get(i);
				}
			}

			//declare a variable of type int named secondLargest and initialize it to 0
			int secondLargest = 0;
			//traverse the ful length of the array incrementing by 1 each iteration
			for (int i = 0; i < listValues.size(); i++) 
			{ 
				//if values is less than "largest" and greater than "secondLargest" then,
				if (listValues.get(i) < largest && listValues.get(i) > secondLargest) 
				{ 
					//save this values as second largest
					secondLargest = listValues.get(i);
				}
			}
			//otherwise
			return secondLargest;
		}
		
		//returns true if array is sorted in increasing order 
		public boolean isSorted() {
			// begin at first index and traverse arrayList to last element
			for (int i = 0; i < listValues.size() - 1; i++) 
			{ 
				//if value 0 is greater than value next to it then
				if (listValues.get(i) > listValues.get(i + 1)) 
				{   
					return false;
				}
			}
		//otherwise
		return true;
		}
		
		//return true if array contains 2 adjacent duplicate values
		public boolean hasAdjDuplicates() {
			//begin at first index and traverse arrayList to last element
			for (int i = 0; i < listValues.size() - 1; i++) 
			{  			
				//if values of each element traversed is equal to value next to it, then
				if (listValues.get(i) == listValues.get(i + 1)) 
				{ 
					return true;
				}
			}
			//otherwise
			return false;
		}
		
		// return true if array contains 2 duplicate values
		//duplicates need not be adjacent to return true
		public boolean hasDuplicates() 
		{	
			//traverse the arrayList to the last element, incrementing by 1 each time
			for (int i = 0; i < listValues.size() - 1; i++) 
			{ 
				//test every value against the one looking at
				for (int j = i + 1; j < listValues.size(); j++) 
				{ 
					//if listValues equal to j, then
					if (listValues.get(i) == listValues.get(j)) 
					{ 
						//return true
						return true;
					}
				}
			} 
			//otherwise
			return false;
		}
		
		public ArrayList<Integer> getNewList (int size) 
		{
			Random myGen = new Random();
			//our initial random test data goes into the following array list
			//don't make changes to this array, it will hold your test data
			ArrayList<Integer> listTestValues = new ArrayList<Integer>();
			
			//fill in test arrayList
			for (int i=0; i<size; i++) 
			{
				//fills the array List with random ints between 1 and 50 inclusive
				listTestValues.add(1+myGen.nextInt(50));
			}
			return listTestValues;
		}
		
		public static void main(String[] args) 
		{
			//First fill an array with random values
			Random myGen = new Random();
			final int TEST_SIZE = 9;
			//our initial random test data goes into the following array list
			ArrayList<Integer> listTestValues = new ArrayList<Integer>();
			//fill in test arrayList
			for (int i=0; i<TEST_SIZE; i++) 
			{
				//fills the array List with random ints between 1 and 50 inclusive
				listTestValues.add(1+myGen.nextInt(50));
			}
			
			//print the array list to show initial values
			System.out.println("Initial Array List:");
			
			System.out.println(listTestValues);
			System.out.println();
			
			//create a new ArrayListMethods object.
			//note the following line will also initialize arraylist data
			ArrayList_methods myMethods = new ArrayList_methods(listTestValues);
						
			//Test of swapFirstAndLast()
			System.out.println("Before call to swapFirstAndLast():");
			System.out.println(myMethods.listValues);
			//swap first and last element
			myMethods.swapFirstAndLast();
			System.out.println("After call to swapFirstAndLast():");
			System.out.println(myMethods.listValues);
			System.out.println();
			//reset the Array List to the initial test values
			myMethods.setListValues(listTestValues);
						
			//Test of shiftRight()
			System.out.println("Before call to shiftRight():");
			System.out.println(myMethods.listValues);
			//shift right
			myMethods.shiftRight();
			System.out.println("After call to shiftRight():");
			System.out.println(myMethods.listValues);
			System.out.println();
			//reset the Array List to the initial test values
			myMethods.setListValues(listTestValues);
			
			//Test of setEvensToZero()
			System.out.println("Before call to setEvensToZero():");
			System.out.println(myMethods.listValues);
			//swap first and last element
			myMethods.setEvensToZero();
			System.out.println("After call to setEvensToZero():");
			System.out.println(myMethods.listValues);
			System.out.println();
			//reset the Array List to the initial test values
			myMethods.setListValues(listTestValues);
			
			// Test of largerOfAdjacents()
			System.out.println("Before call to largerOfAdjacents()");
			System.out.println(myMethods.listValues);
			//find and order larger of adjacents
			myMethods.largerOfAdjacents();
			System.out.println("After call to largerOfAdjacents()");
			System.out.println(myMethods.listValues);
			System.out.println();
			// reset the Array to the initial test values
			myMethods.setListValues(listTestValues);
			
			//Test of to removeMiddle()
			System.out.println("Before call to removeMiddle(), even case");
			myMethods.listValues = myMethods.getNewList(10);
			System.out.println(myMethods.listValues);
			//remove middle
			myMethods.removeMiddle();
			System.out.println("After call to removeMiddle()");
			System.out.println(myMethods.listValues);
			//reset the Array to the initial test values
			myMethods.listValues = myMethods.getNewList(9);
			System.out.println("Before call to removeMiddle(), odd case");
			System.out.println(myMethods.listValues);
			//remove middle
			myMethods.removeMiddle();
			System.out.println("After call to removeMiddle()");
			System.out.println(myMethods.listValues);
			System.out.println();
			//reset the Array to the initial test values
			myMethods.setListValues(listTestValues);

			//Test of moveEvensToFront()
			System.out.println("Before call to moveEvensToFront()");
			System.out.println(myMethods.listValues);
			//move evens to front
			myMethods.moveEvensToFront();
			System.out.println("After call to moveEvensToFront()");
			System.out.println(myMethods.listValues);
			System.out.println();
			//reset the Array to the initial test values
			myMethods.setListValues(listTestValues);

			//Test of ret2ndLargest()
			System.out.println("Before call to ret2ndLargest()");
			System.out.println(myMethods.listValues);
			//second largest
			int secondLargest = myMethods.ret2ndLargest();
			System.out.println("After call to ret2ndLargest()");
			System.out.println("2nd Largest Value: " + secondLargest);
			System.out.println();
			//reset the Array to the initial test values
			myMethods.setListValues(listTestValues);
			
			//Test of isSorted()
			System.out.println("Before call to isSorted() - random array input");
			System.out.println(myMethods.listValues);
			//loop to print if-else sys out statement
			
			if (myMethods.isSorted()) 
			{
				System.out.println("Array is SORTED in increasing order ");
			} 
			
			else 
			{
				System.out.println("Array is UNSORTED");
			}
			
			System.out.println("Before call to isSorted() - sorted array input");
			Collections.sort(myMethods.listValues);
			System.out.println(myMethods.listValues);
			
			if (myMethods.isSorted()) 
			{
				System.out.println("Array is SORTED in increasing order ");
			} 
			
			else 
			{ 
				System.out.println("Array is UNSORTED");
			}
			System.out.println();
			
			//Test of hasAdjDuplicates()
			System.out.println("Before call to hasAdjDuplicates() - Random Array");
			System.out.println(myMethods.listValues);

			//loop to print if-else sys out statement
			if (myMethods.hasAdjDuplicates()) 
			{
				System.out.println("Array HAS Adjacent Duplicates.");
			} 
			
			else 
			{
				System.out.println("Array DOES NOT have Adjacent Duplicates.");
			}
			System.out.println("Before call to hasAdjDuplicates() - array set to get TRUE");
			myMethods.listValues.set(5,myMethods.listValues.get(6));
			System.out.println(myMethods.listValues);
			
			if (myMethods.hasAdjDuplicates()) 
			{
				System.out.println("Array HAS Adjacent Duplicates.");
			} 
			else 
			{ 
				System.out.println("Array DOES NOT have Adjacent Duplicates.");
			}
			System.out.println();
			System.out.println();
			System.out.println();

			// Test of hasDuplicates()
			System.out.println("Before call to hasDuplicates() - Array set for FALSE");	
			for (int i = 0; i < myMethods.listValues.size(); i++)
			{
				myMethods.listValues.set(i,i);
			}
			System.out.println(myMethods.listValues);
			
			if (myMethods.hasDuplicates()) 
			{
				System.out.println("Array HAS duplicates ");
			} 
			
			else 
			{
				System.out.println("Array DOES NOT have Duplicates");
			}
		
			System.out.println("Before call to hasDuplicates() - array set for TRUE");
			myMethods.listValues.set(2, myMethods.listValues.get(6));
			System.out.println(myMethods.listValues);
			
			if (myMethods.hasDuplicates()) 
			{
				System.out.println("Array HAS duplicates ");
			} 
			
			else 
			{
				System.out.println("Array DOES NOT have Duplicates");
			}
			
			System.out.println();
		}
	}

