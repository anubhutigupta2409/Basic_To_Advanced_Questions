
/*
Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary word can be used more than once. Return all such possible sentences.

Follow examples for better understanding.

Example 1:

Input: s = "catsanddog", n = 5
dict = {"cats", "cat", "and", "sand", "dog"}
Output: (cats and dog)(cat sand dog)
Explanation: All the words in the given
sentences are present in the dictionary.
Example 2:

Input: s = "catsandog", n = 5
dict = {"cats", "cat", "and", "sand", "dog"}
Output: Empty
Explanation: There is no possible breaking
of the string s where all the words are present
in dict.
Your Task:
You do not need to read input or print anything. Your task is to complete the function wordBreak() which takes n, dict and s as input parameters and returns a list of possible sentences. If no sentence is possible it returns an empty list.

Expected Time Complexity: O(N2*n) where N = |s|
Expected Auxiliary Space: O(N2)

Constraints:
1 = n = 20
1 = dict[i] = 15
1 = |s| = 500
*/

import java.io.*;
import java.util.*;

public class WordBreakProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		// write your code here
		if(str.length()==0)
		    {
		        System.out.println(ans);
		        return;
		    }
		for(int i=0;i<str.length();i++)
		{

		    String prefix= str.substring(0,i+1);
		    if(dict.contains(prefix))
		    {
		        String leftOut=str.substring(i+1);
		        wordBreak(leftOut,ans+prefix+" ",dict);
		    }
		}
	}

}