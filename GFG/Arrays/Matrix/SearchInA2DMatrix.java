/*

Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/
/*
Treat this 2-D matrix as simply a sorted 1-D matrix and hence apply two pointer algorithm
*/
class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int r=matrix.length;
        int c= matrix[0].length;

        int i=0, j=c-1;

        while(i<r && j>=0)
        {
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                j--;
            else
                i++;
        }
        return false;

    }
}