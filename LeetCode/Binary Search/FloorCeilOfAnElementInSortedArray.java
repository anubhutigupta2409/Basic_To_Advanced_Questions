/*
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.
Examples :


For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
*/

/*
Note-->
We are finding floor value too
Approach-->
1. floor value of an element is itself and if it's not present in the array the greatest element in the array, smaller than the
element given is it's floor value
2. ceil value of an element is itself and if it's not present in the array the smallest element in the array, greater than the
element given is it's ceil value
*/
public class FloorCeilOfAnElementInSortedArray
{
	public static int[] findFloorCeil(int arr[],int ele)
	{
		int res[] = {-1,-1};//at 0th floor and 1st ceil

		int start=0, end = arr.length-1;

		while(start<=end)
		{
			int mid = start + (end-start)/2;

			if(arr[mid]==ele)
			{
				res[0]=arr[mid];
				res[1]=arr[mid];
				return res;
			}
			else if(arr[mid] < ele)
			{
				res[0] = arr[mid];//since this is smaller than the element therefore, possible answer
				start= mid+1;
			}
			else if(arr[mid] > ele)
			{
				res[1] = arr[mid];//since this is greater than the element therefore, possible answer
				end = mid - 1;
			}
		}

		return res;
	}
	public static void main (String args[])
	{
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
		int res[] = new int[2];
		res=findFloorCeil(arr,5);
		System.out.println("Floor= "+res[0]+" ,Ceil= "+res[1]);
	}
}