/*
Remove Consecutive Characters

Given a string S delete the characters which are appearing more than once consecutively.

Example 1:

Input:
S = aabb
Output:  ab
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
Similiar explanation for b at
4th position.

Example 2:

Input:
S = aabaa
Output:  aba
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
'a' at fifth position is appearing
2nd time consecutively.


Your Task:
You dont need to read input or print anything. Complete the function removeConsecutiveCharacter() which accepts a string as input parameter and returns modified string.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).


Constraints:
1<=|S|<=105
All characters are lowercase alphabets.

*/
class RemoveConsecutiveCharacter{
    public String removeConsecutiveCharacter(String s){

        int n = s.length();

        String res = "";
        res+=s.charAt(0);
        int index=0;

        for(int i=1;i<n;i++)
        {
            if(res.charAt(index)!=s.charAt(i))
            {
                res+=s.charAt(i);
                index++;
            }
        }

        return res;
    }
}