/*

Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination:
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be
partitioned into two such parts.

Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.


*/

class IsSumPartitionBackTracking{
    static boolean isSumPartition(int arr[],int N,int sum)
    {
        //checking the base case
        if(sum==0)
            return true;

        if(N==0 && sum!=0)
            return false;

        //divide the problem in two parts, last element and all other problems
        if(arr[N-1]>sum)
            return isSumPartition(arr,N-1,sum);

        //check for if sum can be obtained by including or excluding the last element

        return isSumPartition(arr,N-1,sum) || isSumPartition(arr,N-1,sum-arr[N-1]);
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;

        for(int i=0;i<N;i++)
            sum+=arr[i];

        if((sum&1)==1)
            return 0;

        if(isSumPartition(arr,N,sum/2))
            return 1;
        else
            return 0;
    }
}

/*
Time Complexity--> O(2*n), for optimised use DP
*/