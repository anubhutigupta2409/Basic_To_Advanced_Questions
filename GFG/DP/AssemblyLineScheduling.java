/*
Assembly Line Scheduling

A car factory has two assembly lines, each with n stations. A station is denoted by Si,j where i is either 1 or 2 and indicates the assembly line the station is on, and j indicates the number of the station. The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work like engine fitting, body fitting, painting, and so on. So, a car chassis must pass through each of the n stations in order before exiting the factory. The parallel stations of the two assembly lines perform the same task. After it passes through station Si,j, it will continue to station Si,j+1 unless it decides to transfer to the other line. Continuing on the same line incurs no extra cost, but transferring from line i at station j – 1 to station j on the other line takes time ti,j. Each assembly line takes an entry time ei and exit time xi which may be different for the two lines. Give an algorithm for computing the minimum time it will take to build a car chassis.

The below figure presents the problem in a clear picture:




The following information can be extracted from the problem statement to make it simpler:

Two assembly lines, 1 and 2, each with stations from 1 to n.
A car chassis must pass through all stations from 1 to n in order(in any of the two assembly lines). i.e. it cannot jump from station i to station j if they are not at one move distance.
The car chassis can move one station forward in the same line, or one station diagonally in the other line. It incurs an extra cost ti, j to move to station j from line i. No cost is incurred for movement in same line.
The time taken in station j on line i is ai, j.
Si, j represents a station j on line i.
*/

import java.io.*;

class AssemblyLineScheduling
{
	static int NUM_LINE = 2;
	static int NUM_STATION = 4;

	// Utility function to find minimum of two numbers
	static int min(int a, int b)
	{
		return a < b ? a : b;

	}

	static int carAssembly(int a[][], int t[][], int e[], int x[])
	{

		//dp arrays
      	int n = a[0].length;
      	int t1[] = new int[n];
      	int t2[] = new int[n];

      	//adding entry times
      	t1[0] = a[0][0] + e[0];
      	t2[0] = a[1][0] + e[1];

      	//filling the dp arrays, where each cell
      	//denotes the minimum time to reach that station
      	//from all possible paths
      	for(int i=1;i<n;++i)
        {
			int straight = t1[i-1] + a[0][i];
          	int diagonal = t2[i-1] + t[1][i] + a[0][i];
          	t1[i] = Math.min(straight, diagonal);

          	straight = t2[i-1] + a[1][i];
          	diagonal = t1[i-1] + t[0][i] + a[1][i];
          	t2[i] = Math.min(straight, diagonal);
        }

      	//adding exit times
      	return Math.min(t1[n-1]+x[0] , t2[n-1]+x[1]);

	}


	// Driver code
	public static void main (String[] args)
	{
		int a[][] = {{4, 5, 3, 2},
					{2, 10, 1, 4}};
		int t[][] = {{0, 7, 4, 5},
					{0, 9, 2, 8}};
		int e[] = {10, 12}, x[] = {18, 7};

		System.out.println(carAssembly(a, t, e, x));

	}
}