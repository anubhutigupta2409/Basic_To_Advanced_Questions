/*
Maximum subsequence sum such that no three are consecutive
Difficulty Level : Medium
Last Updated : 28 May, 2021
Given a sequence of positive numbers, find the maximum sum that can be formed which has no three consecutive elements present.
Examples :

Input: arr[] = {1, 2, 3}
Output: 5
We can't take three of them, so answer is
2 + 3 = 5

Input: arr[] = {3000, 2000, 1000, 3, 10}
Output: 5013
3000 + 2000 + 3 + 10 = 5013

Input: arr[] = {100, 1000, 100, 1000, 1}
Output: 2101
100 + 1000 + 1000 + 1 = 2101

Input: arr[] = {1, 1, 1, 1, 1}
Output: 4

Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: 27

*/

// Java program to find the maximum
// sum such that no three are
// consecutive using recursion.
import java.util.Arrays;

class MaximumSubsequenceSumSuchThatNoThreeAreConsecutive
{

static int arr[] = {100, 1000, 100, 1000, 1};
static int sum[] = new int[10000];

// Returns maximum subsequence
// sum such that no three
// elements are consecutive
static int maxSumWO3Consec(int n)
{
	if(sum[n] != -1)
		return sum[n];

	//Base cases (process first three elements)

	if(n == 0)
		return sum[n] = 0;

	if(n == 1)
		return sum[n] = arr[0];

	if(n == 2)
		return sum[n] = arr[1] + arr[0];

	// Process rest of the elements
	// We have three cases
  	int one = maxSumWO3Consec(n-1);//arr[n] exculded
  	int two = maxSumWO3Consec(n-2)+arr[n-1];//arr[n-1] exculded
  	int three = maxSumWO3Consec(n-3)+arr[n-1]+arr[n-2];//arr[n-2] exculded

  	return sum[n] = Math.max(one,Math.max(two,three));

}

// Driver code
public static void main(String[] args)
{
	int n = arr.length;
		Arrays.fill(sum, -1);
	System.out.println(maxSumWO3Consec(n));
}
}
