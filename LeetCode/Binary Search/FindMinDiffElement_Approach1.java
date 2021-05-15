/*
Find the minimum difference element in the given sorted array

Example-->
Array : 1 3 8 10 15
key : 12
Output : 10

explanation-->

(12-1) (12-3) (12-8) (12-10) (12-15)
11      9      4       2       3

minimum==2, therefore, return 10
*/

/*
Approach-->
1.if key is present than key itself is the answer as then the difference would be 0
2.else answer will be given by smallest element in the array greater to it or the greatest element in the array smaller to it
3.That is floor and ceil values
4.Than compare their differences with the key , return the minimum difference element
*/
public class FindMinDiffElement_Approach1
{
	public static int findMin(int arr[], int key)
	{
		int res[]=new int[2];
		int start = 0, end = arr.length-1;

		while(start<=end)
		{
			int mid= start+ (end-start)/2;

			if(arr[mid]==key)
				return arr[mid];

			else if(arr[mid]<key)
			{
				res[0]=mid;//floor
				start=mid+1;
			}
			else if(arr[mid]>key)
			{
				res[1]=mid;//ceil
				end=end-1;
			}
		}

		int a = Math.abs(key-arr[res[0]]);
		int b = Math.abs(key-arr[res[1]]);

		if(a<b)
			return arr[res[0]];
		else
			return arr[res[1]];
	}

	public static void main(String args[])
	{
		int arr[] = {1,3,8,10,15};
		System.out.println(findMin(arr,12));
	}
}