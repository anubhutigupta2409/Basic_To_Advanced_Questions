/*
Convert a sentence into its equivalent mobile numeric keypad sequence

Given a sentence in the form of a string, convert it into its equivalent mobile numeric keypad sequence. 
 

Mobile-keypad

Examples : 
 

Input : GEEKSFORGEEKS
Output : 4333355777733366677743333557777
For obtaining a number, we need to press a
number corresponding to that character for 
number of times equal to position of the 
character. For example, for character C, 
we press number 2 three times and accordingly.

Input : HELLO WORLD
Output : 4433555555666096667775553
*/

// Java implementation to convert a
// sentence into its equivalent
// mobile numeric keypad sequence
import java.util.*;

class ConvertIntoMobileNumericKeypadSequence
{

	// Function which computes the sequence
	static String printSequence(String arr[],
							String input)
	{
		int n = input.length();
      	
      	//output
      	String res = "";
      
      	//traversing
      	for(int i=0;i<n;i++)
        {
          	//check for spaces
          	if(input.charAt(i)==' ')
              	res += "0";
          	else
            {
              	int pos = input.charAt(i) - 'A';
              	res+=arr[pos];
            }
        }
      
      return res;
	}
	
	// Driver Function
	public static void main(String[] args)
	{
		// storing the sequence in array
		String str[] = {"2","22","222",
						"3","33","333",
						"4","44","444",
						"5","55","555",
						"6","66","666",
						"7","77","777","7777",
						"8","88","888",
						"9","99","999","9999"
					};

		String input = "GEEKSFORGEEKS";
		System.out.println(printSequence(str, input));
	}
}

// This code is contributed by Gitanjali.
