/*
Given an array (or string), the task is to reverse the array/string.
Examples :


Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}

*/

/*
Approach-->
swap (i)<->(n-i-1) positions, since only one swap is required therefore loop works till n/2
*/
public class ReverseArray
{
	public static void reverse(int arr[])
	{
		int n=arr.length,temp;

		for(int i=0;i<n/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[n-i-1];
			arr[n-i-1]=temp;
		}

	}
	public static void print(int arr[])
	{
		System.out.println();

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");

		System.out.println();
	}
	public static void main(String args[])
	{
		int arr[] = {1,2,3};
		System.out.println("Input-->");
		print(arr);
		System.out.println("Output-->");
		reverse(arr);
		print(arr);
	}
}
