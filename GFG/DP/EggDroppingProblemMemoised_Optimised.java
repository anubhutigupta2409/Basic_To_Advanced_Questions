class EggDroppingProblemMemoised_Optimised
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int e, int f, int dp[][]) 
	{
	    // Your code here
	    //base case
	    /*
	    if just one or zero floors then in worst case we would take f attempts.
	    
	    if just one egg given, we will play safely and start from the 1st floor, and then 
	    will slowly go up, and in worst case, fth floor would be the threshold floor
	    */
	    
	    if(e==1 || f==0 || f==1)
	        return f;
	        
	    if(dp[e][f]!=-1)
	        return dp[e][f];
	        
	    //check from the 1st floor till fth
	    int ans = Integer.MAX_VALUE;
	    int breaks, doesNot;
	    
	    for(int k=1;k<=f;k++)
	    {
	        //temp answer
	        if(dp[e-1][k-1]!=-1)
	            breaks= dp[e-1][k-1];
	        else
	            breaks= eggDrop(e-1,k-1,dp);
	        
	        if(dp[e][f-k]!=-1)
	            doesNot= dp[e][f-k];
	        else
	            doesNot= eggDrop(e,f-k,dp);
	        
	        int temp=1+Math.max(breaks, doesNot);//max, since we have to consider the worst case
	        
	        ans = Math.min(ans,temp);
	    }
	    return dp[e][f] = ans;
	}
	static int eggDrop(int e, int f)
	{
	    int dp[][] = new int[e+1][f+1];
	    
	    for(int row[] : dp)
	        Arrays.fill(row,-1);
	        
	    return eggDrop(e,f,dp);
	}
}