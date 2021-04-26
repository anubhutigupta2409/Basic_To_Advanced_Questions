import java.util.*;

public class PrintAllPalindromicSubstrings
{
	public static boolean isPalindrome(String input, int start, int end)
	{

		while(start<end)
		{
			if(input.charAt(start++) != input.charAt(end--))
				return false;
		}

		return true;
	}

	public static void allPartitionsUtil(ArrayList<ArrayList<String>> allPart, Deque<String> currPart, int start, int end, String input)
	{
		//if we reach the end add to all partitions
		if(start>=end)
		{
			allPart.add(new ArrayList<>(currPart));
			return;
		}

		for(int i=start;i<end;i++)
		{
			if(isPalindrome(input,start,i))
			{
				//if a palindrome make it the part of current partition
				currPart.addLast(input.substring(start,i+1));

				//recur for the rest of the input string
				allPartitionsUtil(allPart,currPart,i+1,end,input);

				//remove the current substring from the current partition
				currPart.removeLast();
			}
		}
	}
	public static void allPartitions(String input)
	{
		int n = input.length();

		ArrayList<ArrayList<String>> allPart = new ArrayList<>();

		Deque<String> currPart = new LinkedList<String>();

		allPartitionsUtil(allPart, currPart, 0, n, input);

		//printing
		for(int i=0;i<allPart.size();i++)
		{
			for(int j=0;j<allPart.get(i).size();j++)
			{
				System.out.print(allPart.get(i).get(j)+" ");
			}

			System.out.println();
		}


	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		String input=sc.next();

		allPartitions(input);
	}

}