/*
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.


Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0},
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity.

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Your Task:
You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 3000
0 <= M[][] <= 1
*/


/*
Approach-->

1.we use two pointer algorithm, we take one element from the very starting and the other from the very ending
2.we check if a knows b then it's  not the celebrity therefore, a++, otherwise b-- (we check this till a<b)
3.at the end of the lopp we are left with one index that is a, now we check if a is acelebrity or not
4. we run a loop from 0 till n, if any index i doesn't know a, or a knows i then a is not the celebrity so we return -1
5.else we return a
*/
class CelebrityProblem
{
    //Function to find if there is a celebrity in the party or not.
    boolean knows(int M[][],int a, int b)
    {
        return (M[a][b] == 1) ;
    }
    int celebrity(int M[][], int n)
    {
    	// code here
    	int a = 0;
    	int b= n-1;

    	while(a<b)
    	{
    	    //a not celebrity
    	    if(knows(M,a,b))
    	        a++;

    	     else
    	        b--;//b not celebrity
    	}

    	//if a is the index we are left with
    	//checking whether a  is a celebrity or not
    	//if any person doesn't know a or a knows anybody then a is not the
    	//celebrity and we return -1 , else return a's id
    	for(int i=0;i<n;i++)
    	{
    	    if(i != a && (!knows(M,i,a) || knows(M,a,i)))
    	        return -1;
    	}

    	return a;

    }
}