/*
Count all subsequences having product less than K
Difficulty Level : Medium

Given a non negative array, find the number of subsequences having product smaller than K.
Examples: 
 

Input : [1, 2, 3, 4] 
        k = 10
Output :11 
The subsequences are {1}, {2}, {3}, {4}, 
{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, 
{1, 2, 3}, {1, 2, 4}

Input  : [4, 8, 7, 2] 
         k = 50
Output : 9
*/
import java.util.*;
class CountSubsequencesHavingProductLessThanK
{
	// Function to count numbers of such
	// subsequences having product less than k.
	public static int productSubSeqCount(ArrayList<Integer> arr,int k)											
	{
		//dp matrix
      	//base case
      	int n = arr.size();
      	int dp[][] = new int[k+1][n+1];
      
      	for(int i=0;i<=k;i++)
          for(int j=0;j<=n;j++)
            if(i==0 || j==0)
              	dp[i][j] = 0;
      	
      	//filling of the table
      	for(int i=1;i<=k;i++)
        {
          for(int j=1;j<=n;j++)
          {
            dp[i][j] = dp[i][j-1];//not included
            if(arr.get(j-1)<=i)
            {
              
               dp[i][j] += 1 + dp[i/arr.get(j-1)][j-1];//included //  number of subsequences using first j-1 terms + number of subsequences that can be formed using j-th term. 
            	 
            }
          }
        }
      
      return dp[k][n];
	}
	
	// Driver code
	public static void main(String args[])
	{
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		int k = 10;
		System.out.println(productSubSeqCount(A, k));
	}
}
