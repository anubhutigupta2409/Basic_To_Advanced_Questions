/*
Merge Without Extra Space
Hard
Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


Example 1:

Input:
N = 4, M = 5
arr1[] = {1, 3, 5, 7}
arr2[] = {0, 2, 6, 8, 9}
Output: 0 1 2 3 5 6 7 8 9
Explanation: Since you can't use any
extra space, modify the given arrays
to form
arr1[] = {0, 1, 2, 3}
arr2[] = {5, 6, 7, 8, 9}

Example 2:

Input:
N = 2, M = 3
arr1[] = {10, 12}
arr2[] = {5, 18, 20}
Output: 5 10 12 18 20
Explanation: Since you can't use any
extra space, modify the given arrays
to form
arr1[] = {5, 10}
arr2[] = {12, 18, 20}


Your Task:
You don't need to read input or print anything. Complete the function merge() which takes the two arrays arr1[], arr2[] and their sizes n and m, as input parameters. The function does not return anything. Use the given arrays to sort and merge arr1[] and arr2[] in-place.
Note: The generated output will print all the elements of arr1[] followed by all the elements of arr[2].


Expected Time Complexity: O((n+m)*log(n+m))
Expected Auxiliary Space: O(1)


Constraints:
1 <= N, M <= 5*104
0 <= arr1i, arr2i <= 106


*/

/*
Approach as explained at gfg-->
First example:
a1[] = {3 27 38 43},
a2[] = {9 10 82}
Start with
gap =  ceiling of n/2 = 4
[This gap is for whole merged array]
3 27 38 43   9 10 82
3 27 38 43   9 10 82
3 10 38 43   9 27 82

gap = 2:
3 10 38 43   9 27 82
3 10 38 43   9 27 82
3 10 38 43   9 27 82
3 10 9 43   38 27 82
3 10 9 27   38 43 82

gap = 1:
3 10 9 27   38 43 82
3 10 9 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
Output : 3 9 10 27 38 43 82

Second Example:
a1[] = {10 27 38 43 82},
a2[] = {3 9}
Start with gap = ceiling of n/2 (4):
10 27 38 43 82   3 9
10 27 38 43 82   3 9
10 3 38 43 82   27 9
10 3 9 43 82   27 38

gap = 2:
10 3 9 43 82   27 38
9 3 10 43 82   27 38
9 3 10 43 82   27 38
9 3 10 43 82   27 38
9 3 10 27 82   43 38
9 3 10 27 38   43 82

gap = 1
9 3 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82


Output : 3 9 10 27 38   43 82
*/
class MergeWithoutExtraSpace {
    public int nextgap(int gap)
    {
        if(gap<=1)
            return 0;

        return (gap/2) + (gap%2);/*mathematical way to write ceiling value*/
    }

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here

        int i, j, gap=n+m;

        for(gap=nextgap(gap);gap>0;gap=nextgap(gap))
        {
            //comparing in first array
            for(i=0;i+gap<n;i++)
            {
                if(arr1[i+gap]<arr1[i])
                {
                    int temp=arr1[i];
                    arr1[i]=arr1[i+gap];
                    arr1[i+gap]=temp;
                }

            }
            //comparing in both the arrays
            for(j = gap>n ? gap-n : 0; i<n&&j<m ; i++,j++)
            {
                if(arr1[i]>arr2[j])
                {
                    int temp=arr1[i];
                    arr1[i]=arr2[j];
                    arr2[j]=temp;
                }
            }
            //comparing in second array
            if(j<m)
            {
                for(j=0;j+gap<m;j++)
                {
                    if(arr2[j]>arr2[j+gap])
                    {
                        int temp=arr2[j];
                        arr2[j]=arr2[j+gap];
                        arr2[j+gap]=temp;
                    }
                }
            }
        }
    }
}