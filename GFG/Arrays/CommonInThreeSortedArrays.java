/*
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.


Your Task:
You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order.
If there are no such elements return an empty array. In this case the output will be printed as -1.



Expected Time Complexity: O(n1 + n2 + n3)
Expected Auxiliary Space: O(n1 + n2 + n3)



Constraints:
1 <= n1, n2, n3 <= 10^5
The array elements can be both positive or negative integers.


*/
/*
//Doesn't work if an array itself has duplicates, therefore, the next approach-->
class Solution
{
    ArrayList<Integer> commonElements(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3)
    {
        // code here
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        // Iterate through three arrays while all arrays have elements
        while (i < ar1.length && j < ar2.length && k < ar3.length)
        {
             // If x = y and y = z, print any of them and move ahead
             // in all arrays
             if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
             {   res.add(ar1[i]);   i++; j++; k++; }

             // x < y
             else if (ar1[i] < ar2[j])
                 i++;

             // y < z
             else if (ar2[j] < ar3[k])
                 j++;

             // We reach here when x > y and z < y, i.e., z is smallest
             else
                 k++;
        }
        return res;
    }
}
*/
class CommonInThreeSortedArrays
{
    ArrayList<Integer> commonElements(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3)
    {
        // code here
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        int prev1=Integer.MIN_VALUE;
        int prev2=Integer.MIN_VALUE;
        int prev3=Integer.MIN_VALUE;

        // Iterate through three arrays while all arrays have elements
        while (i < n1 && j < n2 && k < n3) {

        // If ar1[i] = prev1 and i < n1,
        // keep incrementing i
        while (i<n1 && ar1[i] == prev1)
            i++;

        // If ar2[j] = prev2 and j < n2,
        // keep incrementing j
        while ( j < n2 && ar2[j] == prev2)
            j++;

        // If ar3[k] = prev3 and k < n3,
        // keep incrementing k
        while (k < n3 && ar3[k] == prev3)
            k++;

        // If x = y and y = z, print
        // any of them, update
        // prev1 prev2, prev3 and move
        //ahead in each array
        if(i<n1 && j<n2 && k<n3){
        if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
            res.add(ar1[i]);
            prev1 = ar1[i];
            prev2 = ar2[j];
            prev3 = ar3[k];
            i++;
            j++;
            k++;
        }

        // If x < y, update prev1
        // and increment i
        else if (ar1[i] < ar2[j]) {
            prev1 = ar1[i];
            i++;
        }

        // If y < z, update prev2
        // and increment j
        else if (ar2[j] < ar3[k]) {
            prev2 = ar2[j];
            j++;
        }

        // We reach here when x > y
        // and z < y, i.e., z is
        // smallest update prev3
        // and imcrement k
        else {
            prev3 = ar3[k];
            k++;
        }
        }
    }
        return res;
    }
}