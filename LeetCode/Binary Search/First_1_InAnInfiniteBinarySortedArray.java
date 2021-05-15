/*
Find the index of first 1 in an infinite sorted array of 0s and 1s
Difficulty Level : Medium

Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first ‘1’ in that array. As the array is
infinite, therefore it is guaranteed that number ‘1’ will be present in the array.

Examples:

Input : arr[] = {0, 0, 1, 1, 1, 1}
Output : 2

Input : arr[] = {1, 1, 1, 1,, 1, 1}
Output : 0
*/

/*

Approach: The problem is closely related to the problem of finding position of an element in a sorted array of infinite numbers.
As the array is infinte, therefore we do not know the upper and lower bounds between which we have to find the occurrence of first ‘1’.
*/
public class First_1_InAnInfiniteBinarySortedArray
{
	public int findFirstOccurence(int arr[] ,int start, int end, int key)
	{
		int res=-1;

		while(start<=end)
		{
			int mid=start + (end-start)/2;

			if(arr[mid]==ele)
			{
				res = mid;
				end = mid-1;//move to left
			}
			else if(arr[mid]<ele)
				start=mid+1;
			else
				end=mid-1;
		}
		return res;
	}
	public int first1(int arr[])
	{
		int start=0, end=1, ele=1;

		while(ele>arr[end])
		{
			start=end;
			end=end*2;
		}
		return findFirstOccurence(arr, start, end, ele);
	}
}