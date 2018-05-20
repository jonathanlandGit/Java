package Concurrency_semaphores;

import java.util.concurrent.Semaphore;

/*
 * 
 * @author Jonathan Land
 * 
 * This program uses seamphores/locks in order to access data.
 * The first thread runs, acquires the lock, and then counts down from 20-10
 * 
 * The second thread waits for turn to access lock and only does so when 
 * lock1 releases the semaphore to it. The second thread then counts down
 * from 9 to 0. 
 *
 */

public class ConcurrencyAndSemaphores 
{
	static Semaphore lock1 = new Semaphore(1);
	static Semaphore lock2 = new Semaphore(1);

	static public class testclass1 implements Runnable 
	{
		public void run() 
		{
			try 
			{
				// attempt to acquire lock 1
				System.out.println("class 1 - Attempting to acquire lock 1");
				Thread.sleep(2000);
				lock1.acquire();
				System.out.println("class 1 - Aquired Lock 1: Commencing countdown");
				Thread.sleep(2000);

				for (int i = 20; i >= 10; i--) 
				{		
					System.out.println(i + " v ");
					Thread.sleep(100);
				}

				System.out.println();
				lock1.release();
				Thread.sleep(6000);

				System.out.println("Class 1 - Attempting to acquire lock 2");
				Thread.sleep(2000);
				lock2.acquire();
				System.out.println("class 1 - Aquired Lock 2: Commencing countup");
				Thread.sleep(2000);
				
				for (int i = 1; i <= 9; i++) 
				{
					System.out.println(i + " ^ ");
					Thread.sleep(100);
				}
				
				System.out.println();
				lock2.release();
				Thread.sleep(6000);
	
			}

			catch (InterruptedException e) 
			{

			}
		}
	}

	static public class testclass2 implements Runnable 
	{

		public void run() 
		{

			try 
			{
				Thread.sleep(6000);
				// attempt to acquire lock 1
				System.out.println("class 2 - Attempting to acquire lock 1");
				Thread.sleep(2000);
				lock1.acquire();
				Thread.sleep(2000);
				System.out.println("class 2 - Aquired Lock 1: Commencing countdown");

				for (int i = 9; i >= 0; i--) {
					System.out.println(i + " v ");
					Thread.sleep(100);
				}
				
				System.out.println();
				Thread.sleep(7000);

				System.out.println("Class 2 - Attempting to acquire lock 2");
				lock2.acquire();
				System.out.println("class 2 - Aquired Lock 2: Commencing countup");
				Thread.sleep(3000);
				
				for (int i = 10; i <= 20; i++) 
				{
					System.out.println(i + " ^ ");
					Thread.sleep(100);
				}
				
				System.out.println();
				lock2.release();
				
				
				/*
				 * //attempt to acquire lock 1
				 * System.out.println("class 2 - Attempting to acquire lock 1");
				 * lock1.acquire(); //output message isn't executed, because
				 * class 1 lock 1
				 * System.out.println("class 2 - Aquired Lock 1");
				 */
			}

			catch (InterruptedException e) 
			{

			}
		}
	}

	public static void main(String[] args) 
	{
		(new Thread(new testclass1())).start();
		(new Thread(new testclass2())).start();
	}
}
