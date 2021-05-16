/*

Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

*/
/*
Approach-->

10 20 30 40 <- start from here i=0, j=m-1
15 25 35 45    now if arr[i][j]== target return else if it's greater move left(j--) else move down(i++)
27 29 37 48
32 33 39 50

now if the value doesn't exist we go out of bounds, that is we reach left that is j<0 or we reach down i>=n
*/
class SearchInRowAndColumnWiseSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {


        int r= matrix.length;
        int c=matrix[0].length;

        int i=0, j=c-1;

        while(i<r && j>=0)
        {
            if(matrix[i][j]==target)
                return true;

            else if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
        }

        return false;

    }
}