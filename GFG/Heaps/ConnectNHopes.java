/*

There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output:
29
Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
Example 2:

Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output:
62
Explanation:
First, connect ropes 4 and 2, which makes the
array {6,7,6,9}. Next, add ropes 6 and 6, which
results in {12,7,9}. Then, add 7 and 9, which
makes the array {12,16}. And finally add these
two which gives {28}. Hence, the total cost is
6 + 12 + 16 + 28 = 62.
Your Task:
You don't need to read input or print anything. Your task isto complete the function minCost() which takes 2 arguments and returns the minimum cost.

Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)

Constraints:
1 = N = 100000
1 = arr[i] = 106
*/

/*
Approach-->

Explanation--> always connect two ropes with minimum lengths first and those keep on getting add-->
for an array of lengths(2,3,4,6)

2+3=(5)+4=(9)+6=(15) ==> 5 + 9 + 15= 29

steps==>

1. insert all the lengths in a min heap
2. remove first two minimum elements from it
3. add them and update in the total cost
4. now insert the added value(calculated at step 3) into the heap back
*/
class MinHeap {
    long[] harr; // Array of elements in heap
    int heap_size; // Current number of elements in min heap
    int capacity; // maximum possible size of min heap

    // Constructor: Builds a heap from
    // a given array a[] of given size
    public MinHeap(long a[], int size)
    {
        heap_size = size;
        capacity = size;
        harr = a;
        int i = (heap_size - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) { return (i - 1) / 2; }

    // to get index of left child of node at index i
    int left(int i) { return (2 * i + 1); }

    // to get index of right child of node at index i
    int right(int i) { return (2 * i + 2); }

    // Method to remove minimum element (or root) from min heap
    long extractMin()
    {
        if (heap_size <= 0)
            return Integer.MAX_VALUE;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        // Store the minimum value, and remove it from heap
        long root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return root;
    }

    // Inserts a new key 'k'
    void insertKey(long k)
    {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        // First insert the new key at the end
        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;

        // Fix the min heap property if it is violated
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // A utility function to check
    // if size of heap is 1 or not
    boolean isSizeOne()
    {
        return (heap_size == 1);
    }

    // A utility function to swap two elements
    void swap(int x, int y)
    {
        long temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }
}
class ConnectNHopes
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        // your code here
        long cost = 0;

        MinHeap heap = new MinHeap(arr,n);

        //till it's size doesn't become 1
        while(!heap.isSizeOne())
        {
            //extracting two minimum elements
            long min = heap.extractMin();
            long secondMin = heap.extractMin();

            //cost updation
            cost += (min + secondMin);

            //inserting
            heap.insertKey(min + secondMin);
        }

        return cost;
    }
}