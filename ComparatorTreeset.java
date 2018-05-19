import java.util.Comparator;
import java.util.TreeSet;

/*
 * Jonathan Land
 * 10/23/2017
 */

public class ComparatorTreeset 
{
	static class LenComp implements Comparator<String> 
	{
		//2 arg method to compare Strings via Comparator interface
		public int compare(String wordA, String wordB) 
		{
			//if the first word length is greater than the
			//second word length
			if (wordA.length() > wordB.length())
			{
				//return -1
				return -1;
			}
			
			//if word a is less than word b
			else if (wordA.length() < wordB.length())
			{
				//return 1
				return 1;
			}
			
			//otherwise
			else
			{
				//compare the word and return
				return wordB.compareTo(wordA);
			}
		}
	}
	
	//tester
	public static void main(String[] args) 
	{
		//create new Treeset object with LenComp passed in
		TreeSet<String> tester = new TreeSet<>(new LenComp());
		tester.add("art");
		tester.add("a");
		tester.add("b");
		tester.add("scrub");
		tester.add("a");
		tester.add("zebra");
		
		for (String s : tester) 
		{
			System.out.println(s);
		}
	}
}


