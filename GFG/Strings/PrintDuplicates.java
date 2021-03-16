/*
Write an efficient program to print all the duplicates and their counts in the input string
*/

import java.util.*;

public class PrintDuplicates
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("Enter the String-->");
		s=sc.nextLine();
		int count[]=new int[256];//'coz 256 possible characters
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)]++;

		for(int i=0;i<256;i++)
			if(count[i]>1)
				System.out.println("Character--> "+(char)i+" ,Count--> "+count[i]);
	}
}