/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous 
subarray) of size K.

 

Example 1:

Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
 
Example 2:
Input : 
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0 
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes 
the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting 
from the first till the end. If a window does not contain a negative integer , then return 0 for that window.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
1 <= K <= N
*/

/*
Approach-->
It is a variation of the problem of Sliding Window Maximum.
We create a Dequeue, Di of capacity k, that stores only useful elements of the current window of k elements. An element is useful
if it is in the current window and it is a negative integer. We process all array elements one by one and maintain Di to contain
useful elements of current window and these useful elements are all negative integers. For a particular window, if Di is not 
empty then the element at front of the Di is the first negative integer for that window, else that window does not contain a
negative integer.
*/


class FirstNegativeInWindowOfKSize {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        LinkedList<Integer> q = new LinkedList<>();
        long ans[] = new long[N-K+1];
        
        int i;
        
        //first k elements
        for(i=0;i<K;i++)
            if(A[i]<0)
                q.add(i);
                
        //rest elements
        while(i<N)
        {
            if(!q.isEmpty())
                ans[i-K] = A[q.peek()];
            else
                ans[i-K]=0; //window has no negative value
            
            //remove elements which are no more in the window
            while(!q.isEmpty() && q.peek() < i-K+1)
                q.poll();//remove from front
                
            //add if required element
            if(A[i]<0)
                q.add(i);
            
            i++;
        }
        
        if(!q.isEmpty())
            ans[i-K] = A[q.peek()];
        else
            ans[i-K] = 0;
        
        
            
        return ans;
    }
}