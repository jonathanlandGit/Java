package Fib5;
import java.io.*;
import java.util.*;
import java.math.*;

//Java program to compute n-th Fibonacci using BigInteger. The other programs utiliize Dynamic programming.

public class Fib5 
{
	// Returns n-th Fibonacci number
	static BigInteger fib(int n) 
	{
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(1);
		
		for (int j = 2; j <= n; j++) 
		{
			c = a.add(b);
			a = b;
			b = c;
		}

		return (a);
	}

	public static void main(String[] args) 
	{
		//int n = 1000;
		//System.out.println("Fibonacci of " + n + "th term" + " " + "is" + " " + fib(n));

		Fib5 fibTest1 = new Fib5();
		long preTime = System.currentTimeMillis();
		System.out.println("Test 1 - 30th fibonacci number: " + fibTest1.fib(1000));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds: " + (postTime - preTime));
		System.out.println();

		Fib5 fibTest2 = new Fib5();
		preTime = System.currentTimeMillis();
		System.out.println("Test 2 - 35th fibonacci number: " + fibTest2.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
		System.out.println();

		Fib5 fibTest3 = new Fib5();
		preTime = System.currentTimeMillis();
		System.out.println("Test 3 - 25th fibonacci number: " + fibTest3.fib(30));
		System.out.println("Test 3 - 30th fibonacci number: " + fibTest3.fib(35));
		postTime = System.currentTimeMillis();
		// long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
	}
}
