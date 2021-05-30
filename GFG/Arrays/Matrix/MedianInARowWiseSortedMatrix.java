/*

Median in a row-wise sorted Matrix
Medium
Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5],
     [2, 6, 9],
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median.


Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C
along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000
*/

class MedianInARowWiseSortedMatrix{
    int count (int row[], int mid)
    {
        int low=0, high=row.length-1;

        while(low<=high)
        {
            int middle= low + (high-low)/2;

            if(row[middle]<=mid)
                low=middle+1;

            else
                high=middle-1;
        }

        return low;
    }
    int median(int matrix[][], int r, int c) {
        // code here
        //finding the range for our search space

        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        //since the matrix is row wise sorted we will find minimum in the starting
        //of the row, and maximum at the end

        for(int i=0;i<r;i++)
        {
            max=Math.max(max,matrix[i][0]);
            min=Math.min(min,matrix[i][c-1]);
        }

        //low=min
        //high=max

        while(min<=max)
        {
            //mid
            int mid = max + (max-min)/2;

            //finding count of numbers less than or equal to our mid
            int cnt=0;

            for(int i=0;i<r;i++)
                cnt+=count(matrix[i] , mid);//searching in every row

            //as our median will have exactly (N*M)/2 elements on its left and
            //right
            if(cnt<= (r*c+1)/2)
                max=mid+1;//here = condition is also included so returns low

            else
                max=mid-1;
        }
        return min;
    }
}