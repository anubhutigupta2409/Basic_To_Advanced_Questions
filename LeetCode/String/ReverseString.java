/*
Write a program that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/



public class Reverse
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string you want to reverse-->");
		String str = sc.nextLine();

		char a[]= str.toCharArray();
		int left=0;//extreme left
		int right= a.length - 1;//extreme right

		for(left=0; left<right ; left++,right--)
		{
			char temp = a[left];
			a[left]=a[right];
			a[right]=temp;
		}

		System.out.println("Reversed String-->\n");

		for(char x : a)
			System.out.print(x);


	}
}

























