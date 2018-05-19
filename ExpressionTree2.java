
import java.util.Scanner;
import java.util.Stack;

/*
 * Jonathan Land
 * 10/23/2017
 */

class Node 
{
	//Two separate nodes for the Node class
	Node left_child = null;
	Node right_child = null;
	
	//var to represent the data passed in to constructor
	String sData;

	//constructor to initialize the data for the nodes
	Node(String s) 
	{
		sData = s;
	}
}

public class ExpressionTree2 
{
	String postFixString;
	Node rootNode = null;

	public ExpressionTree2()
	{
		
	}

	public void loadPostfix(String p) 
	{
		postFixString = p;
	}

	public String infix() 
	{
		final Stack<String> nodes = new Stack<String>();

		Scanner in = new Scanner(postFixString);

		while (in.hasNext()) 
		{
			if (in.hasNextDouble()) 
			{
				double d = in.nextDouble();
				nodes.push(Double.toString(d));
			}

			else 
			{
				String a = nodes.pop();
				String b = nodes.pop();
				String operator = in.next();

				String c = "(" + b + " " + operator + " " + a + ")";

				nodes.push(c);
			}
		}

		return nodes.pop();
	}

	public String prefix() 
	{
		final Stack<String> nodes = new Stack<String>();

		Scanner in = new Scanner(postFixString);

		while (in.hasNext()) 
		{
			if (in.hasNextDouble()) 
			{
				double d = in.nextDouble();
				nodes.push(Double.toString(d));
			}

			else 
			{
				String a = nodes.pop();
				String b = nodes.pop();
				
				String operator = in.next();

				String c = operator + "(" + b + "," + a + ")";

				nodes.push(c);
			}
		}
		return nodes.pop();
	}
	
	public int height() 
	{
		Scanner in = new Scanner(postFixString);
		
		int height = 0;
		int reduce = 0;

		while (in.hasNext()) 
		{
			if (in.hasNextDouble()) 
			{
				double d = in.nextDouble();
				height = height - reduce;
				reduce = 0;
			}

			else 
			{
				String operator = in.next();
				height += 1;
				reduce = 1;
			}
		}
		return height;
	}
	

	public static void main(String[] args) 
	{
		ExpressionTree2 e = new ExpressionTree2();
		String s = "1 1 1 1 1 1 1 1 * + - FOO PROCESS / X";

		System.out.println(s);
		e.loadPostfix(s);
		System.out.println(e.infix());
		System.out.println(e.prefix());
		System.out.println("Height: " + e.height());
	}
}

