/*
Min Number of Flips

Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.

Example 1:

Input:
S = "001"
Output: 1
Explanation: We can flip the 0th bit to 1
to have "101".
​Example 2:

Input:
S = "0001010111"
Output: 2
Explanation: We can flip the 1st and 8th bit
to have "0101010101".

Your Task:
You don't need to read input or print anything. Your task is to complete the function minFlips() which takes the string S as input and returns the minimum number of flips required.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105


*/

class MinNoOfFlips{

    //we need to flip the expected character each time
    char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }

    public int minFlips(String str) {
        // Code here

        int one = 0;
        int zero = 0;

        char expected = '0';

        for (int i = 0; i < str.length(); i++)
        {
            //  if current character is not expected,
            // increase flip count
            if (str.charAt(i) != expected)
                zero++;

            //  flip expected character each time
            expected = flip(expected);
        }

        expected = '1';

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != expected)
                one++;

            expected = flip(expected);
        }

        return Math.min(zero,one);
    }
}