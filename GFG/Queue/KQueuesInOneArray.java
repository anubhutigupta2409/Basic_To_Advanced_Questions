/*
How to efficiently implement k Queues in a single array?
Difficulty Level : Hard

*/
import java.util.*;

class  KQueues
{
	int k;
	int n;
	int arr[];

	int front[];
	int rear[];

	int next[];

	int free;

	public KQueues(int k, int n)
	{
		this.k = k;
		this.n = n;
		this.arr = new int[n];

		this.front = new int[k];
		this.rear = new int[k];

		this.next = new int[n];

		this.free=0;

		for(int i=0;i<k;i++)
			this.front[i] = this.rear[i] = -1;

		for(int i=0 ; i<n-1;i++)
			this.next[i] = i+1;

		next[n-1] = -1;
	}

	public boolean isEmpty(int qn)
	{
		return (front[qn] == -1);
	}
	public boolean isFull(int qn)
	{
		return (free == -1);
	}

	public void enqueue(int data, int qn/*queue number*/)
	{
		if(isFull(qn))
		{
			System.out.println("Queue Overflow");
			return;
		}

		int nextFree = next[free];

		if(isEmpty(qn))
		{
			front[qn] = rear[qn] = free;
		}
		else
		{
			next[rear[qn]]=free;
			rear[qn]=free;
		}
		next[free]=-1;
		arr[free] = data;
		free = nextFree;
	}

	public int dequeue(int qn)
	{
		if(isEmpty(qn))
		{
			System.out.println("Queue Underflow");
			return -1;
		}

		int frontIndex= front[qn];

		front[qn] = next[front[qn]];
		next[front[qn]]= free;
		free= frontIndex;

		return arr[frontIndex];
	}

}

public class KQueuesInOneArray
{
	public static void main(String args[])
	{
		int k = 3, n = 10;
        KQueues ks=  new KQueues(k, n);


        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);

        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);

        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);

        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));

        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0) );

	}
}