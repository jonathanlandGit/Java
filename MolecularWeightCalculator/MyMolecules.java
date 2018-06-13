
/**
 * Jonathan Land
 */

import java.util.List;
import java.util.Scanner;

public class MyMolecules 
{
	public static void main(String[] args) 
	{
		PeriodicTable q = new PeriodicTable();

		Scanner in = new Scanner(System.in);

		while (true) 
		{
			boolean success = true;
			Parser myParser = new Parser();

			System.out.println("Enter a chemical forumla following the syntax of this example: H:2 O:1");
			System.out.println("(To end program type, \"Java\")");
			System.out.println();
			String value = in.nextLine();

			if (value.equals("Java")) 
			{
				return;
			}

			if (myParser.parseString(value) == false) 
			{
				System.out.print("Invalid String: " + value);
				System.out.println();
			}

			else 
			{
				double totalWeight = 0;

				List<StructureObject> myList = myParser.getList();

				for (int i = 0; i < myList.size(); i++) 
				{
					String name = myList.get(i).getName().toUpperCase();
					int count = myList.get(i).getCount();

					double weight = 0;

					if (q.hasMolecule(name)) 
					{
						weight = q.getMolecule(name).getWeight() * count;
					}

					else 
					{
						System.out.println("Unknown element: " + name);
						success = false;
						break;
					}
					totalWeight += weight;
				}

				if (success) 
				{
					System.out.println("Formula: " + value + "\n" + "Molecular weight: " + totalWeight);
					System.out.println();
				}
			}
		}
	}
}