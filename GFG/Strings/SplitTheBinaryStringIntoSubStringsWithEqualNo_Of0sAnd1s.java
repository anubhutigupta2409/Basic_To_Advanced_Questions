/*
Split the binary string into substrings with equal number of 0s and 1s

Given a binary string str of length N, the task is to find the maximum count of consecutive substrings str can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.
Example:


Input: str = “0100110101”
Output: 4
The required substrings are “01”, “0011”, “01” and “01”.
Input: str = “0111100010”
Output: 3

Input: str = “0000000000”

Output: -1



*/

// Java implementation of the above approach
class SplitTheBinaryStringIntoSubStringsWithEqualNo_Of0sAnd1s
{

// Function to return the count
// of maximum substrings str
// can be divided into
static int maxSubStr(String str, int n)
{
	int count0 = 0, count1 = 0, count = 0;

  	for(int i=0;i<n;i++)
    {
      	if(str.charAt(i) == '0')
          	count0++;
      	else
          	count1++;

      	if(count0 == count1)
          	count++;
    }

  	return count==0 ? -1 : count;
}

// Driver code
public static void main(String []args)
{
	String str = "0100110101";
	int n = str.length();

	System.out.println(maxSubStr(str, n));
}
}

