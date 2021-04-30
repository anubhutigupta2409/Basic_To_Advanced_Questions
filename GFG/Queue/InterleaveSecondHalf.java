/*
Interleave the first half of the queue with second half
Difficulty Level : Medium

Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second
half of the queue.

Only a stack can be used as an auxiliary space.

Examples:

Input :  1 2 3 4
Output : 1 3 2 4

Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20
*/

/*
-->assuming immediate left of a data structure is it's top
Approach-->

1.Push the first half elements of queue to stack.
Q-->[16,17,18,19,20] , S-->[15,14,13,12,11]

2.Enqueue back the stack elements.
Q-->[16,17,18,19,20,15,14,13,12,11] , S-->null

3.Dequeue the first half elements of the queue and enqueue them back.
Q-->[15,14,13,12,11,16,17,18,19,20] , S-->null

4.Again push the first half elements into the stack.
Q-->[16,17,18,19,20] , S-->[11,12,13,14,15]

5.Interleave the elements of queue and stack.
Q-->[11,16,12,17,13,18,14,19,15,20]

here, inerleaving means inserting(mixing up) the elements according to the requirement

*/
import java.util.*;


public class InterleaveSecondHalf
{
	public void interLeave(Queue<Integer> q)
	{
		Stack<Integer> stk = new Stack<>();

		if((q.size()&1) == 1)
		{
			System.out.println("Give input queue with even number of elements-->");
			return;
		}

		int halfSize = q.size()/2;
		//step-1
		for(int i=0;i<halfSize ;i++)
			stk.push(q.poll());

		//step-2
		while(!stk.empty())
			q.add(stk.pop());

		//step-3
		for(int i=0;i<halfSize;i++)
			q.add(q.poll());

		//step-4
		for(int i=0;i<halfSize;i++)
			stk.push(q.poll());

		//step-5
		while(!stk.empty())
		{
			q.add(stk.pop());
			q.add(q.poll());
		}

	}

	public static void main(String args[])
	{
		InterleaveSecondHalf obj = new InterleaveSecondHalf();

		Queue<Integer> q = new LinkedList<>();

		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);

		System.out.println("Queue Before-->\n"+q);

		obj.interLeave(q);

		System.out.println("\nQueue After-->\n"+q);
	}
}