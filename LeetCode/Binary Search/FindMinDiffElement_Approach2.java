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
2.else answer will be given by it's neighbours in the sorted array if it were present in the array
3.That is 10 and 15 over here
4.Dry run of the normal binary searcg if the key is not present

Arr: 1 2 8 10 15
i  : 0 1 2 3  4			(mid=>0+4/2=>2),start=0,end=4
     s   m    e			(arr[mid]<ele), start=mid+1, start=3, mid=(3+4)/2==>3
           s  e
           m			(arr[mid]<ele), start=mid+1, start=4, mid=(4+4)/2==>4
           	  e,s,m		(arr[mid]>ele), end=mid-1, end=3
           e  s,m		(end>start), loop exits


start=4 arr[4]=15
end=3  arr[3]=10

//got the neighbours
*/
public class FindMinDiffElement_Approach2
{
	public static int findMin(int arr[], int key)
	{
		int start = 0, end = arr.length-1;

		while(start<=end)
		{
			int mid= start+ (end-start)/2;

			if(arr[mid]==key)
				return arr[mid];

			else if(arr[mid]<key)
				start=mid+1;

			else if(arr[mid]>key)
				end=end-1;
		}

		int a = Math.abs(key-arr[start]);
		int b = Math.abs(key-arr[end]);

		if(a<b)
			return arr[start];
		else
			return arr[end];
	}

	public static void main(String args[])
	{
		int arr[] = {1,3,8,10,15};
		System.out.println(findMin(arr,12));
	}
}