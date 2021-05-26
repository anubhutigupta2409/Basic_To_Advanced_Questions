/*

Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already
sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 = N = 5*105
1 = arr[i] = 1018


*/
/*
Slightly modified version of merge sort
*/
class CountInversion
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long mergeAndCount(long[] arr, int l, int mid, int r)
    {
        long[] left = Arrays.copyOfRange(arr,l,mid+1);
        long[] right = Arrays.copyOfRange(arr,mid+1,r+1);

        int i=0,j=0,k=l;
        long inv=0;

        while(i<left.length && j<right.length)
        {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
            {
                arr[k++] = right[j++];
                inv += (mid+1) - (l+i);//basically mid-i because left and right subarrays are sorted, so all the remaining
                //elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]
            }
        }
        while(i<left.length)
            arr[k++] = left[i++];

        while(j<right.length)
            arr[k++]=right[j++];

        return inv;
    }
    static long mergeSortAndCount(long arr[], int l, int r)
    {
        long inv = 0L;

        if(l<r)
        {
            int mid= l + (r-l)/2;

            inv+=mergeSortAndCount(arr,l,mid);
            inv+=mergeSortAndCount(arr,mid+1,r);

            inv+=mergeAndCount(arr,l,mid,r);
        }

        return inv;
    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSortAndCount(arr,0,arr.length-1);
    }
}