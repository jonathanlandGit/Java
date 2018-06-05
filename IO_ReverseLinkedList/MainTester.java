
import java.io.IOException;

/**
 * 
 * @author Jonathan Land
 * May 17, 2017
 * 
 * Tester class to retrive and reverse txt input and output file and content
 *
 */

public class MainTester 
{
	public static void main(String[] args) throws IOException 
	{
		Reverse r = new Reverse("/Users/sland/test.txt", "/Users/sland/test1.txt");
	}
}
