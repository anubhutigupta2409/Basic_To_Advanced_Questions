/*
Merge Overlapping Intervals
Difficulty Level : Medium

Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only
mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity.
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each
other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}

*/
public class MergeOverLappingIntervals
{
	public static void mergeIntervals(Interval arr[])
	{
		if(arr.length<=0)
			return;

		Stack<Interval> stk = new Stack<>();

		//sort the intervals in increasing order of their start time
		Arrays.sort(new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2)
				{
					return i1.start - i2.start;
				}
			}
		);

		//push first element
		stk.push(arr[0]);

		for(int i=1;i<n;i++)
		{
			Interval top = stk.peek();

			//if not overlapping
			if(top.end < arr[i].start)
				stk.push(arr[i]);

			//otherwise merge
			else if(top.end < arr[i].end)
			{
				top.end = arr[i].end;
				stk.pop();
				stk.push(top);
			}
		}

		//print
		System.out.println("Merged Intervals-->");

		while(!stk.empty())
		{
			Interval curr = stk.pop();
			System.out.print("["+t.start+","+t.end+"] ");
		}
	}
}