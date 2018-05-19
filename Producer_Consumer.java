
import java.util.concurrent.Semaphore;

/*
 * @author Jonathan
 * 
 * A program demonstrating the producer-consumer problem.
 */

public class Producer_Consumer 
{
	public static void main(String[] args) 
	{
		Producer p = new Producer();
		Consumer c = new Consumer();
	}

	// We must start with Producer semaphore, because this holds the key to release to consumer for use
	static Semaphore semProd = new Semaphore(1);

	// Consumer semaphore unavailable, becuase has not been released
	static Semaphore semCon = new Semaphore(0);

	//what each is using/obtaining
	static int productId;

	public static class Consumer extends Thread 
	{
		public Consumer() 
		{
			this.setName("Consumer Thread");
			this.start();
		}

		public void run() 
		{	//consumer loop will continually ask to acquire ID
			//will only acquire when released by producer
			for (int i = 0; i < 5; i++) 
			{
				try 
				{
					//consumer tries to acquire ID
					semCon.acquire();
					System.out.println(Thread.currentThread().getName() + " Getting(From Q) Product ID:" + productId);
					//Producer releasese ID for consumer. 
					//before this consumer has to wait
					semProd.release();
				} 
				
				catch (InterruptedException e) 
				{
					
				}
			}
		}
	}

	public static class Producer extends Thread 
	{
		public Producer() 
		{
			this.setName("Producer Thread");
			this.start();
		}

		public void run() 
		{
			//loop runs up same as consumer, but producer has different role in process
			for (int i = 0; i < 5; i++) 
			{
				try 
				{
					//producer tries to acquir ID
					semProd.acquire();
					productId = i;
					System.out.println(Thread.currentThread().getName() + " Putting(In Q) Product ID:" + productId);
					//consumer releases ID
					semCon.release();
				} 
				
				catch (InterruptedException e) 
				{
					
				}
			}
		}
	}
}
