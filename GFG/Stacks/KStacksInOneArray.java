/*
To implement N stacks in one array(we can use help arrays, no worries about that), but multiple stacks have to be implemented in
one stack only
*/

public class KStacksInOneArray
{
	static class KStacks
	{
		int arr[];//array of size n
		int top[];//size k to store top(s) of all the stacks
		int next[];//size n, to store next entry in all the stacks

		int n,k;
		int free;//Together with k stacks, a stack of free slots in arr[] is also maintained.
		//The top of this stack is stored in a variable ‘free’.

		KStacks(int k1, int n1)
		{
			k=k1;
			n=n1;

			arr = new int[n];
			top = new int[k];
			next = new int[n];

			//all stacks are initialy empty
			for(int i=0;i<k;i++)
				top[i]=-1;

			free=0;

			for(int i=0;i<n-1;i++)
				next[i]=i+1;

			next[n-1] = -1;//end of free list
		}

		//to check if there's space available

		boolean isFull()
		{
			return (free == -1);
		}


		void push(int data, int sn/*(stack number)*/)
		{
			if(isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			//accessing the free slot's index
			int i=free;

			//updating the free slot with it's next element
			free=next[i];

			//the current next is the previous top
			next[i]=top[sn];

			//current top is the previous free slot
			top[sn]=i;

			//insert the data into the available free slot
			arr[i]=data;
		}

		//to ckeck if it's empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

		int pop(int sn)
		{
			if(isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			//index of the top
			int i=top[sn];

			//updating the top, since it's getting popped out
			top[sn]=next[i];

			//the previous slot marked the starting of the free list
			next[i]=free;

			//this index is a free slot now
			free=i;

			return arr[i];
		}

	}

	//main method
	public static void main(String args[])
	{
		//creating 3 stacks in an array of size 10;

		int k=3,n=10;

		KStacks stk=new KStacks(k,n);

		stk.push(4,2);
		stk.push(8,2);

		stk.push(1,1);
		stk.push(2,1);
		stk.push(3,1);

		stk.push(10,0);
		stk.push(20,0);
		stk.push(30,0);

		System.out.println("Popped element from stack number 2 is-->"+stk.pop(2));
		System.out.println("Popped element from stack number 1 is-->"+stk.pop(1));
		System.out.println("Popped element from stack number 0 is-->"+stk.pop(0));
	}
}