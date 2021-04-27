/*
Print all possible paths from top left to bottom right of a mXn matrix
Difficulty Level : Medium

The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each
cell you can either move only to right or down.

Examples :

Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2
        3 4
Output : 1 2 4
         1 3 4
*/

/*
Approach-->

The algorithm is a simple recursive algorithm, from each cell first print all paths by going down and then print all paths by
going right. Do this recursively for each cell encountered.
*/

public class PrintAllPathsInAMatrix
{
	public static void printAllPossiblePaths(int mat[][], int m, int n, int i , int j, int path[], int index)
	{
		path[index] = mat[i][j];

		//if we reached the bottom then only option is to move right
		if(i == m-1)
		{
			for(int k=j+1 ; k<n ; k++)
			{
				path[index + k - j]= mat[i][k];
			}

			for(int x=0 ; x< index + n - j ;x++)
			{
				System.out.print(path[x]+" ");
			}
			System.out.println();
			return;
		}

		//recahed the right most corner then only option is to move down
		if(j == n-1)
		{
			for(int k = i+1;k<m;k++)
			{
				path[index + k - i] = mat[k][j];
			}
			for(int x=0;x<index + m - i;x++)
			{
				System.out.print(path[x]+" ");
			}
			System.out.println();
			return;
		}
		//all other possible paths after moving down
		printAllPossiblePaths(mat,m,n,i+1,j,path,index+1);

		//all other possible paths after moving right
		printAllPossiblePaths(mat,m,n,i,j+1,path,index+1);
	}

	public static void main(String args[])
	{
     	int m = 2;
        int n = 3;
        int mat[][] = { { 1, 2, 3 },
                        { 4, 5, 6 } };
        int maxLengthOfPath = m + n - 1;
        printAllPossiblePaths(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
	}
}