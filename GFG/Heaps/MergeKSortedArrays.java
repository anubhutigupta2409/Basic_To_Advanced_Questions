/*

Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6],
[7, 8, 9]]
The merged list will be
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5,
6, 6, 7, 8, 9, 9 ].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays, as input and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)

Constraints:
1 <= K <= 100


*/

//approach-->

/*
1.Create Min heap of size k
2.Insert first element of all the arrays--> then heapify(as all the first elements of the array are minimum in their array and
adding them in the min heap will give us the minimum element)
3.Run a loop till there's any elements left in the heap
	3.a)add the root element (that is the minimum element) of the min heap, to the result
	3.b)replace it with the next element(that is, the next element of the array from which the minimum element was removed)
*/

class MinHeapNode
{
    int element;//data stored
    int i;//index of the array
    int j;//index of next element

    public MinHeapNode(int element, int i, int j)
    {
        this.element=element;
        this.i=i;
        this.j=j;
    }
}

class MinHeap
{
    MinHeapNode heap[];
    int heapSize;

    //building a heap
    public MinHeap(MinHeapNode a[], int heapSize)
    {
        this.heapSize = heapSize;//size of our heap
        heap = a;//representative array

        //last non-leaf node
        int i =(heapSize-1)/2;
        while(i>=0)
        {
            heapify(i);
            i--;
        }
    }

    //heapify method for min heap
    void heapify(int i)
    {
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left<heapSize && heap[left].element < heap[smallest].element)
            smallest = left;

        if(right<heapSize && heap[right].element < heap[smallest].element)
            smallest = right;

        if(smallest != i)
        {
            MinHeapNode temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            heapify(smallest);
        }
    }

    //method to get minimum, that is, the root of the min heap
    MinHeapNode getMin()
    {
        if(heapSize<=0)
            return null;

        return heap[0];
    }

    //to replace the root
    void replaceMin(MinHeapNode x)
    {
        heap[0]=x;
        heapify(0);
    }
}
public class MergeKSortedArrays
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k)
    {
        // Write your code here.
        MinHeapNode heap[] = new MinHeapNode[k];
        int resultSize = 0;

        for(int i=0;i<arrays.length;i++)
        {
            MinHeapNode node = new MinHeapNode(arrays[i][0],i,1);
            heap[i]= node;
            resultSize+=arrays[i].length;
        }

        //creating a min heap
        MinHeap m = new MinHeap(heap,k);

        ArrayList<Integer> result = new ArrayList<>(resultSize);

        //getting the minimum element from the heap and replacing it with another
        //element

        for(int i=0;i<resultSize;i++)
        {
            MinHeapNode root = m.getMin();
            result.add(root.element);

            //the next element to be inserted belongs to the same array as that
            //of our previous root

            if(root.j < arrays[root.i].length)
                root.element = arrays[root.i][root.j++];

            //if root was the last element
            else
                root.element = Integer.MAX_VALUE;

            //replacing
            m.replaceMin(root);
        }

        return result;
    }
}