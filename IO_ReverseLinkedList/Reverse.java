
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author Jonathan Land
 * May 17, 2017
 * 
 * Program reads each line in a txt file, reverse its lines, and writes the
 * lines to another file using a linkedlist
 *
 */

public class Reverse 
{
	
	/**
	 * Two arg constructor to accept input and output txt file
	 * 
	 * @param input to accept input file
	 * @param output to accept output file
	 * @throws IOException so the program won't throw an error when looking for file
	 */
	public Reverse(String input, String output) throws IOException 
	{
		//create buffered reader and buffered writer object to read linked list
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));

		LinkedList<String> ll = new LinkedList<String>();
		
		try 
		{
			//read linked list
			String line = br.readLine();

			while (line != null) 
			{
				ll.add(line);
				line = br.readLine();
			}
		}
		//close buffered reader
		finally 
		{
			br.close();
		}

		//write linked list in reverse order
		for (int x = ll.size(); x > 0; x--) 
		{
			bw.write(ll.get(x - 1));
			bw.newLine();
		}
		//close buffered writer
		bw.close();
	}
}
