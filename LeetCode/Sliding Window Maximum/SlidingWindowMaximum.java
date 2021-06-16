/*
 Sliding Window Maximum
Hard

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayList<Integer> ans = new ArrayList<>();//ans

        //for storing max elements
        Deque<Integer> q = new ArrayDeque<>();

        //pointers
        int i=0,j=0;

        while(j<nums.length)
        {
            //before adding j(th) element remove all the elements from the queue, which are
            //smaller than it, because-->
            //a) they are not useful as max element is talked about
            //b) they are not part of the current window

            while(!q.isEmpty() && q.peekLast()<nums[j])
                q.removeLast();

            //now add the jth element
            q.addLast(nums[j]);

            //if window size is hit
            if(j-i+1 == k)
            {
                //answer calculation
                ans.add(q.peek());

                //removing effects of ith element, which is not longer part of our window
                if(nums[i]==q.peek())
                    q.removeFirst();

                //moving forward
                i++;
            }
            j++;
        }


        return ans.stream().mapToInt(x -> x).toArray();
    }
}