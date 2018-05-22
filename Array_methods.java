package Array_methods;
import java.util.Arrays;
import java.util.Random;

/*
 * @author Jonathan Land
 * 
 * Program that executes various methods using an array data structure with randomized values each time the program runs.
 */

	public class Array_methods 
	{
	private int[] values;

	// constructor - give it an array of initial values and they will
	// be copied into the values instance variable
	public Array_methods(int[] initialValues) 
	{
		values = Arrays.copyOf(initialValues, initialValues.length);
	}

	// a function to reset the array to the values passed in as a parameter
	// you will want to use this method after each test you do in the main
	// method
	public void setValues(int[] newValues) 
	{
		values = Arrays.copyOf(newValues, newValues.length);
	}

	// helper method to print the values array
	public void printArray() 
	{
		System.out.println(Arrays.toString(values));
	}

	// accessor to get a reference to the values array
	public int[] getValues() 
	{
		return values;
	}

	public void swapFirstAndLast() 
	{
		// save the first element to a temp var
		int temp = values[0];
		// move the last element to the first position
		values[0] = values[values.length - 1];
		// now put the saved first element into the last position
		values[values.length - 1] = temp;
	}

	public void shiftRight() 
	{
		// copy last element into temp var (length-1)
		int temp = values[values.length - 1];
		// start at last element in array and walk array backwards (right to left)
		for (int i = values.length - 1; i > 0; i--) 
		{ 
			// copy values into memory location - copies previous one into the current one
			values[i] = values[i - 1];
		}
		//set temp to first index
		values[0] = temp;
	}

	// set all even elements to 0.
	public void setEvensToZero() 
	{
		// walk array forward starting at first index, incrementing each time through the loop
		for (int i = 0; i < values.length; i++) 
		{ 
			// if the current element is evenly divisible by 2 and equal to 0 then,
			if (values[i] % 2 == 0) 
			{ 
				// set the element equal to 0 
				values[i] = 0;
			}
		}
	}

	// replace el except the first and last by larger of two around it
	public void largerOfAdjacents() 
	{
		//declare int named leftHand and assign it to the first position of array
		int leftHand = values[0];
		//for loop to traverse the array begininng at 1, going to the last element, and incrementing by one
		for (int i = 1; i < values.length-1; i++)
		{	//if lefthand position is greater than the position next to it then, 
			if (leftHand > values[i+1])
			{	//swap positions
				int temp = values[i];
				values[i] = leftHand;
				leftHand = temp;
			}
			
			else 
			{
				//since the right hand is largest, will change current value to the right hand which is i
				leftHand = values[i];
				values[i] = values[i+1];
			}
		}	
	}

	// remove middle el if odd length, else remove middle two els.
	public void removeMiddle() 
	{
		//Do not do remove anything if value is less than size 3
		if (values.length < 3)
		{
			return;
		}
		//even length array
		//if the the values in array have a remainder of 2 and equal 0, then
		if (values.length % 2 == 0)
		{
			//accomplish tasks for even length array
			int[] newArray = new int [values.length-2];
			//int variable named middle and assign it the values length divided by 2
			int middle = values.length/2;
			//copy array values from index 0 to newAray pos 0, and copy middle-1
			System.arraycopy(values, 0, newArray, 0, middle-1);
			//copy array values from pos middle+1, to newArray, middle-1 and copy middle-1
			System.arraycopy(values, middle+1, newArray, middle-1, middle-1);
			//assign newArray to values variable
			values = newArray; 
		}
		
		else
		{
			//odd length array
			//only removing 1 value
			int[] newArray = new int [values.length-1];
			//this time divisible by 2
			int middle = values.length/2;
			//copy first four values 
			//copy array values from index 0 to newAray pos 0, and copy middle
			System.arraycopy(values, 0, newArray, 0, middle);
			//copy array values from middle+1 to newAray middle, and copy middle
			System.arraycopy(values, middle+1, newArray, middle, middle);
			values = newArray; 
		}
	}
	
	// move all evens to front
	public void moveEvensToFront() 
	{
		// create variable of type int and initialize it to 0
		int temp = 0;
		// create another variable and initialize it to 0
		int evens = 0;
		// traverse full length of array, incrementinby 1 each time
		for (int i = 0; i < values.length; i++) 
		{ 
			// if values have remainder of 2 and equal to 0 then,
			if (values[i] % 2 == 0) {
				// traverse backwards in array
				for (int j = i; j > evens; j--) 
				{
					//move evens to front of array
					temp = values[j - 1]; 
					values[j - 1] = values[j];
					values[j] = temp;
				}
			}
		}
	}

	// return second largest el in array
	public int ret2ndLargest() 
	{
		// declare a variable of type int named largest and initialize it
		int largest = 0;
		// traverse the array
		for (int i = 0; i < values.length; i++) 
		{ 
			// if there are values larger than "largest", then
			if (values[i] > largest) 
			{ 
				//save this value as largest
				largest = values[i];
			}
		}

		// declare a variable of type int named secondLargest and initialize it to 0
		int secondLargest = 0;
		// traverse the ful length of the array incrementing by 1 each iteration
		for (int i = 0; i < values.length; i++) 
		{ 
			// if values is less than "largest" and greater than "secondLargest" then,
			if (values[i] < largest && values[i] > secondLargest) 
			{ 
				//save this values as second largest
				secondLargest = values[i];
			}
		}
		//otherwise
		return secondLargest;
	}

	//  returns true if array is sorted in increasing order
	public boolean isSorted() 
	{ 
		// begin at first index and traverse array to last element
		for (int i = 0; i < values.length - 1; i++) 
		{ 
			// if value 0 is greater than value next to it then
			if (values[i] > values[i + 1]) 
			{ 
				return false;
			}
		}
		// otherwise
		return true;
	}
	
	//  return true if array contains 2 adjacent duplicate values

	public boolean hasAdjDuplicates() 
	{
		//traverse the array beginning at first index, moving to last index, incrementing by 1
		for (int i = 0; i < values.length-1; i++)
		{
			//if values of each element traversed is equal to value next to it, then
			if (values[i] == values[i+1]) 
	        	{
			 	return true;
	        	}
	    }
		//otherwise
	    return false;
	}

	//  return true if array contains 2 duplicate values
	// duplicates need not be adjacent to return true

	public boolean hasDuplicates() 
	{
		// traverse the array to the last element, incrementing by 1 each time
		for (int i = 0; i < values.length - 1; i++) 
		{ 
			// test every value against the one looking at
			for (int j = i + 1; j < values.length; j++) 
			{ 
				// if values is equal to j, then
				if (values[i] == values[j]) 
				{ 
					// return true
					return true;
				}
			}
		} 
		//otherwise
		return false;
	}

	public static void main(String[] args) 
	{
		// First fill an array with random values
		Random myGen = new Random();
		
		final int TEST_SIZE = 10;
		
		//initial random test data goes into the following array
		int[] testValues = new int[TEST_SIZE];
		
		for (int i = 0; i < testValues.length; i++) 
		{
			// fills the array with random ints between 1 and 50 inclusive
			testValues[i] = 1 + myGen.nextInt(50);
		}
		// Now print the array to show initial values
		System.out.println("Initial Array:");
		// note the usage of the "toString()" method here to print the array
		System.out.println(Arrays.toString(testValues));
		System.out.println();
		
		// create a new ArrayMethods object.
		Array_methods myMethods = new Array_methods(testValues);
		// Test methods below this line.

		// Test of swapFirstAndLast()
		System.out.println("Before call to swapFirstAndLast()");
		myMethods.printArray();
		// swap first and last element
		myMethods.swapFirstAndLast();
		System.out.println("After call to swapFirstAndLast()");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);

		// Test of shiftRight()
		System.out.println("Before call to shiftRight()");
		myMethods.printArray();
		//shift right
		myMethods.shiftRight();
		System.out.println("After call to shiftRight()");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);

		// Test of setEvensToZero()
		System.out.println("Before call to setEvensToZero()");
		myMethods.printArray();
		//set evens to zero
		myMethods.setEvensToZero();
		System.out.println("After call to setEvensToZero");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);
		
		// Test of largerOfAdjacents()
		System.out.println("Before call to largerOfAdjacents()");
		myMethods.printArray();
		//find and order larger of adjacents
		myMethods.largerOfAdjacents();
		System.out.println("After call to largerOfAdjacents()");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);
		
		// Test of to removeMiddle()
		System.out.println("Before call to removeMiddle(), even case");
		myMethods.printArray();
		//remove middle
		myMethods.removeMiddle();
		System.out.println("After call to removeMiddle()");
		myMethods.printArray();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);
		myMethods.values = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Before call to removeMiddle(), odd case");
		myMethods.printArray();
		//remove middle
		myMethods.removeMiddle();
		System.out.println("After call to removeMiddle()");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);

		// Test of moveEvensToFront()
		System.out.println("Before call to moveEvensToFront()");
		myMethods.printArray();
		//move evens to front
		myMethods.moveEvensToFront();
		System.out.println("After call to moveEvensToFront()");
		myMethods.printArray();
		System.out.println();
		// reset the Array to the initial test values
		myMethods.setValues(testValues);

		// Test of ret2ndLargest()
		System.out.println("Before call to ret2ndLargest()");
		myMethods.printArray();
		//second largest
		int secondLargest = myMethods.ret2ndLargest();
		System.out.println("After call to ret2ndLargest()");
		System.out.println("2nd Largest Value: " + secondLargest);
		System.out.println();

		// Test of isSorted()
		System.out.println("Before call to isSorted() - random array input");
		myMethods.printArray();
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
		Arrays.sort(myMethods.values);
		myMethods.printArray();
		
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
		myMethods.values = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("Before call to hasAdjDuplicates() - Random Array");
		myMethods.printArray();
		
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
		myMethods.values = new int[] { 0, 3, 5, 5, 45, 5, 33, 22, 2, 9 };
		myMethods.printArray();
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

		// Test of haveDuplicates
		System.out.println("Before call to hasDuplicates() - Array set for FALSE");	
		myMethods.values = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		myMethods.printArray();
		if (myMethods.hasDuplicates()) 
		{
			System.out.println("Array HAS duplicates ");
		} 
		
		else 
		{
			System.out.println("Array DOES NOT have Duplicates");
		}
		myMethods.values = new int[] { 26, 49, 41, 5, 33, 24, 44, 15, 46, 26 };
		System.out.println("Before call to hasDuplicates() - Array set for TRUE");
		myMethods.printArray();
		
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
