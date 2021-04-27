/*

Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3
with 5, 4 with 5 and finally 3 with 4

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 = |str| = 30
1 = K = 10


*/
/*
Approach-->

1. make a helper function that takes a char array , k number of swaps and the current index as input
2. check if swaps ==0 then return
3. make a static variable string max whoch represents the final answer
4. make the element at the current index as maximum, now compare it with every other element (ranging from the current index
to the end of the array)
5. if the max element is not the element at the current index ,decrease the number of swaps
6. find this max element and swap and update the value of the maximum string
7. call the function recursively for --k no. of swaps and ++index current index till the time (index+1)<n
8. now backtrack the swap
*/

class FindMaximumNumInKSwaps
{
    static String max;
    public static void findMaximumNumUtil(char x[], int k, int index)
    {
        if(k==0)
            return ;

        int n = x.length;

        char maxEle = x[index];

        for(int i=index+1;i<n;i++)
        {
            if(maxEle < x[i])
                maxEle = x[i];
        }

        //now if our maximum element is not the current element, means swap is
        //required

        if(maxEle != x[index])
            --k;

        //finding this maxEle and swapping
        for(int i=index;i<n;i++)
        {
            if(x[i] == maxEle)
            {
                //swap
                char temp = x[i];
                x[i] = x[index];
                x[index] = temp;

                //update
                if(String.valueOf(x).compareTo(max) > 0)
                    max = String.valueOf(x);

                //recurse
                if(index+1 < n)
                    findMaximumNumUtil(x,k,index+1);

                //backtrack
                char c = x[i];
                x[i] = x[index];
                x[index] = c;
            }
        }
    }
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            if(k==0)
                return str;

            max=str;
            findMaximumNumUtil(str.toCharArray(), k , 0);
            return max;

        }
}