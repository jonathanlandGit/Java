
/**
 * Jonathan Land
 */

public class Molecules 
{
	private String aName;
	private String aSymbol;
	private int aNumber;
	private double molWeight;

	Molecules(String Name, String Symbol, int Number, double Weight) 
	{
		aName = Name;
		aSymbol = Symbol;
		aNumber = Number;
		molWeight = Weight;
	}

	public String getName() 
	{
		return aName;
	}

	public double getWeight() 
	{
		return molWeight;
	}
}
