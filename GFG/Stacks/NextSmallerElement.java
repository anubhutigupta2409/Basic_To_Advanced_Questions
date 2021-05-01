/*
Next Smaller Element
Difficulty Level : Medium
Last Updated : 12 Feb, 2021
Given an array, print the Next Smaller Element (NSE) for every element. The Smaller smaller Element for an element x is the first
smaller element on the right side of x in array. Elements for which no smaller element exist (on right side), consider next smaller element as -1.
Examples:
a) For any array, rightmost element always has next smaller element as -1.
b) For an array which is sorted in increasing order, all elements have next smaller element as -1.
c) For the input array [4, 8, 5, 2, 25}, the next smaller elements for each element are as follows.

Element       NSE
   4      -->   2
   8      -->   5
   5      -->   2
   2      -->   -1
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.

  Element        NSE
   13      -->    7
   7       -->    6
   6       -->    -1
   12     -->     -1
*/

/*
Approach-->
 Here we maintain items in increasing order in the stack .
1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
….a) Mark the current element as next.
….b) If stack is not empty, then pop an element from stack and compare it with next.
….c) If next is smaller than the popped element, then next is the next smaller element for the popped element.
….d) Keep popping from the stack while the popped element is greater than next. next becomes the next smaller element for all such popped elements
3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.

*/
import java.util.*;

public class NextSmallerElement
{
	public static void printNSE(int arr[])
	{
		Stack<Integer> s = new Stack<>();

		s.push(arr[0]);//push first element

		for(int i=1;i<arr.length;i++)
		{
			if(s.empty())
			{
				s.push(arr[i]);
				continue;
			}

			while(!s.empty() && s.peek() > arr[i])
				System.out.println(s.pop()+" -> "+arr[i]);

			s.push(arr[i]);
		}

		//our stack should have been empty after the above loop, but if it still contains some elements means, that
		//no element is present to their right in the array which is smaller to them, tehrefore print -1 for it
		while(!s.empty())
			System.out.println(s.pop()+" -> -1");
	}
	public static void main (String[] args)
	{
        int arr[] = { 11, 13, 21, 3};

        printNSE(arr);
  	}
}