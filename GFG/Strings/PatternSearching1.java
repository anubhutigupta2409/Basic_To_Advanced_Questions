/*
Naive algorithm for Pattern Searchin
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
Examples:

Input:  txt[] = "THIS IS A TEST TEXT"
        pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA"
        pat[] =  "AABA"
Output: Pattern found at index 0
        Pattern found at index 9
        Pattern found at index 12



Pattern searching is an important problem in computer science. When we do search for a string in notepad/word file or browser or database, pattern searching algorithms are used to show the search results.



*/
//Naive Approach

// Java program for Naive Pattern Searching
public class PatternSearching1 {

	public static void search(String txt, String pat)
	{
		int N = txt.length();
	      	int M = pat.length();

	      	for(int i=0;i<=N-M;i++)
	        {
	        	int j;
	          	for(j=0;j<M;j++)
	              	if(txt.charAt(i+j)==pat.charAt(j))
	                  	break;

	          	if(j==M)
	              	System.out.println("Pattern found at index "+i);
        }
	}

	public static void main(String[] args)
	{
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		search(txt, pat);
	}
}

