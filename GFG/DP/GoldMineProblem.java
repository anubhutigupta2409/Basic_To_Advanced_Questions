/*
Gold Mine Problem

Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner can start from any row in the first column. From a given cell, the miner can move

to the cell diagonally up towards the right
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination:
The path is {(1,0) -> (2,1) -> (2,2)}.

Example 2:

Input: n = 4, m = 4
M = {{1, 3, 1, 5},
     {2, 2, 4, 1},
     {5, 0, 2, 3},
     {0, 6, 1, 2}};
Output: 16
Explaination:
The path is {(2,0) -> (3,1) -> (2,2)
-> (2,3)} or {(2,0) -> (1,1) -> (1,2)
-> (0,3)}.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxGold() which takes the values n, m and the mine M as input parameters and returns the maximum amount of gold that can be collected.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)


Constraints:
1 = n, m = 50
1 = M[i][j] = 100
*/

class GoldMineProblem{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        //starting from the second last column, and checking every row

        for(int j = m-2;j>=0;j--)
        {
            for(int i=0;i<n;i++)
            {
                //-->
                int right = M[i][j+1];
                // /
                int rightUp = i==0 ? 0 : M[i-1][j+1];//for the first row, right up doesn't exist
                // \
                int rightDown = i==n-1 ? 0 : M[i+1][j+1];//for the last row, right down doesn't exist

                M[i][j] += Math.max(right, Math.max(rightUp,rightDown));
            }
        }

        //now find max from the first column
        int res = M[0][0];

        for(int i=1;i<n;i++)
            res = Math.max(res, M[i][0]);

        return res;
    }
}