/*
Rearrange array in alternating positive & negative items with O(1) extra space | Set 2
Difficulty Level : Medium

Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa. Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.
Examples:

Input :
arr[] = {-2, 3, 4, -1}
Output :
arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4} OR ..

Input :
arr[] = {-2, 3, 1}
Output :
arr[] = {-2, 3, 1} OR {-2, 1, 3}

Input :
arr[] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}
Output :
arr[] = {-5, 3, -2, 5, -6, 4, -4, 9, -1, 8}
        OR ..
*/
/*
Alternate Apporach-->
/*
1.First, sort the array in non-increasing order. Then we will count the number of positive and negative integers.
2.Then swap the one negative and one positive number in the odd positions till we reach our condition.
3.This will rearrange the array elements because we are sorting the array and accessing the element from left to right according
to our need.
*/
/*
public class Main {

    // function which works in the condition when number of
    // negative numbers are lesser or equal than positive
    // numbers
    static void fill1(int a[], int neg, int pos)
    {
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int c = a[i];
                int d = a[i + neg];
                int temp = c;
                a[i] = d;
                a[i + neg] = temp;
            }
        }
        else {
            for (int i = 1; i <= neg; i += 2) {
                int c = a[i];
                int d = a[i + neg - 1];
                int temp = c;
                a[i] = d;
                a[i + neg - 1] = temp;
            }
        }
    }

    // Function which works in the condition when number of
    // negative numbers are greater than positive numbers
    static void fill2(int a[], int neg, int pos)
    {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                int temp = c;
                a[i] = d;
                a[i + pos] = temp;
            }
        }
        else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                int temp = c;
                a[i] = d;
                a[i + pos - 1] = temp;
            }
        }
    }

    // Reverse the array
    static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    // Print the array
    static void print(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
        throws java.lang.Exception
    {
        // Given array
        int[] arr = { 2, 3, -4, -1, 6, -9 };
        int n = arr.length;
        System.out.println("Given array is  ");
        print(arr, n);
        int neg = 0, pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                neg++;
            else
                pos++;
        }
        // Sort the array
        Arrays.sort(arr);

        if (neg <= pos) {
            fill1(arr, neg, pos);
        }
        else {
            // reverse the array in this condition
            reverse(arr, n);
            fill2(arr, neg, pos);
        }
        System.out.println("Rearranged array is  ");
        print(arr, n);
    }
}
Output
Given array is
2 3 -4 -1 6 -9
Rearranged array is
-9 3 -1 2 -4 6
Time Complexity: O(N*logN)



*/
/*
Correct Approach as explained by gfg-->
The idea is to process the array and shift all negative values to the end in O(n) time. After all negative values are shifted to
the end, we can easily rearrange array in alternating positive & negative items. We basically swap next positive element at even
position from next negative element in this step.



*/
public class AlternateNegativesPositives
{
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void rearrange(int arr[],int n)
	{
		int i=0, j=n-1;

		while(i<j)
		{
			while(i<n && arr[i]>0)
				i++;

			while(j>=0 && arr[j]<0)
				j--;

			if(i<j)
				swap(arr,i,j);
		}
		if(i==n || i==0)
			return ;

		int k=0;

		while(k<n && i<n)
		{
			swap(arr,i,k);
			i++;
			k+=2;
		}
	}
	static void printArray(int arr[], int n)
	{
	    for (int i = 0; i < n; i++)
	           System.out.print(arr[i] + " ");
	       System.out.println("");
	}
	public static void main(String args[])
	{
	    int arr[] = {2, 3, -4, -1, 6, -9};

	    int n = arr.length;

	    System.out.println("Given array is ");
	    printArray(arr, n);

	    rearrange(arr, n);

	    System.out.println("Rearranged array is ");
            printArray(arr, n);
	}
}