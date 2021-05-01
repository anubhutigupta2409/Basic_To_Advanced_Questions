/*

Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating
character, each time a character is inserted to the stream. If there is no such character then append '#' to the answer.


Example 1:

Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'
Example 2:

Input: A = "zz"
Output: "z#"
Explanation: For every character first non
repeating character is as follow-
"z" - first non-repeating character is 'z'
"zz" - no non-repeating character so '#'


Your Task:
You don't need to read or print anything. Your task is to complete the function FirstNonRepeating() which takes A as input
parameter and returns a string after processing the input stream.


Expected Time Complexity: O(26 * n)
Expected Space Complexity: O(26)


Constraints:
1 <= n <= 105
*/

/*
Approach-->

1.Create a count array of size 26(assuming only lower case characters are present) and initialize it with zero.

2.Create a queue of char datatype.


3.Store each character in queue and increase its frequency in the hash array.

4.For every character of stream, we check front of the queue.

5.If the frequency of character at the front of queue is one, then that will be the first non repeating character.

6.Else if frequency is more than 1, then we pop that element.

7.If queue became empty that means there are no non repeating character so we will print #.
*/
class FirstNonRepeatingCharacterInAStream
{
    public String FirstNonRepeating(String str)
    {
        // code here
        int count[] = new int[26];

        Queue<Character> q = new LinkedList<>();

        String res="";

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);

            //push each character into the queue
            q.add(ch);

            //increase the count
            count[ch-'a']++;

            //checkfor first non-repeating character
            while(!q.isEmpty())
            {
                if(count[q.peek()-'a']>1)
                    q.poll();
                else
                {
                    res+=q.peek();
                    break;
                }
            }
            if(q.isEmpty())
                res+="#";
        }

        return res;
    }
}