package Fibonacci_DP_Logn;
import java.util.*;

/*
 * Dynamic programming approach to calculate fibonacci numbers using an array to cache values 
 * The program also calculates the timings of various data sizes. THese, of course, can be changed in the code.
 * This algorithm performs in logN time.
 */

public class Fibonacci_DP_Logn 
{
	static long f[];
	static int MAX = 1000;
	
	public static long fib(int n) 
	{
		// Base cases
		if (n == 0)
		{
			return 0;
		}

		if (n == 1 || n == 2)
		{
			return (f[n] = 1);
		}

		// If fib(n) is already computed
		if (f[n] != 0)
			return f[n];

		int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

		f[n] = (n & 1) == 1 ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) : (2 * fib(k - 1) + fib(k)) * fib(k);

		return f[n];
	}

	public static void main(String[] args)
	{
		f = new long[MAX];

		// Test1
		Fibonacci_DP_Logn fibTest1 = new Fibonacci_DP_Logn();
		long preTime = System.currentTimeMillis();
		System.out.println("Test 1" + "\n" + "150th fibonacci number: " + fibTest1.fib(150));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();

		// Test2
		Fibonacci_DP_Logn fibTest2 = new Fibonacci_DP_Logn();
		preTime = System.currentTimeMillis();
		System.out.println("Test 2" + "\n" + "30th fibonacci number: " + fibTest2.fib(30));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();

		// Test3
		Fibonacci_DP_Logn fibTest3 = new Fibonacci_DP_Logn();
		preTime = System.currentTimeMillis();
		System.out.println("Test 3" + "\n" + "35th fibonacci number: " + fibTest3.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
		System.out.println();

		// Test4
		Fibonacci_DP_Logn fibTest4 = new Fibonacci_DP_Logn();
		preTime = System.currentTimeMillis();
		System.out.println("Test 4" + "\n" + "30th fibonacci number: " + fibTest4.fib(30));
		System.out.println("35th fibonacci number: " + fibTest4.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in miliseconds: " + (postTime - preTime));
	}
}
