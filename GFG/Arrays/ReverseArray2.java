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
Take two pointers 1.start=0, 2.end=n-1 ; now swap start and end positions until start<end
*/
public class ReverseArray2
{
	public static void reverse(int arr[])
	{
		int n=arr.length,temp;

		int start=0, end=n-1;

		while(start<end)
		{
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;

			start++;
			end--;
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
