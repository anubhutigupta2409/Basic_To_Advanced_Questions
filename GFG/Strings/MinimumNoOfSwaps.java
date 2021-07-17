/*
Minimum Swaps for Bracket Balancing

You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.
Note - Strings S1 and S2 can be empty.



Example 1:

Input  : []][][
Output : 2
Explanation :
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]



Example 2:

Input : [[][]]
Output : 0
Explanation:
String is already balanced.


Your Task:

You don't need to read input or print anything. Your task is to complete the function minimumNumberOfSwaps() which takes the
string S and return minimum number of operations required to balance the bracket sequence.



Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).



Constraints:

1<=|S|<=100000
*/
/*
Explanation By GFG-->



Naive Approach
Initialize sum = 0 where sum stores result. Go through the string maintaining a count of the number of ‘[‘ brackets encountered.
Reduce this count when we encounter a ‘]’ character. If the count hits negative, then we must start balancing the string.
Let index ‘i’ represent the position we are at. We now move forward to the next ‘[‘ at index j. Increase sum by j – i. Move the
‘[‘ at position j, to position i, and shift all other characters to the right. Set the count back to 0 and continue traversing
the string. In the end, ‘sum’ will have the required value.

Time Complexity = O(N^2)
Extra Space = O(1)

Optimized approach
We can initially go through the string and store the positions of ‘[‘ in a vector say ‘pos‘. Initialize ‘p’ to 0. We shall use p
to traverse the vector ‘pos’. Similar to the naive approach, we maintain a count of encountered ‘[‘ brackets. When we encounter
a ‘[‘ we increase the count and increase ‘p’ by 1. When we encounter a ‘]’ we decrease the count. If the count ever goes negative
, this means we must start swapping. The element pos[p] tells us the index of the next ‘[‘. We increase the sum by pos[p] – i,
where i is the current index. We can swap the elements in the current index and pos[p] and reset the count to 0 and increment p
so that it pos[p] indicates to the next ‘[‘.
Since we have converted a step that was O(N) in the naive approach, to an O(1) step, our new time complexity reduces.

Time Complexity = O(N)
Extra Space = O(N)

Our Approach
Time Complexity = O(N)
Extra Space = O(1)
We can do without having to store the positions of ‘[‘.
*/
class MinimumNoOfSwaps{
    static int minimumNumberOfSwaps(String S){
        // code here

        int countLeft = 0, countRight=0;//bracket count

        int swap=0;//swaps required
        int imbalance = 0;//imbalanced pairs

        //traversing
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='[')
            {
                countLeft++;

                if(imbalance>0)
                {
                    swap+=imbalance;//adding imbalanced pairs

                    imbalance--;//only one imbalance solved
                }
            }
            else if(S.charAt(i)==']')
            {
                countRight++;
                //reset imbalance
                imbalance = countRight - countLeft;
            }
        }

        return swap;
    }
}