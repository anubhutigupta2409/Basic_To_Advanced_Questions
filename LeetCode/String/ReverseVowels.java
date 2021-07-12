/*
Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.



Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"


Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

class ReverseVowels {
    public String reverseVowels(String s) {

        //making a string containing vowels
        String vowels = "aeiouAEIOU";

        char arr[] = s.toCharArray();

        int left = 0, right = arr.length-1;

        while(left<right)
        {
            //bring the left to required place
            while(left<right && !vowels.contains(arr[left]+""))
                left++;

            //bring the right to required place
            while(left<right && !vowels.contains(arr[right]+""))
                right--;

            //now swap
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}