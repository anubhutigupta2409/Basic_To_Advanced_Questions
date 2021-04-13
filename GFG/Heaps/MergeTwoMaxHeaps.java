/*

Given two binary max heaps as arrays, merge the given heaps, after merging the two arrays.
The task is very simple to merge the two arrays firstly keep all the elements of first array than elements second array, than apply the merge operation of heaps.



Example 1:

Input  :
n = 4 m = 3
a[] = {10, 5, 6, 2},
b[] = {12, 7, 9}
Output :
{12, 10, 9, 2, 5, 7, 6}
Explanation :








Your Task:
You don't need to read input or print anything. Your task is to complete the function leftIndex() which takes the array a[], b[], its size n and m and an answer array merged[] as inputs and stores the merged max heap.



Expected Time Complexity: O(n.Logn)
Expected Auxiliary Space: O(1)



Constraints:
1 <= n, m <= 105
1 <= a[i], b[i] <= 2*105

*/


//Approach-->

/*
Copy the contents of the two heaps in a resultant heap array and then build a max heap out of it
Time Complexity = O(n+m)
*/
class MergeTwoMaxHeaps {

    public void buildHeap(long arr[], int n)
    {
        for(int i= n/2 -1; i>=0;i--)
			heapify(arr,n,i);
    }
	public void heapify(long arr[], int n, int i)
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
			long temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}
    public void maxProfit(long merged[], long a[], long b[], long n, long m) {

        int x = (int)n;
        int y=(int)m;
        for (int i = 0; i < x; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < y; i++) {
            merged[x + i] = b[i];
        }


        buildHeap(merged,x+y);
    }
}