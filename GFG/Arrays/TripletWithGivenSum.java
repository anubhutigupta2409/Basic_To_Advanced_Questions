/*

Triplet Sum in Array
Medium
Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


Example 1:

Input:
n = 6, X = 13
arr[] = [1 4 45 6 10 8]
Output:
1
Explanation:
The triplet {1, 4, 8} in
the array sums up to 13.
Example 2:

Input:
n = 5, X = 10
arr[] = [1 2 4 3 6]
Output:
1
Explanation:
The triplet {1, 3, 6} in
the array sums up to 10.

Your Task:
You don't need to read input or print anything. Your task is to complete the function find3Numbers() which takes the array arr[], the size of the array (n) and the sum (X) as inputs and returns True if there exists a triplet in the array arr[] which sums up to X and False otherwise.


Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)


Constraints:
1 = n = 103
1 = A[i] = 105


*/
class TripletWithGivenSum
{
    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.

    /*function two check if any "two elements combined" in the array are equal
    to the particular element given as argument.	*/
    public static boolean twoSum(int A[], int x, int i)
    {
        int j=A.length-1;
        while(i<j)
        {
            if(A[i]+A[j] < x)
                i++;
            else if(A[i]+A[j] >x)
                j--;
            else
                return true;
        }
        return false;
    }

    public static boolean find3Numbers(int A[], int n, int X) {

       // Your code Here
       Arrays.sort(A);
       for(int i=0;i<n-2/*As in the end the position of two pointers will be left*/;i++)
            if(twoSum(A,X-A[i],i+1/*as we want to check for a pair out of further elements which should not include A[i]*/))
                return true;

        /* We are taking one element of the array and then checking whether we are checking ,if a pair exists
	along with which the number forms a sum==X*/
        return false;

    }
}
