/*

Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other
elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Example 1:

Input:
5 3
1 2 3 4 5

Output:
3 2 1 4 5

Explanation:
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.

Example 2:

Input:
4 4
4 3 2 1

Output:
1 2 3 4

Explanation:
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.
Your Task:
Complete the provided function modifyQueue that takes queue and k as parameters and returns a modified queue. The printing is
done automatically by the driver code.

Expected TIme Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= N <= 1000
1 <= K <= N

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected
Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

class ReverseFirstKElements
{
    //Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
      //add code here.
        if(q.isEmpty() || k>q.size() || k<=0)
            return q;

        Stack<Integer> stk = new Stack<>();

        //push q's first k elements into an auxilliary stack
        for(int i=0;i<k;i++)
            stk.push(q.poll());

        //add those k elements back to queue, due to stack's LIFO, and queue's
        //FIFO
        //first k elements of the queue will be added to it's end in reverse order
        while(!stk.empty())
            q.add(stk.pop());

        //now bring those elements to it's front
        for(int i=0;i<q.size()-k;i++)
            q.add(q.poll());

        return q;
    }
}
