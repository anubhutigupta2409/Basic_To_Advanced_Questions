/*

Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not. Both
the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.


Example 1:

Input:
a1[] = {11, 1, 13, 21, 3, 7}
a2[] = {11, 3, 7, 1}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 2:

Input:
a1[] = {1, 2, 3, 4, 5, 6}
a2[] = {1, 2, 4}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 3:

Input:
a1[] = {10, 5, 2, 23, 19}
a2[] = {19, 5, 3}
Output:
No
Explanation:
a2[] is not a subset of a1[]


Your Task:
You don't need to read input or print anything. Your task is to complete the function isSubset() which takes the array a1[], a2[],
its size n and m as inputs and return "Yes" if arr2 is subset of arr1 else return "No" if arr2 is not subset of arr1.



Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)


Constraints:
1 <= n,m <= 105
1 <= a1[i], a2[j] <= 105






*/
class ArraySubsetOfAnother {
    public String isSubset( long a1[], long a2[], long n, long m) {

        boolean ans=true;

        HashSet<Long> hs = new HashSet<>();

        //add all elements of array 1 to the hashSet
        for(int i=0;i<n;i++)
            if(!hs.contains(a1[i]))
                hs.add(a1[i]);

        //checking if elements of array 2 exists in the hashset
        for(int i=0;i<m;i++)
        {
            if(!hs.contains(a2[i]))
            {
                ans=false;
                break;
            }
        }

        if(ans)
            return "Yes";
        else
            return "No";
    }
}