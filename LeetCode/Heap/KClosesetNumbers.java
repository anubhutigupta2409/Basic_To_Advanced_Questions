/*

Find K Closest Elements
Medium

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also
be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
*/
class MyComparator implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
       if (a.diff-b.diff == 0)
            return b.val-a.val;
        else
            return b.diff-a.diff;
    }
}
class Pair
{
    int val;
    int diff;

    public Pair(int val, int diff)
    {
        this.val= val;
        this.diff=diff;
    }
}
class KClosesetNumbers{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>();

        //max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());

        int n= arr.length;

        //diff array
        int diff[] = new int[n];

        for(int i=0;i<n;i++)
            diff[i]=Math.abs(arr[i]-x);

        for(int i=0;i<n;i++)
        {
            pq.add(new Pair(arr[i],diff[i]));

            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            res.add(pq.poll().val);

        Collections.sort(res);

        return res;
    }
}