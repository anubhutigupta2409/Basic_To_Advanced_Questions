/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input:
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated
into ascending order.
Example 2:

Input:
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as
input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2


*/

/*
Approach-->
1. low=0, mid=0, high=n-1;
2. if a[mid]==0, swap mid and low, and low++ and mid++ //low is supposed to be starting point of 1s
3. if a[mid]==1, mid++;
4. if a[mid]==2, swap mid and high, and high-- //not mid++ as the swapped element that high gave is yet to be processed
*/
class Sort012
{
    public static void sort012(int a[], int n)
    {
        // code here
        int low =0, mid=0, high=n-1;
        int temp=0;

        while(mid<=high)
        {
            switch(a[mid])
            {
                case 0 :
                    {
                        temp=a[low];
                        a[low]=a[mid];
                        a[mid]=temp;

                        mid++;
                        low++;

                        break;
                    }
                case 1 :
                    mid++;
                    break;
                case 2 :
                    {
                        temp=a[mid];
                        a[mid]=a[high];
                        a[high]=temp;

                        high--;

                        break;
                    }
            }
        }
    }
}