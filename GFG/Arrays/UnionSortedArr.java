/*
Given two sorted arrays, find their union
Example:

Input : arr1[] = {1, 3, 4, 5, 7}
        arr2[] = {2, 3, 5, 6}
Output : Union : {1, 2, 3, 4, 5, 6, 7}


Input : arr1[] = {2, 5, 6}
        arr2[] = {4, 6, 8, 10}
Output : Union : {2, 4, 5, 6, 8, 10}

*/

import java.util.*;

public class UnionSortedArr
{
	public static void unionArr(int arr1[], int arr2[])
	{
		Arrays.sort(arr1);
		Arrays.sort(arr2);//as we want sorted arrays for this

		int max1= arr1[arr1.length-1];
		int max2= arr2[arr2.length-1];//as the arrays are sorted, last element is the maximum element
		int MAX=(max1>max2 ? max1 : max2);//calculating the maximum element

		//assuming the maximum element is under the range
		//here the status array represents
		//0 -> element not printed yet
		//1 -> element printed already
		//>1 -> duplicates for this element exists
		int status[]=new int[MAX+1];

		//now First element of the array has to be printed as the part of the union
		System.out.println("UNION-");
		System.out.print(arr1[0]+" ");
		//increasing it's status in the status array-
		++status[arr1[0]];

		//printing the elements from the 1st array, making sure that they are not repeated
		//basically checking if the adjacent elements are equal or not since the arrays are sorted
		for(int i=1;/*as first element is printed*/i<arr1.length;i++)
		{
			//checking if the adj. elements are equal
			if(arr1[i]!=arr1[i-1])
				System.out.print(arr1[i]+" ");

			++status[arr1[i]];//to keep record how many times an element has appeared, taking
			//both the arrays together
		}

		//printing only those elements from the array2 which are not printed only
		for(int i=0;i<arr2.length;i++)
		{
			if(status[arr2[i]]==0)
				System.out.print(arr2[i]+" ");

			++status[arr2[i]];
		}


	}

	//main function
	public static void main(String args[])
	{
		/*
		For example-input
		int arr1[] = { 1, 2, 2, 2, 3 };
	    int arr2[] = { 2, 3, 4, 5 };
	    */
	    Scanner sc= new Scanner(System.in);
	    System.out.println("Enter the number of elements for array1-");
	    int n1=sc.nextInt();
	    int arr1[]=new int[n1];
	    System.out.println("Enter the elements for array1");
	    for(int i=0;i<n1;i++)
	    	arr1[i]=sc.nextInt();

	    System.out.println("Enter the number of elements for array2-");
	    int n2=sc.nextInt();
	    int arr2[]=new int[n2];
	    System.out.println("Enter the elements for array2");
	    for(int i=0;i<n2;i++)
	    	arr2[i]=sc.nextInt();

        unionArr(arr1, arr2);
	}
}
