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
Approach--> Two pointer algorithm
1. left=0, right=n-1 ; quick question what are the temporary right positions for left and right? a[left]-->-ve and a[right]-->+ve
2. left		right		operation
   -ve		-ve			l++
   -ve		+ve			l++,r--
   +ve		-ve			swap, l++,r--
   +ve		+ve			r--
*/
public class NegLeftPosRight2
{
	public static void rearrange(int arr[], int n)
	{
		int left = 0, right=n-1;

		while(left<=right)
		{
			if(arr[left]<0 && arr[right]<0)
				left++;

			else if(arr[left]>0 && arr[right]<0)
			{
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;

				left++;
				right--;
			}

			else if(arr[left]>0 && arr[right]>0)
				right--;

			else
			{
				left++;
				right--;
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