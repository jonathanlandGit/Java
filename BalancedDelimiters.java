import java.util.*;

/*
 * @author Jonathan Land
 * 
 * Program to check if delimiters are balanced or not
 * 
 */

public class BalancedDelimiters 
{
	public static void main(String[] args) 
	{

		Scanner in = new Scanner(System.in);
		
		while (true) 
		{
			String line = in.nextLine();

			if (line.length() == 0) 
			{
				System.exit(0);
			}

			Stack<Character> myStack = new Stack<Character>();
			
			int i = 0;

			boolean imbalanceFound = false;

			// loop over scanner chars
			for (i = 0; i < line.length(); i++) 
			{
				if (!imbalanceFound) 
				{
					// if scanner comes across (, {, ] , < characters, then
					if ((line.charAt(i) == '(') || (line.charAt(i) == '{') || (line.charAt(i) == '[')
							|| (line.charAt(i) == '<')) 
					{
						// add them to the stack
						myStack.push(line.charAt(i));
					}

					// else condition to check for corresponding delimiters
					else if ((line.charAt(i) == ')') || (line.charAt(i) == '}') || (line.charAt(i) == ']')
							|| (line.charAt(i) == '>'))

					{

						// if the stack is empty
						if (myStack.isEmpty() == true) 
						{
							// give statement and where index of imbalance
							// occurs at
							System.out.println("not balanced " + (i));
							imbalanceFound = true;
						}

						else 
						{
							char p = myStack.pop();

							// check for correponding ]
							// if not equal to [, then add
							if (p == '[' && line.charAt(i) != ']') 
							{
								// System.out.println("not balanced " +
								// (sPush));
								System.out.println("not balanced " + i);
								imbalanceFound = true;
							}

							// check for correponding }
							// if not equal to {, then add
							else if (p == '{' && line.charAt(i) != '}') 
							{
								// System.out.println("not balanced " +
								// (cPush));
								System.out.println("not balanced " + i);
								imbalanceFound = true;
							}

							// check for correponding )
							// if not equal to (, then add
							else if (p == '(' && line.charAt(i) != ')') 
							{
								System.out.println("not balanced " + i);
								imbalanceFound = true;
							}

							// check for correponding <
							// if not equal to >, then add
							else if (p == '<' && line.charAt(i) != '>') 
							{
								System.out.println("not balanced " + i);
								imbalanceFound = true;
							}
						}
					}
				}
			}
			
			if(!imbalanceFound)
			{
					// if the stack is empty, then sys.out
					if (myStack.isEmpty()) 
					{
						System.out.println("balanced ");
					}
					// otherwise
					else
					{	
						System.out.println("not balanced " + i);
					}
			}
		}
	}

}
