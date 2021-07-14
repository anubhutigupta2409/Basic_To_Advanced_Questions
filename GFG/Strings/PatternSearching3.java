// JAVA program for implementation of KMP pattern
// searching algorithm

//KMP ALGO

class PatternSearching3{
	void KMPSearch(String pat, String txt)
	{
      	int N = txt.length();
      	int M = pat.length();

      	int lps[] = new int[M];
      	lps[0] = 0;
      	computeLPSArray(pat,M,lps);

      	int i=0,j=0;

      	while(i<N)
        {	if(j<M){
          	if(txt.charAt(i)==pat.charAt(j))
            {
              	i++;
              	j++;
            }}
          	else
            {
              	if(j!=0)
                  	j=lps[j-1];
              	else
                  	i++;
            }
          	if(j==pat.length())
            {
         		System.out.println("Fount pattern at index "+(i-pat.length()));
            }
        }
	}

	void computeLPSArray(String pat, int M, int lps[])
	{
		for(int i=1;i<M;i++)
        {
          int j = lps[i-1];
          while(j>0&&pat.charAt(i)!=pat.charAt(j))
            	j = lps[j-1];

          if(pat.charAt(i)==pat.charAt(j))
            	j++;

          lps[i] = j;
        }
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new KMP_String_Matching().KMPSearch(pat, txt);
	}
}

//Time Complexity --> O(N+M)
