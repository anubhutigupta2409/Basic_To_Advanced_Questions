/*
Minimize the Heights II
Medium

Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by
increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each
tower.

A slight modification of the problem can be found here.


Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as
{3, 3, 6, 8}. The difference between
the largest and the smallest is 8-3 = 5.
Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between
the largest and the smallest is 17-6 = 11.

Your Task:
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k
as input parameters and returns an integer denoting the minimum difference.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints
1 = K = 104
1 = N = 105
1 = Arr[i] = 105


*/
/*
Approachh->
1.Greedy approach says that the minimum element should be increased by k, and the maximum element should be decreased by k, in
order to minimise the height difference
2.For our simplicity we sort the array
*/

class MinimiseHeights {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min, max;
        int ans= arr[n-1]-arr[0];//as max element is at end and the first element is the minimum element now

        for(int i=1;i<n;i++)
        {
            if(arr[i]>=k)
            {
                max = Math.max(arr[i-1]+k,arr[n-1]-k);//fight for max where for other elements to become max they should be increased
                //by k and our last element according to our greedy approach should be decreased by k
                min= Math.min(arr[0]+k,arr[i]-k);//fight for min where for other elements to become min they should be decreased
                //by k and our first element according to our greedy approach should be increased by k
                ans = Math.min(ans, max-min);
            }
        }
        return ans;
    }
}
