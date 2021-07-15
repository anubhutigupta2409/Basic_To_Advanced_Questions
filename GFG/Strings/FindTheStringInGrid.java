/*
Search a Word in a 2D Grid of characters
Difficulty Level : Medium
Last Updated : 02 Jul, 2021
Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form).
The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
Example:

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "GEEKS"

Output: pattern found at 0, 0
        pattern found at 0, 8
        pattern found at 1, 0
Explanation: 'GEEKS' can be found as prefix of
1st 2 rows and suffix of first row

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "EEE"

Output: pattern found at 0, 2
        pattern found at 0, 10
        pattern found at 2, 2
        pattern found at 2, 12
Explanation: EEE can be found in first row
twice at index 2 and index 10
and in second row at 2 and 12
*/

// Java program to search
// a word in a 2D grid
import java.io.*;
import java.util.*;

class FindTheStringInGrid{

	// Rows and columns in the given grid
	static int R, C;

	// For searching in all 8 direction
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// This function searches in all
	// 8-direction from point
	// (row, col) in grid[][]
	static boolean isValid(char grid[][], int i, int j)
    {
        int R = grid.length;
        int C = grid[0].length;

        return (i>=0 && i<R && j>=0 && j<C);
    }

    static boolean search(char[][] grid, int i, int j, String word)
    {
        //if first character doesn't match, no need to move forward
        if(grid[i][j]!=word.charAt(0))
            return false;

        int N = word.length();

        //check in all 8 directions
        for(int dir=0;dir<8;dir++)
        {
            //making the origin variables
            int k;

            int ii = i + x[dir];
            int jj = j + y[dir];

            //from 1 as 0th char has been checked
            for(k=1;k<N;k++)
            {
                if(!isValid(grid,ii,jj))
                    break;
                if(grid[ii][jj]!=word.charAt(k))
                    break;

                ii+=x[dir];
                jj+=y[dir];
            }

            if(k==N)
                return true;//all characters are checked
        }
        return false;
    }
	// Searches given word in a given
	// matrix in all 8 directions
	static void patternSearch(
		char[][] grid,
		String word)
	{
		// Consider every point as starting
		// point and search given word

      R= grid.length;
      C= grid[0].length;

      for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(search(grid,i,j,word))
                {
                  System.out.println("{"+i+","+j+"}");
                }
            }
        }

	}

	// Driver code
	public static void main(String args[])
	{

		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
						{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
						{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		patternSearch(grid, "GEEKS");
		System.out.println();
		patternSearch(grid, "EEE");
	}
}

// This code is contributed by rachana soma
