package Fibonacci_DP_Array;

/*
 @author Jonathan Land
 
 This program is an example of applying dynamic programming using an array data structure to cache the values. 
 The program calculates the timings of various data sizes. THese, of course, can be changed in the code.
 */

public class Fibonacci_DP_Array
{
	//create an array of size 200
	static int[] fibArr = new int[200];

	//one arg fibonacci method
	public static int fib(int n) 
	{
		//if 1 then we just return
		if (n <= 1) 
		{
			return n;
		}

		//if n is not -1 then it is in memory
		//and alreayd calculated, so just return it
		if (fibArr[n] != -1) 
		{
			return fibArr[n];
		}

		//else calculate by recurrence relation and return value
		return fibArr[n] = fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) 
	{		
		for (int i = 0; i < 199; i++) 
		{
			//set fibArr to -1
			//if f[i] is -1, then f[i] is not calculated yet
			fibArr[i] = -1;
		}
		
		Fibonacci_DP_Array fibTest1 = new Fibonacci_DP_Array();
		long preTime = System.currentTimeMillis();
		System.out.println("Test 1 - 30th fibonacci number: " + fibTest1.fib(70));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds: " + (postTime - preTime));
		System.out.println();

		Fibonacci_DP_Array fibTest2 = new Fibonacci_DP_Array();
		preTime = System.currentTimeMillis();
		System.out.println("Test 2 - 35th fibonacci number: " + fibTest2.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
		System.out.println();

		Fibonacci_DP_Array fibTest3 = new Fibonacci_DP_Array();
		preTime = System.currentTimeMillis();
		System.out.println("Test 3 - 25th fibonacci number: " + fibTest3.fib(30));
		System.out.println("Test 3 - 30th fibonacci number: " + fibTest3.fib(35));
		postTime = System.currentTimeMillis();
		// long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
	}
}



