/*
Edit Distance
Medium
Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace


Example 1:

Input:
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required
inserting 's' between two 'e's of str1.
Example 2:

Input :
s = "gfg", t = "gfg"
Output:
0
Explanation: Both strings are same.


Your Task:
You don't need to read or print anything. Your task is to complete the function editDistance() which takes strings s and t as input parameters and returns the minimum number of operation required to make both strings equal.


Expected Time Complexity: O(|s|*|t|)
Expected Space Complexity: O(|s|*|t|)


Constraints:
1 = Length of both strings = 100
Both the strings are in lowercase.


*/
class EditDistance {
    public int editDistance(String s, String t) {
        // Code here

        //longest common subsequence
        int m= s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];//here dp[i][j] represents the minimum no.
        //of operations reqd to convert first i letters of string a , to first j letters
        //of string b

        //base case
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if(i==0)
                    dp[i][j] = j;

                else if(j==0)
                    dp[i][j] = i;

                // If last characters are same, ignore last char
                // and recur for remaining string
                else if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                {
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }

        }
        return dp[m][n];
    }
}