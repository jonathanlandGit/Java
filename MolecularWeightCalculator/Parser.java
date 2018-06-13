
/**
 * Jonathan Land
 */
import java.util.List;
import java.util.ArrayList;

public class Parser 
{
	private List<StructureObject> list = new ArrayList<StructureObject>();

	Parser() 
	{

	}

	public boolean parseString(String structure) 
	{
		String[] objects = structure.split(" ");

		for (int x = 0; x < objects.length; x++)
		{
			String[] field = objects[x].split(":");

			if (field.length != 2) 
			{
				return false;
			}

			if (!field[0].matches("[A-Za-z]+")) 
			{
				return false;
			}

			if (!field[1].matches("[0-9]+")) 
			{
				return false;
			}

			StructureObject so = new StructureObject(field[0], Integer.parseInt(field[1]));
			list.add(so);
		}

		return true;
	}

	public List<StructureObject> getList() 
	{
		return list;
	}
}
