/*
Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 4
Output: 10
*/

/*
Approach--> we can use heap sort and get the smallest element in O(nlongn) timecomplexity, but we do a slight optimisation as well
1.Max heap pf arr[0] to arr[k-1]
2.compare with each element in the range of arr[k] to arr[n-1] with the root of the max heap,
	2.a) if less swap the root with it and call the heapify method
	2.b) else ignore
3.finally the root of the max heap is the kth smalledt element

Time complexity--> O(k + (n-k)logk)
*/

public class KthSmallestElementUnsortedArray
{
	class MaxHeap
	{
		int heap[];

		int capacity;
		int heapSize;

		//utility methods

		int parent(int i)
		{
			return (i-1)/2 ;
		}
		int left(int i)
		{
			return 2*i + 1;
		}
		int right(int i)
		{
			return 2*i + 2;
		}
		int getMax()
		{
			return heap[0];
		}

		//swaps the passed element with the root of the heap
		void replace(int x)
		{
			this.heap[0] = x;
			heapify(0);
		}

		//constructor
		MaxHeap(int a[], int n)
		{
			heap=a;
			heapSize=n;

			int i=(heapSize-1)/2; //last non-leaf node

			while(i>=0)
			{
				heapify(i);
				i--;
			}
		}

		//delete max element that is root from the max heap
		int extractMax()
		{
			if(heapSize == 0)
				return Integer.MAX_VALUE;

			int root = heap[0];

			if(heapSize>1)
			{
				heap[0] = heap[heapSize-1];//replacing with last element
				heapify(0);
			}

			heapSize--;

			return root;
		}

		void heapify(int i)
		{
			int largest = i;
			int l = left(i);
			int r= right(i);

			if(l<heapSize && heap[l]>heap[largest])
				largest = l;

			if(r<heapSize && heap[r]>heap[largest])
				largest = r;

			if(largest != i)
			{
				int temp = heap[i];
				heap[i] = heap[largest];
				heap[largest] = temp;

				heapify(largest);
			}
		}

	}

	public int kThSmallest(int a[], int n, int k)
	{
		MaxHeap mh = new MaxHeap(a,k);

		//doing step 2 of our approach
		for(int i=k;i<n;i++)
			if(a[i]<mh.getMax())
				mh.replace(a[i]);

		return mh.getMax();//final answer
	}

	public static void main(String args[])
	{
		int a[] = {12, 3, 5, 7, 19 };
		int n= a.length , k= 4;
		KthSmallestElementUnsortedArray x = new KthSmallestElementUnsortedArray();
		System.out.println("kth smallest number = "+ x.kThSmallest(a,n,k));
	}
}