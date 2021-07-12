/*
Longest Palindrome in a String
Medium
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 = i = j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
Example 2:

Input:
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the
longest palindromes with same length.
The result is the one with the least
starting index.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.


Expected Time Complexity: O(|S|2).
Expected Auxiliary Space: O(1).


Constraints:
1 = |S| = 103


*/
/*
The DP approach, utilises O(n^2) space, here we do this in constant space
*/
class LongestPalindromeInAString{
    static String longestPalin(String s){
        // code here
        int n = s.length();
        int maxLen = 1, start=0, low,high;

        for(int i=1;i<n;i++)
        {
            //generating even length palindromes
            low = i-1;
            high = i;

            while(low>=0 && high<n && s.charAt(low)==s.charAt(high))
            {
                if(maxLen < high-low+1)
                {
                    start = low;
                    maxLen = high-low+1;
                }
                low--;
                high++;
            }

            //generating odd length palindromes
            low = i-1;
            high = i+1;

            while(low>=0 && high<n && s.charAt(low)==s.charAt(high))
            {
                if(maxLen < high-low+1)
                {
                    start = low;
                    maxLen = high-low+1;
                }
                low--;
                high++;
            }

        }

        return s.substring(start,start+maxLen);//as end index is not included
    }
}