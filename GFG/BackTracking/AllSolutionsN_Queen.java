/*
Printing all solutions in N-Queen Problem
Difficulty Level : Hard

The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.


we have discussed an approach that prints only one possible solution, so now in this post, the task is to print all solutions
in N-Queen Problem. Each solution contains distinct board configurations of the N-queens’ placement, where the solutions are a
permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed
in the row with that number. For the example above solution is written as [[2 4 1 3 ] [3 1 4 2 ]].


*/
import java.util.*;


public class AllSolutionsN_Queen
{
	static List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static boolean isSafe(int board[][], int row, int col)
	{
		int n=board.length;

		int i,j;

		//left side
		for(i=0;i<col;i++)
			if(board[row][i]==1)
				return false;

		//left-side upper diagonal
		for(i=row,j=col; i>=0 && j>=0 ; i--,j--)
			if(board[i][j]==1)
				return false;

		//left-side lower diagonal
		for(i=row,j=col ; i<n && j>=0; i++,j--)
			if(board[i][j]==1)
				return false;

		return true;
	}

	public static boolean NQueen(int board[][] , int col)
	{

		int n= board.length;

		if(col==n)
		{
			List<Integer> x = new ArrayList<Integer>();

			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(board[i][j]==1)
						x.add(j+1);
				}
			}

			res.add(x);
			return true;
		}

		boolean flag = false;

		for(int i=0;i<n;i++)
		{
			if(isSafe(board,i,col))
			{
				board[i][col]=1;

				flag = NQueen(board,col+1) || flag;

				board[i][col]=0;

			}

		}

		return flag;

	}

	public static List<List<Integer>> solveNQueen(int n)
	{
		res.clear();

		int board[][] = new int[n][n];

		NQueen(board,0);

		return res;
	}

	public static void main(String args[])
	{
		int n=5;
		List<List<Integer>> result = solveNQueen( n);
		System.out.println(result);
	}
}