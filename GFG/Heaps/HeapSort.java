/*
Heap sort-->

Steps-->
1.building a heap from the from the given set of values (Max Heap for Ascending order, and Min Heap for descending order)
2.follow deletion-->

always the root node is deleted and placed at the end of the tree (the size of the heap is reduced by 1)
,this is replaced by the last node of the heap, and then it is heapified
3.this is repeated till the heap is of size 1
*/

import java.util.*;

public class HeapSort
{
	public static void heapSort(int arr[], int n)
	{
		//building heap
		for(int i= n/2 -1; i>=0;i--)
			heapify(arr,n,i);

		//deleting one by one
		for(int i = n-1;i>0/*as we do this till one element is left in heap*/;i--)
		{
			//swapping root node and leaf node
			int temp=arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			//heapifying reduced heap
			heapify(arr,i,0);
		}
	}

	public static void heapify(int arr[], int n, int i)
	{
		int largest = i;

		int left= 2*i + 1;
		int right = 2*i + 2;

		if(left<n && arr[largest]<arr[left])
			largest = left;

		if(right<n && arr[largest]<arr[right])
			largest = right;

		if(largest!=i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

	public static void print(int arr[],int n)
	{
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");

		System.out.println();
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n-->");
		int n= sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter " +n+" elements-->");
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		System.out.println("Your array-->");
		print(arr,n);
		heapSort(arr,n);

		System.out.println("Sorted array(Ascending order)-->");
		print(arr,n);
	}
}