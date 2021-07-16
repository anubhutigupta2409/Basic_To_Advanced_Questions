/*
Second most repeated string in a sequence

Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most
occurring string with frequency 2.

​Example 2:

Input:
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function secFrequent() which takes the string array arr[] and its size N as inputs and returns the second most frequent string in the array.


Expected Time Complexity: O(N*max(|Si|).
Expected Auxiliary Space: O(N*max(|Si|).


Constraints:
1<=N<=103


*/

class SecondMostRepeatedStringInTheSequence
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        for(int i=0;i<N;i++)
        {
            if(!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else
                map.put(arr[i],map.get(arr[i])+1);
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        String ans="";

        for(String x : map.keySet())
        {
            int c = map.get(x);

            if(c>max1)
            {
                max2 = max1;
                max1 = c;
            }

            else if(c>max2 && c<max1)
                max2 = c;

        }

        for(String x : map.keySet())
        {
            if(max2==map.get(x))
                return x;
        }

        return null;
    }
}