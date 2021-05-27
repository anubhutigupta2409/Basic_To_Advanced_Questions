/*
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.


Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation:
arr[0] + arr[1] = 1 + 5 = 6
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:

Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation:
Each 1 will produce sum 2 with any 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function getPairsCount() which takes arr[], n and k
as input parameters and returns the number of pairs that have sum K.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
1 <= K <= 108
1 <= Arr[i] <= 106


*/
/*
Approach-->(as easily explained by gfg)
1.Create a map to store frequency of each number in the array. (Single traversal is required)
2.In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give the
desired sum. Increment the counter accordingly.
3.After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two
times. Hence divide count by 2 and return.
*/
class CountPairsWithGivenSum {
    int getPairsCount(int[] arr, int n, int sum) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        //here key==data, value==frequency

        for(int i=0;i<n;i++)
        {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],0);//initially putting the frequency as 0

            hm.put(arr[i],hm.get(arr[i])+1);//if the key is found value will be
            //updated
        }

        int count=0;//twice the result

        for(int i=0;i<n;i++)
        {
            if(hm.get(sum-arr[i])!=null)
                count+=hm.get(sum-arr[i]);//count+=frequency


            if(sum-arr[i] == arr[i])
                count--;//other than itself

        }

        return count/2;
    }
}
