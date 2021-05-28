/*
Count More than n/k Occurences
Medium
Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

Example 1:

Input:
N = 8
arr[] = {3,1,2,2,1,2,3,3}
k = 4
Output: 2
Explanation: In the given array, 3 and
 2 are the only elements that appears
more than n/k times.
Example 2:

Input:
N = 4
arr[] = {2,3,3,2}
k = 3
Output: 2
Explanation: In the given array, 3 and 2
are the only elements that appears more
than n/k times. So the count of elements
are 2.
Your Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 104
1 <= a[i] <= 106
1 <= k <= N

*/
/*
Another approach explained by gfg inspired by moore's voting algo(Majority Element) //can be seen
*/
class MoreThan_NBYK_Frquency
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k)
    {
        // your code here,return the answer
        int nByK= n/k;
        HashMap<Integer,Integer> hm = new HashMap<>();
        //<data,count> <key,value>

        for(int i=0;i<n;i++)
        {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],1);

            else
                hm.put(arr[i], hm.get(arr[i])+1);
        }

        int ans=0;

        for(Map.Entry m : hm.entrySet())
        {
            Integer temp = (Integer)m.getValue();
            if(temp>nByK)
                ans++;
        }

        return ans;

    }
}
