/*

Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1},
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at
(3, 3) from (0, 0) by two paths - DRDDRR
and DDRDRR, when printed in sorted order
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is
blocked.
Your Task:
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order.
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((N2)4).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 = N = 5
0 = m[i][j] = 1
*/

class RatMaze {
    public static ArrayList<String> arr = new ArrayList<>();
    public static String s="";

    public static boolean isValid(int[][] m, int i, int j,boolean vis[][])
    {
        int rows = m.length;
        int cols=rows;

        return (i>=0 && i<rows && j>=0 && j<cols && !vis[i][j] && m[i][j]==1);
    }
    public static void findPath(int[][]m,int row,int col,int n,boolean vis[][])
    {

        if(!isValid(m,row,col,vis))
            return;




        if(row==n-1 && col==n-1)
        {
            if(!arr.contains(s))
            {
            arr.add(s);
            return;
            }
        }

        vis[row][col] = true;

        //lexicographical order= D->L->R->U

        if(isValid(m,row+1,col,vis))
        {
            s+="D";
            findPath(m,row+1,col,n,vis);
            s=s.substring(0,s.length()-1);//strings are immutable
        }
        if(isValid(m,row,col-1,vis))
        {
            s+="L";
            findPath(m,row,col-1,n,vis);
            s=s.substring(0,s.length()-1);//strings are immutable
        }
        if(isValid(m,row,col+1,vis))
        {
            s+="R";
            findPath(m,row,col+1,n,vis);
            s=s.substring(0,s.length()-1);//strings are immutable
        }
        if(isValid(m,row-1,col,vis))
        {
            s+="U";
            findPath(m,row-1,col,n,vis);
            s=s.substring(0,s.length()-1);//strings are immutable
        }

        //backtracking
        vis[row][col] = false;



    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here

        boolean vis[][] = new boolean[n][n];
        findPath(m,0,0,n,vis);

        return arr;




    }
}