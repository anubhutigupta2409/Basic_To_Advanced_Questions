/*
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 = N = 10000


*/

/*
Approach-->
Following are few observations about the next greater number. 
1) If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321. 
2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234. 
3) For other cases, we need to process the number from rightmost side (why? because we need to find the smallest of all greater numbers)

You can now try developing an algorithm yourself. 
Following is the algorithm for finding the next greater number. 
I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.

II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976", the right side of 4 contains “976”. The smallest digit greater than 4 is 6.




III) Swap the above found two digits, we get 536974 in above example.

IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
*/
class NextPermutation{
    static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        
        List<Integer> ans = new ArrayList<Integer> (arr.length);
        
        int i;
        //step-1 find the first digit from the right that is 
        //smaller to the digit next to it
        
        for(i=n-1 ; i>0 ; i--)
        {
            if(arr[i] > arr[i-1])
                break;
        }
        
        //if no such digit is found return empty list
        if(i==0)
            return ans;
            
        //step-2 find the smallest digit on the right side of the (i-1)th digit
        //which is greater than it
        
        int min=i, minEle = arr[i-1];
        
        for(int j=i+1; j<n ;j++)
        {
            if(arr[j]>minEle && arr[j]<arr[min])
                min =j;
        }
        
        //step-3 swap
        swap(arr,i-1,min);
        
        //step-4 sort the subarray next to the (i-1)th digit
        Arrays.sort(arr, i, n);
        
        for(int j : arr)
            ans.add(j);
            
        return ans;
    }
}