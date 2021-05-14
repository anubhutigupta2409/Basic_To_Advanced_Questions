/*
We don't know the order of the elements, given to us, but is sure that they are sorted
*/

public class OrderAgnosticBinarySearch
{
	public int search(int arr[], int ele)
	{
		int start=0, end=arr.length-1;

		int flag=0;//0 for ascending, 1 for descending

		if(arr[0]<arr[1])
			flag=0;
		else
			flag=1;

		if(flag == 0)
		{
			while(start<=end)
	        {
	            int mid = start + (end-start)/2;//to avoid any type of overflow

	            if(ele==arr[mid])
	                return mid;
	            else if(ele<arr[mid])
	                end = mid-1;
	            else
	                start=mid+1;
	        }
		}
		else
		{
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

		return -1;
	}
}