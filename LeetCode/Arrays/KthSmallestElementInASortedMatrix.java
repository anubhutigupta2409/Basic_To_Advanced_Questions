/*
Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
*/

class Pair{
    int x;
    int y;
    int val;

    public Pair(int x, int y, int val)
    {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.val - b.val);

        int n = matrix.length;

        for(int j=0;j<n;j++)
            pq.add(new Pair(0,j,matrix[0][j]));

        for(int i=0;i<k-1;i++)
        {
            Pair pair = pq.poll();
            if(pair.x == n-1)
                continue;
            pq.add(new Pair(pair.x+1, pair.y, matrix[pair.x+1][pair.y]));
        }

        return pq.poll().val;
        
    }
}
