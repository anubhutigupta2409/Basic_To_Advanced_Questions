/*
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
 

Your Task:  
You don't need to read input or print anything. Complete the function isPlaindrome() which accepts string S and returns a boolean value


Expected Time Complexity: O(Length of S) 
Expected Auxiliary Space: O(1) 


Constraints:
1 <= Length of S <= 105
*/

class IsPalindrome {
    int isPlaindrome(String S) {
        // code here
        char x[]= S.toCharArray();
        boolean flag=true;
        int left=0;
        int right=x.length-1;
        while(left<right)
        {
            if(x[left++]!=x[right--])
            {
                flag=false;
                break;
            }
        }
        if(flag)
            return 1;
        else
            return 0;
    }
};