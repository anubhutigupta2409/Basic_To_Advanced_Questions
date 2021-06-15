/*

Max Sum Subarray of size K

Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.



Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.


Example 2:

Input:
N = 4, K = 4
Arr = [100, 200, 300, 400]
Output:
1000
Explanation:
Arr1 + Arr2 + Arr3
+ Arr4 =1000,
which is maximum.


Your Task:

You don't need to read input or print anything. Your task is to complete the function maximumSumSubarray() which takes the integer k, vector Arr with size N, containing the elements of the array and returns the maximum sum of a subarray of size K.



Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)



Constraints:
1<=N<=105
1<=K<=N
*/
/*
Approachh-->
1. Find all the possible sub-arrays of size k, and store their sum, then return the maximum sum
Code segment-->

for(int i=0;i<n;i++)
	for(int j=i;j<i+k;j++)

Time Complexity--> O(n*k)
2.  a) Identification--> 1. Array Given, 2.Subarray is talked about, 3. window size given , 4. Therefore, sliding window maximum can be
	   thought of.
	b) Optimisation Thought--> we are doing repetitive work if 2 3 5 2 9 7 1 is the array, in first iteration of the brute force
	   we, calculate 2+3+5 then in second we calculate 3+5+2 , where as we already calculates 3+5 ,extra task would have been
	   old sum- 2 and then + 2, that is sliding the window
*/
class MaximumSumSubArrayPfSizeK{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here

        int i=0, j=0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while(j<N)
        {
			//we add the jth element till we hit the window size
            sum= sum + Arr.get(j);

            //we hit the window size, now this sum is required for our calculations
            if(j-i+1 == K)
            {
				//calculations
                max = Math.max(sum,max);
                sum = sum - Arr.get(i);//removing the ith element to maintain the window size
                i++;//moving towards the new window
            }
            j++;
        }
        return max;
    }
}