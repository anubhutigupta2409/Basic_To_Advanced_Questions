/*
Partition of a set into K subsets with equal sum
Difficulty Level : Hard

Given an integer array of N elements, the task is to divide this array into K non-empty subsets such that the sum of elements
in every subset is same. All elements of this array should be part of exactly one partition.
Examples:

Input : arr = [2, 1, 4, 5, 6], K = 3
Output : Yes
we can divide above array into 3 parts with equal
sum as [[2, 4], [1, 5], [6]]

Input  : arr = [2, 1, 5, 5, 6], K = 3
Output : No
It is not possible to divide above array into 3
parts with equal sum
*/

/*
Approach-->

We can solve this problem recursively, we keep an array for sum of each partition and a boolean array to check whether an element
is already taken into some partition or not.
First we need to check some base cases,
If K is 1, then we already have our answer, complete array is only subset with same sum.
If N < K, then it is not possible to divide array into subsets with equal sum, because we can’t divide the array into more than
N parts.
If sum of array is not divisible by K, then it is not possible to divide the array. We will proceed only if k divides sum. Our
goal reduces to divide array into K parts where sum of each part should be array_sum/K
In below code a recursive method is written which tries to add array element into some subset. If sum of this subset reaches
required sum, we iterate for next part recursively, otherwise we backtrack for different set of elements. If number of subsets
whose sum reaches the required sum is (K-1), we flag that it is possible to partition array into K parts with equal sum, because
remaining elements already have a sum equal to required sum.
*/

class PartitionSetIntoKSubsets
{
    public boolean isKPartitionPossibleUtil(int a[], int subsetSum[], boolean visited[], int subSum, int k, int n, int start, int end)
    {
        if(subsetSum[start] == subSum)
        {
            //this represents that k-1 subsets with sum = subSum are already formed
            //as the last subset will be automatically formed by the remaining elements
            if(start == k-2)
                return true;

            //recursive call for other subsets
            return isKPartitionPossibleUtil(a,subsetSum,visited,subSum,k,n,start+1,n-1);
        }

        //start from the end and add
        for(int i= end; i>=0 ; i--)
        {
            if(visited[i])
                continue;

            int temp = subsetSum[start] + a[i];

            //if temp is less then subSum then only that element is added
            //and called recursively
            if(temp <= subSum)
            {
                visited[i] = true;
                subsetSum[start] += a[i];
                boolean next = isKPartitionPossibleUtil(a,subsetSum,visited,subSum,k,n,start,i-1);

                //backtrack
                visited[i] = false;
                subsetSum[start] -= a[i];

                if(next)
                    return true;
            }
        }
        return false;
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	//base cases
	    if(k==1)
	        return true;

	    if(n<k)
	        return false;

	    int sum=0;
	    for(int i=0;i<n;i++)
	        sum+=a[i];

	    if(sum%k != 0)
	        return false;

	    int subSum = sum/k;
	    int subsetSum[] = new int[k];
	    boolean visited[] = new boolean[n];

	    subsetSum[0] = a[n-1];
	    visited[n-1] = true;

	    return isKPartitionPossibleUtil(a,subsetSum,visited,subSum,k,n,0,n-1);
    }
}
