/*

Yout Task:
You don't need to read or print anything, Your task is to complete the function nearest() which takes grid as input parameter
and returns a matrix of same dimensions where the value at index (i, j) in the resultant matrix signifies the minimum distance
of 1 in the matrix from grid[i][j].


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(1)


Constraints:
1 = n, m = 500
*/

class Pair
{
    int i, j;

    public Pair(int i, int j)
    {
        this.i=i;
        this.j=j;
    }
}
class DistanceOfNearestCellHaving1
{
    public boolean isValid(int[][] grid, int R, int C, int i, int j)
    {
        return (i>=0 && i<R && j>=0 && j<C);
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int R= grid.length;
        int C = grid[0].length;

        int[][] ans = new int[R][C];

        for(int[] row : ans)
            Arrays.fill(row,Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new Pair(i,j));
                    ans[i][j] = 0;
                }
            }
        }

        //now to check the nearest 1's we need to move left, right, top,
        //and bottom

        //therefore creating diraction arrays

        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};

        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            for(int i=0;i<4;i++)
            {
                int dx = pair.i + x[i];
                int dy = pair.j + y[i];

                if(isValid(grid,R,C,dx,dy))
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