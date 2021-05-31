/*
Row with max 1s
Medium
Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the
maximum number of 1's.

Example 1:

Input:
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input:
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).

Your Task:
You don't need to read input or print anything. Your task is to complete the function rowWithMax1s() which takes the array of
booleans arr[][], n and m as input parameters and returns the 0-based index of the first row that has the most number of 1s.
If no such row exists, return -1.


Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)


Constraints:
1 = N, M = 103
0 = Arr[i][j] = 1


*/
/*
Approach-->
Since the rows are sorted then to find the maximum number of 1s in a row, all we need to find is the index of the first 1 occured,
and the number of 1s in that particular row will be c-(that index). To do so we will be applying binary search over here.
*/
class RowWithMaxNoOf1s {

    //function that returns the index of the first 1 in a row
    int Index(int row[], int low, int high)
    {
        while(low<=high)
        {
            int mid= low + (high-low)/2 ;

            //if this is the first 1, how do we ensure that this is the first
            //one, 1.if it's the very first element of the row, that is index
            //position==0, 2.the element before it was a zero

            if((mid==0 || row[mid-1]==0) && row[mid]==1)
                return mid;

            else if(row[mid]==0)
                low=mid+1;//move right as we are yet to find a 1

            else
                high=mid-1;//move left as we are yet to find the first 1
        }
        return -1;//if the row is full of zeroes

    }
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here

        int index;//of first 1
        int max=Integer.MIN_VALUE;//max no. of 1's
        int maxIndex=-1;//answer

        for(int i=0;i<n;i++)
        {
            index=Index(arr[i],0,m-1);

            if(index!=-1 && max<m-index)
            {
                max=m-index;
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}