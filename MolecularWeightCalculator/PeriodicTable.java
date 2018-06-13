
/**
 * Jonathan Land
 */
import java.util.Map;
import java.util.HashMap;

public class PeriodicTable 
{
	// we need to store the data of the periodic table in a map to
	// retrieve this by moleluces class (notice this is the same
	// args that we use in that class), so we are passing in String
	// and then the Molecules class
	Map<String, Molecules> mapp = new HashMap<String, Molecules>();

	// we need a method to load the entire table in main
	private void loadTable() 
	{
		mapp.put("H", new Molecules("Hydrogen", "H", 1, 1.008));
		mapp.put("HE", new Molecules("Helium", "HE", 2, 4.003));
		mapp.put("LI", new Molecules("Lithium", "LI", 3, 6.941));
		mapp.put("BE", new Molecules("Beryllium", "BE", 4, 9.012));
		mapp.put("B", new Molecules("Boron", "B", 5, 10.811));
		mapp.put("C", new Molecules("Carbon", "C", 6, 12.011));
		mapp.put("N", new Molecules("Nitrogen", "N", 7, 14.007));
		mapp.put("O", new Molecules("Oxygen", "O", 8, 15.999));
		mapp.put("F", new Molecules("Florine", "F", 9, 18.998));
		mapp.put("NE", new Molecules("Neon", "NE", 10, 20.180));
		mapp.put("NA", new Molecules("Sodium", "NA", 11, 22.990));
		mapp.put("MG", new Molecules("Magnesium", "MG", 12, 24.305));
		mapp.put("AL", new Molecules("Aluminum", "AL", 13, 20.982));
		mapp.put("SI", new Molecules("Silicon", "SI", 14, 28.086));
		mapp.put("P", new Molecules("Phosphorous", "P", 15, 30.974));
		mapp.put("S", new Molecules("Sulfur", "S", 16, 32.066));
		mapp.put("CL", new Molecules("Chlorine", "CL", 17, 35.453));
		mapp.put("AR", new Molecules("Argon", "AR", 18, 39.948));
		mapp.put("K", new Molecules("Potassium", "K", 19, 39.098));
		mapp.put("CA", new Molecules("Calcium", "CA", 20, 40.078));
		mapp.put("SC", new Molecules("Scandium", "SC", 21, 44.956));
		mapp.put("TI", new Molecules("Titanium", "TI", 22, 47.867));
		mapp.put("V", new Molecules("Vanadium", "V", 23, 50.942));
		mapp.put("CR", new Molecules("Chromium", "CR", 24, 51.996));
		mapp.put("MN", new Molecules("Manganese", "MN", 25, 54.938));
		mapp.put("FE", new Molecules("Iron", "FE", 26, 55.845));
		mapp.put("CO", new Molecules("Cobalt", "CO", 27, 58.932));
		mapp.put("NI", new Molecules("Nickel", "NI", 28, 58.693));
		mapp.put("CU", new Molecules("Copper", "CU", 29, 63.546));
		mapp.put("ZN", new Molecules("Zinc", "ZN", 30, 65.38));
		mapp.put("GA", new Molecules("Gallium", "GA", 31, 69.723));
		mapp.put("GE", new Molecules("Germanium", "GE", 32, 72.631));
		mapp.put("AS", new Molecules("Arsenic", "AS", 33, 74.922));
		mapp.put("SE", new Molecules("Selenium", "SE", 34, 78.972));
		mapp.put("BR", new Molecules("Bromine", "BR", 35, 79.904));
		mapp.put("KR", new Molecules("Krypton", "KR", 36, 84.798));
	}

	// when we create the object, the table is loaded by that method to draw
	// from and interact with
	PeriodicTable() 
	{
		loadTable();
	}

	// the getters of molecules
	public Molecules getMolecule(String Name) 
	{
		return mapp.get(Name);
	}

	public boolean hasMolecule(String Name) 
	{
		return mapp.containsKey(Name);
	}
}
    