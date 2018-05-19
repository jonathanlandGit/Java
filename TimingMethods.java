package TimingMethods;


public class TimingMethods 
{
	// Theta N
	public static int arraySum(int[] array) 
	{
		int sum = 0; //constant
		for (int i = 0; i <= array.length-1; i++) // n times
		{
			sum += array[i];
		}
		return sum; //constant
	}

	// Theta N^2
	public static int arraySum2(int [][] arrayA)
	{
		int sum = 0;
		for (int x = 0; x < arrayA.length; x++)
		{
			for (int y = 0; y < arrayA[0].length; y++)
			{
				sum+=arrayA[x][y];
			}
		}
		return sum;
	}
	
	//Theta N^3
	public static int anotherSum(int[] array) 
	{
		int sum = 0; //constant
		for (int i = 0; i < array.length-1; i++)  // n 
		{
			array[i] = array[i] * 2;

			for (int j = 0; j < i * i; j++) // n * n = n^2
			{
				sum++; //constant
			}
		}
		return sum;
	}

	// Theta log N
	public static int binSearch(int[] arr, int key) 
	{
		int start = 0; //constant
		int end = arr.length - 1; //constant

		while (start < end)  //log n
		{
			int mid = (start + end) / 2;

			if (key == arr[mid]) 
			{
				return mid;
			}

			if (key < arr[mid]) 
			{
				end = mid - 1;
			}

			else
			{
				start = mid + 1;
			}
		}
		return -1;
	}

	//Theta n(log n)
	public static int divMethod(int[] arr)
	{	 
		int sum = 0; //constant
		for (int i = 0; i < arr.length; i++) // n 
		{
			double k = arr.length;
			
			while (k > 1) // log n
			{
				sum++; 
				k = k/2; 
			}
		}
		return sum; //constant
	}
}
