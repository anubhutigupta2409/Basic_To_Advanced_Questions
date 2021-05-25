import java.util.*;

public class UnionIntersectionUnsortedArr
{
	public static void ui(int arr1[], int arr2[])
	{
		int m=arr1.length, n=arr2.length;

		ArrayList<Integer> union = new ArrayList<>();
		ArrayList<Integer> intersection = new ArrayList<>();

		//for our simplicity making arr1 with size m the smaller array
		if(m>n)
		{
			int tempA[]=arr1;
			arr1=arr2;
			arr2=tempA;

			int temp = m;
			m=n;
			n=temp;
		}

		//sort the smaller array
		Arrays.sort(arr1);

		//add in union
		for(int x: arr1)
			union.add(x);

		//do binary search of every element of larger array in smaller array, if present add in intersection
		//if not present add in union
		for(int x :arr2)
		{
			if(Arrays.binarySearch(arr1,x)==-1)
				union.add(x);
			else
				intersection.add(x);
		}

		System.out.println("Union--> "+union+"\nIntersection--> "+intersection);
	}

	public static void main(String args[])
	{
		int arr1[] = { 7, 1, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };
        ui(arr1,arr2);
	}
}