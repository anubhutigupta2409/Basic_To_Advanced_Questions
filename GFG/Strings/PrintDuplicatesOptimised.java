/*
Write an efficient program to print all the duplicates and their counts in the input string
*/

import java.util.*;
import java.util.Map.Entry;

public class PrintDuplicatesOptimised
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s ;
		System.out.println("Enter the String-->");
		s=sc.nextLine();
		HashMap <Character, Integer> count = new HashMap<>();//<key,value>

		for(int i=0;i<s.length();i++)
			if(!count.containsKey(s.charAt(i)))
				count.put(s.charAt(i),1);

			//if key already present update the value
			else
				count.put(s.charAt(i),(count.get(s.charAt(i))+1));//get(k) returns the value, corresponding to key


		//printing the dublicate values
		for(Entry<Character,Integer> x : count.entrySet())
			if(x.getValue() > 1)
				System.out.println("Character--> "+x.getKey()+" ,Value-->"+x.getValue());
	}
}