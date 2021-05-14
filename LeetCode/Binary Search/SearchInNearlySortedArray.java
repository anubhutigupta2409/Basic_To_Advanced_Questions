/*
Search in an almost sorted array
Difficulty Level : Medium

Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may
be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

Example :

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2
Output is index of 40 in given array

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
-1 is returned to indicate element is not present

*/

/*
Approach-->
1.use modified binary search
2.given--> any element in the given array prrsent at index i, can be present at the following indices in the actual, completely sorted array->
	i, i-1, i+1
3.therefore we check for such positions also, when we check for the middle element
4.Dry run

3 2 10 4 40
0 1 2  3 4

mid=(4+0)/2 = 2
now check
ele==arr[2]; ele==arr[2-1]; ele==arr[2+1], if found then return the index

else to move in the left sub-array move two steps left, and to move to right move two steps to the right, since along with the mid
element it's neighbours are also checked
*/
public class SearchInNearlySortedArray
{
	public static  int search(int arr[], int target)
	{
		int start= 0, end = arr.length-1;

		while(start<=end)
		{
			int mid=start+(end-start)/2;

			if(arr[mid]==target)
				return mid;

			else if(mid-1>=start/*to prevent the index out of bound, if mid is positioned at the very first position*/ && arr[mid-1]==target)
				return mid-1;

			else if(mid+1<=end && arr[mid+1]==target)
				return mid+1;

			else if(target<arr[mid])
				end = mid-2;

			else if(target>arr[mid])
				start = mid+2;
		}

		return -1;
	}

	public static void main(String args[])
	{
		 int arr[] = {3, 2, 10, 4, 40};
		 System.out.println(search(arr,4));
	}
}