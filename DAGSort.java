
import java.util.*;

public class DAGSort 
{
	public static void main(String[] args) 
	{
		// Use this variable to store your graph data structure
		Map<String, Set<String>> graph = new TreeMap<>();

		// Use this variable to collect the vertices in sorted order
		List<String> orderList = new LinkedList<>();

		// Load the graph from System.in
		// Die gracefully on error
		try 
		{
			Scanner input = new Scanner(System.in);
			int count = input.nextInt();

			System.out.println("Going to read " + count + " vertices, or die trying...");

			for (int v = 0; v < count; v++) 
			{
				// read src and dst labels
				String src = input.next();
				String dst = input.next();

				// create a TreeSet for vertex src if necessary
				if (!graph.containsKey(src)) 
				{
					graph.put(src, new TreeSet<>());
				}

				// add src->dst edge to graph
				graph.get(src).add(dst);

				// create a TreeSet for vertex dst if necessary
				if (!graph.containsKey(dst)) 
				{
					graph.put(dst, new TreeSet<>());
				}
			}

			System.out.println("loaded graph: " + graph);
		}

		catch (InputMismatchException e) 
		{
			System.out.println("Error loading graph");
			System.exit(-1);
		}

		int vertexCount = graph.size();
		System.out.println("Read graph with " + vertexCount + " vertices");

		// The keys in the Map `graph' correspond to all vertices in the graph

		// Step 1:
		// Determine the indegree of all vertices in the graph
		TreeMap<String, Integer> indegree = new TreeMap<>();

		// initialize indegree to 0 for all vertices
		for (String v : graph.keySet()) 
		{
			indegree.put(v, 0);
		}

		// update the indegree map so that the number of incoming edges
		// is counted for each vertex. (this is the number of times that each
		// vertex appears in a destination set in `graph')

		// YOUR CODE GOES HERE

		//enhanced for that goes thorugh graph
		for (String from : graph.keySet()) 
		{
			for (String to : graph.get(from)) 
			{
				//increment indegree and put into output list
				indegree.put(to, indegree.get(to) + 1);
			}
		}

		// Test that this worked:
		System.out.println("Indegrees: " + indegree);

		// Step 2:

		// for each vertex V in the indegree map (the vertices are the keys) ..

		// .. if the indegree of V is zero, 'visit' V by adding it to
		// `orderList'
		// ..... subtract one from the indegree of each vertex reachable from V
		// (look in graph)
		// ..... remove V from the indegree map

		// Step 2.5: The loop above should be done repeatedly, as long as the
		// indegree map is not empty. If you ever pass through the entire map
		// without finding a vertex with indegree 0, then you should exit the
		// program with a "cycle detected" message

		// YOUR CODE GOES HERE

		// as long as indegree map is not empty, continually repeat the following
		int mapSize = indegree.size();
		
		while (!indegree.isEmpty()) 
		{
			// for each vertex V in the indegree map (keyset)
			//constructing iterator and we're attaching iterator the class
			//the for loop exits when we're at the end of the iterator
			for(Iterator<Map.Entry<String, Integer>> iter = indegree.entrySet().iterator(); iter.hasNext();) 
			{
				//getting next entry from the map
			     Map.Entry<String, Integer> entry = iter.next();
			   
				//if indegree is 0, add this to the order list
				if (indegree.get(entry.getKey()) == 0) 
				{
					//add to the orderlist
					orderList.add(entry.getKey());

					//and subtract one from the indegree of each vertex
					//reachable from V (in graph)
					for (String neighbor : graph.get(entry.getKey())) 
					{
						indegree.put(neighbor, indegree.get(neighbor) - 1);
					}
					
					//remove from the iterator since we've already visited this node and 
					//don't need to visit it again
					iter.remove();
				}
			}
			
			//if we didn't remove any entries, then we know we have loop 
			if(mapSize == indegree.size())
			{
				System.out.println("Cycle detected/this graph is cyclic");
				System.exit(0);
			}
			
			//to track if the map has been changed
			else
			{
				mapSize = indegree.size();
			}
		}

		// Step 3: Print out the visited vertices in sorted order
		System.out.println("Sorted order: " + orderList);
	}
}

