/*
Binary Search on reverse sorted array, that is descending order
*/

public class BSReverseSortedArray
{
	public int search(int arr[], int ele)
	{
		int start= 0, end = arr.length -1 ;

		while(start<=end)
		{
			int mid=start + (end-start)/2 ;

			if(ele==arr[mid])
				return mid;

			else if(ele<arr[mid])
				start = mid+1;
			else
				end = mid-1;
		}
	}
}