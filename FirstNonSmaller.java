import java.util.*;

/*
 * Jonathan Land
 * 9/14/2017
 *
 */

public class FirstNonSmaller 
{
	public static void main(String[] args) 
	{
		long start, end;
		java.util.Random rand = new java.util.Random();
		//part A array
		int [] array = { 1, 2, 3, 3, 3, 4, 5, 5, 14, 17 };
		
		//part B array
		int[] size = { 30000, 50000, 100000, 200000, 300000, 400000, 500000, 600000, 700000 };
		
		System.out.println("Part A: " + firstNonSmallerIndex(array, 15));
		
		System.out.println();
		
		System.out.println("Part B: ");

		for (int i : size) 
		{
			// test array
			int[] myarr = createRandomSortedArray(i);

			start = System.nanoTime();

			// method call on test int
			firstNonSmallerIndex(myarr, 10);

			end = System.nanoTime();

			System.out.println(i + " " + (end - start) / 1e6);
		}
	}

	public static int[] createRandomSortedArray(int size) 
	{
		Random rand = new Random();
		int[] array = new int[size];

		for (int i = 0; i < size; i++) 
		{
			array[i] = rand.nextInt(size * 3) - size / 4;
		}

		Arrays.sort(array);
		return array;
	}

	public static int firstNonSmallerIndex(int[] array, int value) 
	{
		//ivars
		int highest = array.length;
		int middle = -1;
		int lowest = 0;

		// boolean to keep track of value if found or not
		boolean found = false;

		/*
		 * Keep on looping array from beginning to end until value found or next
		 * highest or lowest number to value is found
		 */
		while (lowest < highest) 
		{
			// keep on splitting the whole array into two in order to increase
			// search efficiency
			// set equal to middle var
			middle = (lowest + highest) / 2;

			// if the middle of the array is equal to the value
			if (array[middle] == value) 
			{
				// the value is found
				found = true;
				// exit out of the loop
				break;
			}

			// if the middle of the array is less than the value
			else if (array[middle] < value) 
			{
				// then increase middle by 1 and place in lowest var
				lowest = middle + 1;
			}

			// else middle becomes the highest
			else 
			{
				highest = middle;
			}
		}

		// if found
		if (found) 
		{
			// return middle
			return middle;
		}

		// else if the lowest is gretaer than or equal to the
		// length of the array, then return -1
		else 
		{
			if (lowest >= array.length) 
			{
				return -1;
			}

			// return lowest
			else 
			{
				return lowest;
			}
		}
	}
}
