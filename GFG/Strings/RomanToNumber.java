/*
Roman Number to Integer

Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5
Example 2:

Input:
s = III
Output: 3
Your Task:
Complete the function romanToDecimal() which takes an string as input parameter and returns the equivalent decimal number.

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999
*/

class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here

        //mapping
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int prev=0,curr=0;
        int sum=0;

        int n= str.length();

        for(int i=0;i<n;i++)
        {
            if(i>0 && map.get(str.charAt(i)) > map.get(str.charAt(i-1)))
                sum -= 2*map.get(str.charAt(i-1));//twice as added by mistake, and then should be subtracted

            sum += map.get(str.charAt(i));
        }

        return sum;
    }
}