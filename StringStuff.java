import java.util.Scanner;

/*
@author Jonathan Land

The first part of the program prints every other letter contained in the string
The second part replaces the vowels with an underscore
The third part changes a specified letter to another letter
*/

public class StringStuff 
{
     public static void main(String[]args)
     {
      	String binary_phrase;      
     	 System.out.print("Please enter word: "); 
     	 Scanner in = new Scanner(System.in);
     	 binary_phrase = in.nextLine();
     	 String binaryCopy = binary_phrase;

      	char secondLetter = 0;
     	 System.out.println("Every other letter of the String");
      
      for(int i = 1; i < binary_phrase.length(); i +=2)
      {
    	  secondLetter = binary_phrase.charAt(i);
          System.out.println(secondLetter);
      }
      
      //////////////
      
      System.out.println();

      String[] vals = { "a", "u", "o", "e", "i" };
      
      
      char [] ch = binary_phrase.toCharArray();

      for(int i=0; i < binary_phrase.length(); i++)
      {
          if('a'==binary_phrase.charAt(i))
          {
              ch[i] = '_';
              break;
          }
          
          if('e'==binary_phrase.charAt(i))
          {
              ch[i] = '_';
              break;
          }
          
          if('i'==binary_phrase.charAt(i))
          {
              ch[i] = '_';
              break;

          }
          
          if('o'==binary_phrase.charAt(i))
          {
              ch[i] = '_';
              break;

          }
          
          if('u'==binary_phrase.charAt(i))
          {
              ch[i] = '_';
              break;
          }
                    
      }
      System.out.println(String.valueOf(ch));
      
      for (String val : vals)
      {
          binary_phrase = binary_phrase.replaceAll(val, "_");
      }
            
      System.out.println("String vowels replaced with underscores: " + binary_phrase);
      System.out.println();
            
      ///////////////
      
      String changeString = null;
      
      for(int i = 0; i < binaryCopy.length(); i++)
      {
    	  changeString = binaryCopy.replaceAll("t", "x"); 
      }
      
      System.out.println("Change 't' to 'x': " + changeString);
    }
}
	
