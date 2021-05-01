/*
Sum of minimum and maximum elements of all subarrays of size k.
Difficulty Level : Hard
Last Updated : 15 Jan, 2021
Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all
sub-array of size k.
Examples:


Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
        K = 4
Output : 18
Explanation : Subarrays of size 4 are :
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4
     Sum of all min & max = 6 + 4 + 4 + 4
                          = 18
*/
/*
Approach-->
The idea is to use Dequeue data structure and sliding window concept. We create two empty double ended queues of size k (‘S’ , ‘G’) that only store indexes of elements of current window that are not useless. An element is useless if it can not be maximum or minimum of next subarrays.


 a) In deque 'G', we maintain decreasing order of
    values from front to rear
 b) In deque 'S', we maintain increasing order of
    values from front to rear

1) First window size K
  1.1) For deque 'G', if current element is greater
       than rear end element, we remove rear while
       current is greater.
  1.2) For deque 'S', if current element is smaller
       than rear end element, we just pop it while
       current is smaller.
  1.3) insert current element in both deque 'G' 'S'

2) After step 1, front of 'G' contains maximum element
   of first window and front of 'S' contains minimum
   element of first window. Remaining elements of G
   and S may store maximum/minimum for subsequent
   windows.

3) After that we do traversal for rest array elements.
  3.1) Front element of deque 'G' is greatest and 'S'
       is smallest element of previous window
  3.2) Remove all elements which are out of this
       window [remove element at front of queue ]
  3.3) Repeat steps 1.1 , 1.2 ,1.3

4) Return sum of minimum and maximum element of all
   sub-array size k.
*/

import java.util.*;

public class SumOfMaxAndMinElementsInKSizeSubArrays
{
	public static int returnSum(int arr[], int k)
	{
		int sum=0;

		Deque<Integer> S= new LinkedList<>(), G = new LinkedList<>();

		//first window of size k

		int i=0;

		for(i=0;i<k;i++)
		{
			//remove all previous greater elements
			while(!S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast();

			//remove all previous smaller elements
			while(!G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast();

			S.addLast(i);
			G.addLast(i);
		}

		//process rest elements
		for(;i<arr.length ;i++)
		{
			sum+= arr[S.peekFirst()] + arr[G.peekFirst()];

			//remove all elements which do not fall in the current window

			if(!S.isEmpty() && S.peekFirst() <= i-k)
				S.removeFirst();

			if(!G.isEmpty() && G.peekFirst() <= i-k)
				G.removeFirst();

			//remove all previous greater elements
			while(!S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast();

			//remove all previous smaller elements
			while(!G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast();

			S.addLast(i);
			G.addLast(i);
		}

		sum += arr[S.peekFirst()]+arr[G.peekFirst()];

		return sum;
	}

	public static void main(String args[])
    {
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 3;
        System.out.println(returnSum(arr, k));
    }
}