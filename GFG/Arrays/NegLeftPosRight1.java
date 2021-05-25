/*
Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy

An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers
appear before all positive numbers.
Examples :

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.
*/
/*
Approach-->
1. partition approach of the quick sort, that is putting the pivot element at the right place
2. simply swap two particular elements if the one at the left is not negative
*/
public class NegLeftPosRight1
{
	public static void rearrange(int arr[], int n)
	{
		int j=0,temp;

		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				if(i!=j)
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}

				j++;
			}
		}
	}

	public static void print(int arr[])
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	public static void main(String args[])
	{
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
	        int n = arr.length;

        	rearrange(arr, n);
        	print(arr);
	}
}