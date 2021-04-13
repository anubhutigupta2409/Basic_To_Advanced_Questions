/*
Given array representation of min Heap, convert it to max Heap in O(n) time.
Example :

Input: arr[] = [3 5 9 6 8 20 10 12 18 9]
         3
      /     \
     5       9
   /   \    /  \
  6     8  20   10
 /  \   /
12   18 9


Output: arr[] = [20 18 10 12 9 9 3 5 6 8] OR
       [any Max Heap formed from input elements]

         20
       /    \
     18      10
   /    \    /  \
  12     9  9    3
 /  \   /
5    6 8

*/

/*
Approach--> nothing to be done only heapifying, therefore copied the code
*/
// Java program to convert min Heap to max Heap

public class MinToMaxHeap
{
    // To heapify a subtree with root at given index
    static void MaxHeapify(int arr[], int i, int n)
    {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest = i;
        if (l < n && arr[l] > arr[i])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, n);
        }
    }

    // This function basically builds max heap
    static void convertMaxHeap(int arr[], int n)
    {
        // Start from bottommost and rightmost
        // internal mode and heapify all internal
        // modes in bottom up way
        for (int i = (n-1)/2; i >= 0; --i)
            MaxHeapify(arr, i, n);
    }

    // A utility function to print a given array
    // of given size
    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i]+" ");
    }

    // driver program
    public static void main (String[] args)
    {
        // array representing Min Heap
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;

        System.out.print("Min Heap array : ");
        printArray(arr, n);

        convertMaxHeap(arr, n);

        System.out.print("\nMax Heap array : ");
        printArray(arr, n);
    }
}
