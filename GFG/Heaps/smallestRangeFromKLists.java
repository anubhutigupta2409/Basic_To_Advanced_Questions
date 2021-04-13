/*

Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.

Example:

Input: K = 3
arr1[] : [4, 7, 9, 12, 15]
arr2[] : [0, 8, 10, 14, 20]
arr3[] : [6, 12, 16, 30, 50]
Output:
The smallest range is [6 8]

Explanation: Smallest range is formed by
number 7 from the first list, 8 from second
list and 6 from the third list.

Input: k = 3
arr1[] : [4, 7]
arr2[] : [1, 2]
arr3[] : [20, 40]
Output:
The smallest range is [2 20]

Explanation:The range [2, 20] contains 2, 4, 7, 20
which contains element from all the three arrays.
*/

/*

Approach-->

1.build a min heap of k elements
2.firstly store all the first elements of the lists (update the max in the process)
3.then keep on replacing the root(root will be the min) with the next of the list
4.update the range if it's more than max - min
*/
class MinHeapNode
{
    int ele, i,j;
    MinHeapNode(int ele, int i, int j)
    {
        this.ele=ele;
        this.i=i;
        this.j=j;
    }
}

class MinHeap
{
    MinHeapNode[] heap;
    int heapSize;

    public MinHeap(MinHeapNode[] arr, int size)
    {
        heap = arr;
        heapSize = size;

        int i = (heapSize - 1)/2;

        while(i>=0)
        {
            heapify(i);
            i--;
        }
    }

    void heapify(int i)
    {
        int smallest = i;
        int left= 2*i + 1;
        int right = 2*i + 2;

        if(left<heapSize && heap[left].ele < heap[smallest].ele)
            smallest = left;

        if(right<heapSize && heap[right].ele < heap[smallest].ele)
            smallest = right;

        if(smallest!=i)
        {
            MinHeapNode temp = heap[smallest];
            heap[smallest] = heap[i];
            heap[i] = temp;

            heapify(smallest);
        }

    }

    MinHeapNode getMin()
    {
            return heap[0];
    }

    void replace(MinHeapNode x)
    {
        heap[0] = x;
        heapify(0);
    }


}
class smallestRangeFromKLists
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    //add your code here

	    int range = Integer.MAX_VALUE;
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;

	    int start = -1, end = -1;

	    //min heap
	    MinHeapNode heap[] = new MinHeapNode[k];

	    //storing the first element of all the lists as of now
	    for(int i=0;i<k;i++)
	    {
	        MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
	        heap[i] = node;

	        //now making sure we store the maximum value, to obtain the
	        //shortest range possible , for eg, from [1,x] and [2,x], the later
	        //is the shortest

	        max= Math.max(max,node.ele);
	    }

	    //creating the minHeap

	    MinHeap m = new MinHeap(heap,k);

	    //now taking out one by one the root of the min heap and replacing with
	    //the next element in the list

	    while(true)
	    {
	        MinHeapNode root = m.getMin();

	        min = root.ele;

	        //updating the range
	        if(range > max - min + 1)
	        {
	            range=max-min+1;
	            start = min;
	            end = max;
	        }

	        //updating the root
	        if(root.j<n)
	        {
	            root.ele = arr[root.i][root.j++];

	            //updating the max value
	            if(root.ele > max)
	                max = root.ele;
	        }
	        else
	            break;//we have reached the end of the list

	       //replacing the root
	       m.replace(root);
	    }

	    int res[] = new int[2];
	    res[0] = start;
	    res[1] = end;

	    return res;
	}
}