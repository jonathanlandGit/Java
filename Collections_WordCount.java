import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Jonathan Land
 * 10/23/2017
 */

public class Collections_WordCount 
{
	public static void main(String[] args) 
	{
		// user prompt
		System.out.println("Enter a string/sentence: ");
		// create scanner object
		Scanner in = new Scanner(System.in);

		// create scanner placeholder
		String input = in.nextLine();

		//create treemap to hold key and values
		TreeMap<String, Integer> countMap = new TreeMap<String, Integer>();

		//keep looping the code below as long as user inputting data
		//exits when blank line is entered
		while (!input.isEmpty()) 
		{
			// we need a list to store the strings
			List<String> paraList = new ArrayList<String>();

			// we call split to parse each word and save in paralist var
			paraList = Arrays.asList(input.split(" "));

			// we need this to track the size of the array
			int size = paraList.size();

			//loop through list to the count
			for (int j = 0; size > j; j++) 
			{
				// var to
				int count = 0;
				if (countMap.get(paraList.get(j)) != null) 
				{
					count = countMap.get(paraList.get(j));
					// System.out.println(count);
				}
				//increase count each iteration
				count++;
				//get the value to put in map
				countMap.put(paraList.get(j), count);
			}
			//needed to accept more than one line of user input
			input = in.nextLine();
		}
		// to get the maximum count of the map
		Map.Entry<String, Integer> maxCount = null;

		// loop through countMap to get the key and value
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) 
		{
			String key = entry.getKey();
			Integer value = entry.getValue();

			// output key and formatted output
			System.out.println(key + ": "  + value);

			// if statement to get the word which occurred most
			if (maxCount == null || entry.getValue() > maxCount.getValue()) 
			{
				maxCount = entry;
			}
		}
		System.out.println();
		System.out.println("Most common word: " + maxCount.getKey());
	}
}
