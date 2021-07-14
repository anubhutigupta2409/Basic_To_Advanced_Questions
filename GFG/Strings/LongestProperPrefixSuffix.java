/*
Longest Prefix Suffix
Medium
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper
prefix and suffix.
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper
prefix and suffix.
Your task:
You do not need to read any input or print anything. The task is to complete the function lps(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(|s|)

Constraints:
1 = |s| = 105
s contains lower case English alphabets
*/

class LongestProperPrefixSuffix{
    int lps(String s) {
        // code here

        int n = s.length();
        //prefix array
        int pre[] = new int[n];

        //pefix[0] = 0 <-- by definition
        pre[0] = 0;

        //start the loop from 1
        for(int i=1;i<n;i++)
        {
            //take the longest proper prefix suffix till the previous character
            int j;
            j = pre[i-1];

            //make it equal
            while(j>0 && s.charAt(i)!=s.charAt(j))
                j=pre[j-1];

            //if equal for the next character as well, then just add
            if(s.charAt(i)==s.charAt(j))
                j++;

            pre[i] = j;
        }

        //now we have to return maximum

        return pre[n-1];
    }
}

/*
The Time complexity for this is O(n) and not O(n^2) <-- as you might think that there is a while loop also, inside our for loop.

So, the iterations till which i has gone by increasing, we can decrease j by that much iterations onli, therefore, O(n)
*/