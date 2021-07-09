/*
Word Break
Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words.


Example 1:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilike"
Output: 1
Explanation:The string can be segmented as "i like".

​Example 2:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilikesamsung"
Output: 1
Explanation: The string can be segmented as
"i like samsung" or "i like sam sung".


Your Task:
Complete wordBreak() function which takes a string and list of strings as a parameter and returns 1 if it is possible to break words, else return 0. You don't need to read any input or print any output, it is done by driver code.


Expected time complexity: O(s2)
​Expected auxiliary space: O(s) , where s = length of string A



Constraints:
1 <= N <= 12
1 <= s <=1000 , where s = length of string A
 The length of each word is less than 15.


*/

class WordBreakRecursive
{
    public static boolean solve(String s, ArrayList<String> list)
    {

        int size = s.length();

        //base condition
        if(size==0)
            return true;

        for(int i=1;i<=size;i++)
        {
            if (list.contains(s.substring(0,i)) && solve(s.substring(i,size),list))
                return true;
        }

        return false;

    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        if(solve(A,B))
            return 1;

        else
            return 0;
    }
}