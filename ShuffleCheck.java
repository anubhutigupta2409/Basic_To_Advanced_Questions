/*
Check if a string is a valid shuffle of two other strings

Example-->
1XY2 is a valid shuffle of XY and 12
Y12X is not a valid shuffle of XY and 12

In the above example, we have a string array named results. It contains two strings: 1XY2 and Y12X. We are checking if these two
strings are valid shuffle of strings first(XY) and second(12).

Here, the program says 1XY2 is a valid shuffle of XY and 12. However, Y12X is not a valid shuffle.

This is because Y12X has altered the order of string XY. Here, Y is used before X. Hence, to be a valid shuffle, the order of
string should be maintained.
*/

import java.util.*;

public class ShuffleCheck
{
	public static boolean shuffleCheck(String str1, String str2, String res)
	{
		//base case
		if((str1.length() + str2.length()) != res.length())
			return false;

		//three pointers
		int i=0, j=0, k=0;
		while(k != res.length())
		{
			//first character of first string and result is same
			if(i<str1.length() && str1.charAt(i)==res.charAt(k))
				i++;

			//first character of second string and result is same
			else if(j<str2.length() && str2.charAt(j)==res.charAt(k))
				j++;

			else
				return false;

			//traversing
			k++;

		}

		//if after traversing the entire result string, still some characters are left in the strings
		if(i<str1.length() || j<str2.length())
			return false;

		return true;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string 1, string2 and their shuffle (respectively)-->");
		String str1 = sc.next();
		String str2 = sc.next();
		String res = sc.next();

		if(shuffleCheck(str1,str2,res))
			System.out.println("Yes "+res+" is a valid shuffle of "+str1+" and "+str2);

		else
			System.out.println("No "+res+" is a valid shuffle of "+str1+" and "+str2);
	}
}

/*
The program gets confused if the initial letters of two strings match. For example, if ab12 and abb34 are two strings, then
abbab1234 is a valid shuffle.

However, the program will treat the first two letters ab as part of the first string. Due to this, the third letter b doesn't
match with both the third letter of the first string (1) and the first letter of the second string (a).
*/