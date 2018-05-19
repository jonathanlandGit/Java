package Fibonacci;

public class Fibonacci 
{
	public static long fib(long n) 
	{
		if (n == 0) 
		{
			return 0;
		}

		else if (n == 1) 
		{
			return 1;
		}

		else 
		{
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static void main(String args[]) 
	{
		Fibonacci fibTest1 = new Fibonacci();
		long preTime = System.currentTimeMillis();
		System.out.println("Test 1" + "\n" + "50th fibonacci number: " + fibTest1.fib(50));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds: " + (postTime - preTime));
		System.out.println();
		
		Fibonacci fibTest2 = new Fibonacci();
		preTime = System.currentTimeMillis();
		System.out.println("Test 2" + "\n" + "30th fibonacci number: " + fibTest2.fib(30));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds: " + (postTime - preTime));
		System.out.println();

		Fibonacci fibTest3 = new Fibonacci();
		preTime = System.currentTimeMillis();
		System.out.println("Test 3" + "\n" + "35th fibonacci number: " + fibTest3.fib(35));
		postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
		System.out.println();

		Fibonacci fibTest4 = new Fibonacci();
		preTime = System.currentTimeMillis();
		System.out.println("Test 4" + "\n" + "30th fibonacci number: " + fibTest4.fib(30));
		System.out.println("35th fibonacci number: " + fibTest4.fib(35));
		postTime = System.currentTimeMillis();
		// long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in  milliseconds: " + (postTime - preTime));
	}
}
