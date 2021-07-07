/*
Largest square formed in a matrix
Medium
Given a binary matrix mat of size n * m, find out the maximum size square sub-matrix with all 1s.

Example 1:

Input: n = 2, m = 2
mat = {{1, 1},
       {1, 1}}
Output: 2
Explaination: The maximum size of the square
sub-matrix is 2. The matrix itself is the
maximum sized sub-matrix in this case.
Example 2:

Input: n = 2, m = 2
mat = {{0, 0},
       {0, 0}}
Output: 0
Explaination: There is no 1 in the matrix.
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSquare() which takes n, m and mat as input parameters and returns the size of the maximum square sub-matrix of given matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 = n, m = 50
0 = mat[i][j] = 1


*/

class LargestSquareFormedInAMatrix {
    static int maxSquare(int n, int m, int mat[][]){
        // code here

        //dp array
        int dp[][] = new int[n][m];

        //fill the first row and first column as it is, since size 1 is the minimum sqau
        for(int i = 0; i < n; i++)
            dp[i][0] = mat[i][0];

        for(int j = 0; j < m; j++)
            dp[0][j] = mat[0][j];

        //filling the rest array

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(mat[i][j]==1)
                    dp[i][j]= 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));
                else
                    dp[i][j] = 0;
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int x[] : dp )
            for(int y : x)
                ans = Math.max(y,ans);

        return ans;
    }
}