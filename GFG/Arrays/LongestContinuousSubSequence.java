/*
Longest consecutive subsequence
Medium
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.


Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the
array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= N <= 105
0 <= a[i] <= 105


*/
/*
Approach (as explained by gfg)-->

1.Create an empty hash.
2.Insert all array elements to hash.
3.Do following for every element arr[i]
4.Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] – 1 in the hash, if not
found, then this is the first element a subsequence.
5.If this element is the first element, then count the number of elements in the consecutive starting with this element. Iterate
from arr[i] + 1 till the last element that can be found.
6.If the count is more than the previous longest subsequence found, then update this.
*/
class LongestContinuousSubSequence
{
	static int findLongestConseqSubseq(int arr[], int n){
	//hashset
	   HashSet<Integer> h = new HashSet<>();
	   //ans = 0
	   int ans = 0;

	   //hash all array elements
	   for(int i=0;i<n;i++)
	        h.add(arr[i]);

	   // check each possible sequence from the start
        // then update optimal length
        for(int i=0;i<n;i++)
        {
            //very first element of it's coressponding subsequence
            if(!h.contains(arr[i]-1))
            {
                //check for elements greater than it

                int greater=arr[i];

                while(h.contains(greater))
                    greater++;//increase the count

                //update the answer
                ans = Math.max(ans,greater-arr[i]);
            }
        }
        return ans;

}}