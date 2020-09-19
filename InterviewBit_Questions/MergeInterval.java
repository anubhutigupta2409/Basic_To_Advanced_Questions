/*
//in this program we solve the MergeIntervals problem from interview bit
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(intervals == null)
        {	//as if it's null, we have to create new ArrayList
            intervals= new ArrayList<Interval> ();
            intervals.add(newInterval);
            return intervals;
        }
        else if(intervals.size() == 0)
        {	//if size is zero we add the newInterval
            intervals.add(newInterval);
            return intervals ;
        }
        Interval toInsert = newInterval;
        int i=0;
        while(i<intervals.size())
        {
            Interval current= intervals.get(i);
            if(current.end < toInsert.start)
                    {	//because the interval is not overlapping with this one therefore move forward
                    	//and do nothing
	                    i++;
	                    continue;
	                }
	                else if(toInsert.end < current.start)
	                {	//beacuse the new interval is not overlapping and falls in the range too
	                	//so just the right time to add it(append it)
	                    intervals.add(i,toInsert);
	                    break;
	                }
	                else
	                {	//now the case when we need to perform merging
	                    toInsert.start = Math.min(toInsert.start, current.start) ;//making of a new interval
	                    toInsert.end = Math.max(toInsert.end , current.end);
	                    intervals.remove(i);//and removing of the old ones
	                    //here we didn't add the interval right after,since we are moving in a loop
	                    //and we need to take care of the further intervals that we might encounter
	                    //as we further traverse through the arraylist
	                }


	            }
	            //here we add the newly made toInsert interval from condition 3, in case it is not handled by the
	            //condition 2, i.e; there were no more intervals in the arraylist
	            if(i == intervals.size())
	                intervals.add(toInsert);

	             return intervals;
	        }
	    }
