/*
Problem Statement:
Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each the cell in which they are visited.

Example:

Input :
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
The path followed by Knight to cover all the cells
Following is a chessboard with 8 x 8 cells. Numbers in cells indicate move number of Knight.
*/

/*
following approach prints only one of the possible solutions
*/
import java.util.*;

public class TheKnightTour
{
	public static boolean isSafe(int X, int Y, int sol[][], int N)
	{
		return (X<N && X>=0 && Y<N && Y>=0 && sol[X][Y]==-1/*not visited yet*/ );
	}

	public static void printSolution(int sol[][],int N)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(sol[i][j]+" ");

			System.out.println();
		}
	}

	public static boolean solveKTUtil(int x/*knight's position currently*/, int y, int moveValue, int xMove[], int yMove[],int sol[][], int N)
	{
		int k, nextX,nextY;

		if(moveValue==N*N)
			return true;

		//trying all the tours
		for(k=0;k<8;k++)
		{
			nextX = x + xMove[k];
			nextY = y + yMove[k];

			if(isSafe(nextX , nextY , sol , N))
			{
				sol[nextX][nextY] = moveValue;

				//checking our next move

				if(solveKTUtil(nextX , nextY , moveValue+1 , xMove , yMove , sol, N))
					return true;

				else
					sol[nextX][nextY] = -1;//backtracking
			}
		}
		return false;
	}

	public static boolean solveKT()
	{
		int sol[][]= new int[8][8];//64 cells of chess
		int N=8;

		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				sol[i][j]=-1;//set all the cells as unvisited

		//movement of the x and y coordinates
		/*
		explaining one move-->

		(-2,1) means going two steps left and one step up (making an L(the way a knight moves in the chess))
		*/
		int xMove[]={-2,-2,-1,-1,1,1,2,2};
		int yMove[]={1,-1,-2,2,-2,2,1,-1};

		//placing knight at the first position
		sol[0][0]=0;

		if(!solveKTUtil(0,0,1,xMove,yMove,sol,N))
		{
			System.out.println("Solution doesn't exist");
			return false;
		}
		else
			printSolution(sol,N);

		return true;
	}

	public static void main(String args[])
	{
		solveKT();
	}
}