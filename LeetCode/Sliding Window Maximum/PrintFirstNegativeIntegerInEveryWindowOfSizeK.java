/*
First negative integer in every window of size k

Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.



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
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
1 <= K <= N


*/
class PrintFirstNegativeIntegerInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {

        ArrayList<Long> ans = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();//to store negative numbers

        int i=0, j=0;//pointers

        while(j<n)
        {
            //if negative store in queue
    	    if(arr[j]<0)
      		    q.add(arr[j]);

            //if we hit the window size
    	    if(j-i+1 == k)
            {
                //answer calculation

                //if no negative number in the window
          	    if(q.isEmpty())
              	    ans.add(new Long(0));
          	    else
                {
                     //add the first negative number
              	    ans.add(q.peek());
              	    //and remove the number from queue, if it's no longer
                    //part of the window
              	    if(arr[i]==q.peek())
                  	    q.poll();
                }
          	    i++; //move forward
            }
    	    j++; //move forward
        }

        /*
        Using streams API of collections in java 8 to convert to array of
        primitive int type

        We can use this streams() method of list and mapToLong() to convert
        ArrayList<Long> to array of primitive data type long
        */
        long[] res = ans.stream().mapToLong(x -> x).toArray();
        return res;

    }
}