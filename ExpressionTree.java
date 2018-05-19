import java.util.Scanner;
import java.util.Stack;

//ETree class
class ExpressionTree 
{
	//Create a node class to create the structure of the tree
	class Node 
	{
		//Initialize two separate nodes for the Node class of type Node
		Node left_child = null;
		Node right_child = null;
		
		//var to represent the data passed into the constructor
		String sData;

		//constructor to initialize the data for the nodes
		//s will either be a double or an operator
		Node(String s) 
		{
			sData = s;
		}
	}
	
	//initialize the rootNode to null
	Node rootNode = null;

	/*
	 * One arg load postfix method for user data to be entered into main.
	 * This method will parse the String into an array.
	 */
	public void loadPostfix(String postfix) 
	{
		//store the postfix in an array to split the values
		//use the split method or else it will not separate the values
		//split("\\s+") splits the string into string of the array with spaces
		String[] elements = postfix.split("\\s+");
	
				//create a stack of Nodes as specified in the assignment
				Stack<Node> aStack = new Stack<Node>();
				
				//t is root, t1 and t2 are children 
				Node t, t1, t2;
				
				//loop through the elements array, which contains
				//the postfix expression
				for (int i = 0; i < elements.length; i++) 
				{
					//if it is not an operator it means it's a double
					if (!isOperator(elements[i])) 
					{
						//so create a new element
						t = new Node(elements[i]);
						//and then push it on the stack of nodes
						aStack.push(t);
					} 
					
					//else if it is operator (when you get an operator), 
					//now create a node with a left and right child)
					else 
					{
						//creating new node with operator
						t = new Node(elements[i]);
						
						//and pop t1 and t2
						t1 = aStack.pop(); 
						t2 = aStack.pop();

						//now add the left and right operator
						t.right_child = t1;
						t.left_child = t2;

						//and then push these back on the stack
						aStack.push(t);
						
						//So, e.g., as discussed in class if we have a postfix expression 1 2 + 
						//the 1 goes first, then the 2, but then the + would create a new node
						//and pops 1 and 2 them from the stack and prints them in rht and left 
						//child of the root operator
					}
				}

				//only element will be root of expression tree
				t = aStack.peek();
				aStack.pop();
				rootNode = t;
	}
	
	//infix method calls the inorder traversal of the tree
	public String infix() 
	{
		//the infix method below has the rootNode passed in
		return infix(rootNode);
	}

	//prefix method calls the preorder traversal of the tree
	public String prefix() 
	{
		//the prefix method below has the rootNode passed in
		return prefix(rootNode);
	}

	//gets the height of the tree
	public int height() 
	{
		//the height method below has the rootNode passed in
		return height(rootNode);
	}

	//method takes a string and parses it as a double
	//we have to have this to check whether or not the value is or is
	//not a double
	boolean isOperator(String s) 
	{
		try 
		{
			//if you try to parse something that is not a double
			//it will throw an exception, which means it has to be an operator
			Double.parseDouble(s);
			return false;
		} 
		
		//catch return indicating it must be an operator, since it 
		//couldn't parse as double
		catch (Exception e) 
		{
			return true;
		}
	}

	//inorder traversal method using recursion to "recurse" the nodes
	private String infix(Node n) 
	{
		String infixStr = " ";
		
		//if not equal to null then...else just return space
		//it would equal null if you try to push a right or left child
		//if no left or right child, then you're at a double
		if (n != null) 
		{
			//now deal with left and right child - if both exist (since not not)
			if (!(n.left_child == null && n.right_child == null)) 
			{
				//then open a parentheses
				infixStr += "(";
			}
			
			//we don't need "(" if left child does not equal null
			//so if it doesn't equal null,
			if (n.left_child != null) 
			{
				//then recurse with the left child
				infixStr += infix(n.left_child);
			}
			
			//if this node is a double (meanning not an operator), then add the double
			//value to the string
			if (!isOperator(n.sData)) 
			{
				infixStr += Double.valueOf(n.sData);
			} 
			
			//otherwise
			else 
			{
				//output the operator
				infixStr += n.sData;
			}
			
			//we don't need if right child does not equal null
			//so if it doesn't equal null
			if (n.right_child != null) 
			{
				//then recurse with the right child
				infixStr += infix(n.right_child);
			}
			
			//now deal with left and right child - if both exist (since not not)
			if (!(n.left_child == null && n.right_child == null)) 
			{
				//then close the parentheses
				infixStr += ")";
			}
			//add a space between the values
			infixStr += " ";
		}
		//return the combined output
		return infixStr;
	}

	//preorder traversal method
	private String prefix(Node n) 
	{
		String prefixStr = "";
		
		//while a node exists
		if (n != null) 
		{
			//if it's not an operator, so if it's a double, then output the double
			if (!isOperator(n.sData)) 
			{
				//using valueOf() to print as a double
				//passing in the data and adding space each time
				prefixStr = prefixStr + Double.valueOf(n.sData);
			} 
			
			//otherwise
			else 
			{	//write the operator first
				prefixStr = prefixStr + n.sData;
			}
			
			//now deal with left and right child - if both exist (since not not)
			if (!(n.left_child == null && n.right_child == null)) 
			{
				//first open a left parentheses
				prefixStr += "(";
			}
			
			//if the left child exists
			if (n.left_child != null) 
			{
				//recurse into the left child
				prefixStr += prefix(n.left_child);
			}
			
			//if they both exist
			if (!(n.left_child == null && n.right_child == null)) 
			{	
				//next add a comma
				prefixStr += ",";
			}
			
			//if the right child does not equal null
			if (n.right_child != null) 
			{
				//recurse into the right child
				prefixStr += prefix(n.right_child);
			}
			
			//finally, if both exists
			if (!(n.left_child == null && n.right_child == null)) 
			{
				//close the parentheses, if necesary
				prefixStr += ")";
			}
		}
		
		//return the combined output
		return prefixStr;
	}
	
	//height method
	public int height(Node n) 
	{
		//if the left or right child is null then return 0
		//at bottom of tree, because there is no more to recurse into
		if (n.left_child == null && n.right_child == null)
		{
			//this tree does not go any deeper
			return 0;
		} 
		
		//otherwise, return the max height between them
		else 
		{
			//Regarding the 1, we have to add this level, and the max of the left and right child tree
			return 1 + Math.max(height(n.left_child), height(n.right_child));
		}
	}

	//Tester
	public static void main(String args[]) 
	{
		//create ETree object
		ExpressionTree treeTester = new ExpressionTree();
		
		//create scanner for user input
		Scanner in = new Scanner(System.in);
		System.out.print("Input: ");
		String postfix = in.nextLine();
		
		//we have to load the postfix expression here,
		//which calls the loadpostfix() method with the postfix entered passed in
		treeTester.loadPostfix(postfix);
		
		//call and print infix()
		String strInfix = treeTester.infix();
		System.out.println("Infix: " + strInfix);
		
		//call and print prefix()
		String strPrefix = treeTester.prefix();
		System.out.println("Prefix: " + strPrefix);
		
		//call and print height()
		int strHeight = treeTester.height();
		System.out.println("Height: " + strHeight);
	}
}