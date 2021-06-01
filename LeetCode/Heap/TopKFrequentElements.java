/*

Top K Frequent Elements
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Pair
{
    int val;
    int freq;

    public Pair(int val, int freq)
    {
        this.val=val;
        this.freq=freq;
    }
}
class MyComparator implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
        if(a.freq - b.freq == 0)
            return a.val-b.val;
        else
            return a.freq-b.freq;
    }
}
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        //mapping required to store frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        //key--> nums[i] value-->frequency

        int n=nums.length;

        //storing frequencies
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i] , map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }

        //min Heap
        PriorityQueue<Pair> pq= new PriorityQueue<>(new MyComparator());

        for(int x : map.keySet())
        {
            pq.add(new Pair(x ,map.get(x)));
            if(pq.size()>k)
                pq.poll();
        }

        int res[] = new int[k];

        for(int i=0;i<k;i++)
            res[i]=pq.poll().val;


        return res;

    }
}