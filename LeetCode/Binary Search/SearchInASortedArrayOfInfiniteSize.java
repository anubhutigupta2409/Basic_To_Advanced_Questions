/*
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of
array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key,
first we find bounds and then apply binary search algorithm.
Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.

*/
public class SearchInASortedArrayOfInfiniteSize
{
	public int binarySearch(int arr[], int start, int end, int key)
	{
		while(start<=end)
		{
			int mid= start + (end-start)/2;

			if(arr[mid]==ele)
				return mid;

			else if(ele<arr[mid])
				end=mid-1;
			else
				start = mid+1;
		}

		return -1;
	}
	public int searchInInfinite(int arr[],int key)
	{
		int start=0, end = 1;

		while(arr[end] < key)
		{
			start=end;
			end=2*end;
			/*
			if this is the case, of array of unknown size then do check like this-->

			if(2*end<arr.length)
				end=2*end;
			else
				end=arr.length-1;
			*/

		}
		return binarySearch(arr,start,end,key);
	}
}