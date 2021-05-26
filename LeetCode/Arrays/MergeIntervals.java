/*
Merge Intervals
Medium

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the
non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

class MergeIntervals{
    public int[][] merge(int[][] intervals) {

        //base case
        if(intervals.length==0)
            return intervals;

        //making use of arraylist
        List<int[]> list = new ArrayList<>();

        //now our intervals should be sorted in the order of shorter start time
        //first
        //making use of lambda expression for the same
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);//since 0th position is start(i)

        //taking a current interval to exist
        int[] in = intervals[0];//the very first interval

        int i=1;//since first is already taken into consideration

        while(i<intervals.length)
        {
            //comparing the existing interval's start time with the to insert interval's end
            //time, and if the condition satisfies then it should be added
            if(intervals[i][0] > in[1])
            {
                //add as it is
                list.add(in);
                in=intervals[i];
            }
            //it's an overlapping one
            else
            {
                in[1]= Math.max(intervals[i][1],in[1]);//new interval formed, but this is
                //yet to be added to the final answer
            }
            i++;//moving forward
        }
        list.add(in);

        return list.toArray(new int[list.size()][]);
    }
}