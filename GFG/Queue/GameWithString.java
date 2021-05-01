/*

Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of
‘k’ characters. The value of a string is defined as the sum of squares of the count of each distinct character.


Example 1:

Input: s = abccc, k = 1
Output: 6
Explaination:
We remove c to get the value as 12 + 12 + 22


Example 2:

Input: s = aabcbcbcabcc, k = 3
Output: 27
Explaination: We remove two 'c' and one 'b'.
Now we get the value as 32 + 32 + 32.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minValue() which takes s and k as input
parameters and returns the minimum possible required value.



Expected Time Complexity: O(N*logN)  where N is the length of string
Expected Auxiliary Space: O(N)



Constraints:
1 = k = |string length| = 100
*/

/*
Approach-->
One clear observation is that we need to remove character with highest frequency. One trick is the character ma
A Simple solution is to use sorting technique through all current highest frequency reduce up to k times. For After every reduce
again sort frequency array.
A Better Solution used to Priority Queue which has to the highest element on top.


Initialize empty priority queue.
Count frequency of each character and Store into temp array.
Remove K characters which have highest frequency from queue.
Finally Count Sum of square of each element and return it.
*/

class GameWithString{
    static int minValue(String s, int k){
        // code here
        int n = s.length();

        if(k>=n)
            return 0;

        //26 for 26 characters
        int count[] = new int[26];

        //keeping 0 index for small a
        for(int i=0;i<n;i++)
            count[s.charAt(i) - 'a']++;

        //will store elements in descending order, means top of the queue will
        //be the highest element
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //add all counts,except the 0 one's since such characters are not
        //part of our queue
        for(int i=0;i<26;i++)
            if(count[i]!=0)
                pq.add(count[i]);

        //remove k elements with highest count
        for(;k>0;k--)
        {
            pq.add(pq.poll()-1);//remove the element, decremenet it's count
            //and again add in the queue
        }

        int res=0;

        while(!pq.isEmpty())
            res+= pq.peek() * pq.poll();//update the result as the sum of squares
            //of counts of the elements

        return res;
    }
}