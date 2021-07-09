class WordBreakDP
{
    
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        int size = A.length();
        
        //dp array
        boolean dp[] = new boolean[size+1];
        dp[0] = true;//as all are false by default
        
        for(int i=1;i<size+1;i++)
        {
            for(int j=i;j>=0;j--)
            {
                dp[i] = dp[j] && B.contains(A.substring(j,i));
                if(dp[i])
                    break;//if makes a word till here
            }
        }
        
        return dp[size] ? 1 : 0;
    }
}