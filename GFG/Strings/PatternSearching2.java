//Naive Approach Optimised

public class PatternSearching2 {

	public static void search(String txt, String pat)
	{
			int N = txt.length();
	      	int M = pat.length();

	      	int i=0;

	      	while(i<=N-M)
	        {
	        	int j;
	          	for(j=0;j<M;j++)
	              	if(txt.charAt(i+j)==pat.charAt(j))
	                  	break;

	          	if(j==M)
	          	{
	              	System.out.println("Pattern found at index "+i);
	              	i=i+M;
			 	}
			 	else if(j==0)
			 		i = i+1;
			 	else
			 		i = i+j;
        	}
	}

	public static void main(String[] args)
	{
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		search(txt, pat);
	}
}