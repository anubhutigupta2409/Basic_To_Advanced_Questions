/*

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/

class Pair
{
    int i,j;

    public Pair(int i, int j)
    {
        this.i=i;
        this.j=j;
    }
}
class DistanceOfNearestCellHaving0 {

    public boolean isValid(int i, int j, int[][] mat, int R,int C)
    {
        return (i>=0 && i<R && j>=0 && j<C);
    }
    public int[][] updateMatrix(int[][] mat) {
        int R= mat.length;
        int C=mat[0].length;

        int[][] ans = new int[R][C];

        for(int[] row :  ans)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j));
                    ans[i][j] = 0;
                }
            }
        }

        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};

        while(!q.isEmpty())
        {
            Pair pair = q.poll();

            for(int i=0;i<4;i++)
            {
                int dx = pair.i + x[i];
                int dy = pair.j + y[i];

                if(isValid(dx,dy,mat,R,C))
                {
                    if(ans[dx][dy] > ans[pair.i][pair.j] + 1)
                    {
                        ans[dx][dy] = ans[pair.i][pair.j] + 1;
                        q.add(new Pair(dx,dy));
                    }
                }
            }
        }

        return ans;
    }
}