/*
Find intersection of two sorted arrays
*/

/*
merge approach of the merge sort.
.contains() method to check the duplicacy
*/

import java.util.*;

public class IntersectionSortedArr
{
	public static void intersection(int arr1[], int arr2[])
	{
		int n=arr1.length, m=arr2.length;
		int i=0, j=0;

		ArrayList<Integer> res = new ArrayList<>();

		while(i<n && j<m)
		{
			if(arr1[i]<arr2[j])
				i++;
			else if(arr1[i]>arr2[j])
				j++;
			else
			{
				if(!res.contains(arr1[i]))
					res.add(arr1[i]);

				i++;
				j++;
			}
		}

		System.out.println("Intersection--> "+res);
	}
	public static void main(String args[])
	{
		int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };

        intersection(arr1,arr2);
	}
}

/*
Time complexity--> O(m+n)
*/