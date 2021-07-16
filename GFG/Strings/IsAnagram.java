/*
Anagram 

Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, “act” and “tac” are an anagram of each other.

Example 1:

Input:
a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same
characters with same frequency. So, 
both are anagrams.
Example 2:

Input:
a = allergy, b = allergic
Output: NO
Explanation:Characters in both the strings
are not same, so they are not anagrams.
Your Task:
You don't need to read input or print anything.Your task is to complete the function isAnagram() which takes the string a and string b as input parameter and check if the two strings are an anagram of each other. The function returns true if the strings are anagram else it returns false.

Expected Time Complexity: O(|a|+|b|).
Expected Auxiliary Space: O(Number of distinct characters).

Note: |s| represents the length of string s.

Constraints:
1 = |a|,|b| = 105
*/

class IsAnagram
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        a=a.toLowerCase();//converting them to lower case
		b=b.toLowerCase();//we have used "=" symbol since strings are immutable
		boolean isAnagram = true;//using a boolean variable
		//the least check they should pass, is having same no. of letters
		if(a.length() != b.length())
			isAnagram= false;
		else
		{
		int al[] = new int[256];//since there are only 256 characters possible
		for(char c : a.toCharArray()){
			int index=(int) c;
			al[index]++;//increasing the position if a certain character was present in string 1
			}
		for(char c : b.toCharArray()){
					int index=(int) c;
					al[index]--;//decreasing the position if a certain character was present in string 2
			}
		//since we have done increasing and decreasing respectively, the array al must have all zeroes
		//if the two input strings were anagrams
		for(int i=0;i<256;i++)
			{if(al[i]!=0)
				{isAnagram = false;
					break;
					}
				}
		}
		
		return isAnagram;
        
    }
}