/*Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.
Examples :


Input: [6, 8, 4, 5, 2, 3]
Output: 604
The minimum sum is formed by numbers
358 and 246

Input: [5, 3, 0, 7, 4]
Output: 82
The minimum sum is formed by numbers
35 and 047
*/

/*
Approach-->
1.the least number can be formed if the most significant digit is as least as possible
2.sort the array and make digits out of alternate digits
3.return the sum
*/

class MinSumTwoNumbersFormedByDigitsOfTheElements{
    String solve(int[] arr, int n) {
        // code here

        Arrays.sort(arr);

        int a=0,b=0;

        for(int i=0;i<n;i++)
        {
            if((i&1) == 0)
                a = a*10 + arr[i];
            else
                b = b*10 + arr[i];
        }

        int res = a+b;
        return String.valueOf(res);
    }
}