package Fibonacci_DP_LinkedList;

import java.util.LinkedList;

/*
 * Jonathan Land
 * Dynamic programming approach to calculate fibonacci numbers using a linked list to cache values
 */

public class Fibonacci_DP_LinkedList 
{
	LinkedList<Long> fibList = new LinkedList<Long>();

	public long fib(int n) 
	{
		// is element is in fibList
		if (fibList.size() > n) 
		{
			//return el 
			return fibList.get(n - 1); 
		}

		// otherwise if element is not in fibList
		else 
		{
			// base case condition
			if (n <= 2) 
			{	
				//add to list
				fibList.add((long) 1);
				//return 1, beacuse reached base condition
				return 1;
			}

			//implement fibonacci sequence stored in var value
			long value = fib(n - 1) + fib(n - 2);
			//add value to the list
			fibList.add(value);
			//return the value
			return value; 
		}
	}

	public static void main(String[] args) 
	{		
		//Test1 
		Fibonacci_DP_LinkedList fibTest1 = new Fibonacci_DP_LinkedList();
		long preTime = System.currentTimeMillis();
		System.out.println("Test 1" + "\n" + "150th fibonacci number: " + fibTest1.fib(150));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();
		
		//Test2
		Fibonacci_DP_LinkedList fibTest2 = new Fibonacci_DP_LinkedList();
		preTime = System.currentTimeMillis();
		System.out.println("Test 2" + "\n" + "30th fibonacci number: " + fibTest2.fib(30));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();

		//Test3
		Fibonacci_DP_LinkedList fibTest3 = new Fibonacci_DP_LinkedList();
		preTime = System.currentTimeMillis();
		System.out.println("Test 3" + "\n" + "35th fibonacci number: " + fibTest3.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();

		//Test4
		Fibonacci_DP_LinkedList fibTest4 = new Fibonacci_DP_LinkedList();
		preTime = System.currentTimeMillis();
		System.out.println("Test 4" + "\n" + "30th fibonacci number: " + fibTest4.fib(30));
		System.out.println("35th fibonacci number: " + fibTest4.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
	}
}

	
