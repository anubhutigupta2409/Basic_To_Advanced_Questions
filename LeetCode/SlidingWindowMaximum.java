/*
Question from Leet Code-

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/

/*
Understanding our own approach-
When we look at the question with a keen eye we notice that to be able to reach the solution we require continuous removal
and addition of elements from a data structure .We have seen such kind of mechanism in Queue, Here, we can think of solving the
above problem using priority queue but that will solve the problem in O(nlogk), where n is the total number of elements and
k is the size of the window, therefore, we can use the doubly ended queue/deque which is implemented as LinekdList, since we
want to keep track of the indices of the maximum element/per window, theredore, deque interface implemented as a LinkedList
can be used here.
*/

import java.util.*;

class Solution
{
	int[] maxFromWindow(int a[], int k)
	{
		int n=a.length;

		//because if the array consists of no element or only one element then we have nothing to compare with for atleast one
		//window rotation

		if(n<=1)
			return a;

		Deque<Integer> dq= new LinkedList<>();

		int ans[]=new int[n-k+1];//observe

		int i=0;
		for(;i<k;i++)
		{
			/*
			What we are doing here is we are iterating through our array till the window size and we are supposed to add the
			index of the maximum element from the window's rotation into the deque. So what we do is we add the index of the
			numbers in decresing order of the numbers which belong to those corresponding indices.

			if the element to the right is less than the current element we remove it's index from the deque, and we keep on
			removing till we get the index of the highest element.
			*/

			while(!dq.isEmpty() && a[dq.peekLast()]<=a[i])
				dq.removeLast();

			/*
			after the removing loop is over we add the index of the highest number in our deque
			*/

			dq.addLast(i);
		}

		for(;i<n;i++)
		{
			//say for example we ended the above loop, that is the last maximum element's index we added to our deque was i
			//,therefore the maximum element before that window rotation must be added at i-k of the answer array

			ans[i-k]=a[dq.peekFirst()];

			//now we check if the index position present in our deque is out of the window we are currently in, if yes we
			//remove that from the front of the deque

			if(!dq.isEmpty() && dq.peekFirst()<=i-k)
				dq.removeFirst();

			//again doing the same thing of removing the indices and then adding the maximum of the window rotation in the
			//deque

			while(!dq.isEmpty() && a[dq.peekLast()]<=a[i])
				dq.removeLast();

			dq.addLast(i);
		}

		//since we have added the maximum element from the previous window in the entire above loop therefore, we add that
		//last element in the answer

		ans[i-k]=a[dq.peekFirst()];

		return ans;
	}
}

//driver class
public class SlidingWindowMaximum
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int a[] = { 4, 3, 1, 2, 5, 3, 4, 7, 1, 9 };
		int ans[] = solution.maxFromWindow(a, 4);

		for (int x : ans)
		{
			System.out.print(x + " ");
		}
	}
}