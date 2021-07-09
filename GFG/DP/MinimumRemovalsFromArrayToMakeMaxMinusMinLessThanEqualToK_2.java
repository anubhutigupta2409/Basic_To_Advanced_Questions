// Java program for the above approach
import java.util.*;

class  MinimumRemovalsFromArrayToMakeMaxMinusMinLessThanEqualToK_2
{

// Function to find rightmost index
// which satsfies the condition
// arr[j] - arr[i] <= k
static int findInd(int key, int i,
				int n, int k, int arr[])
{
  	int start = i+1, end = n-1, mid, ind = -1;

  	while(start<end)
    {
      	mid = start + (end-start)/2;

      	if(arr[mid]-key<=k)
        {
          	ind = mid;//potential index
          	start = mid+1;//as we have to find max
        }
      	else
          	end = mid;
    }

  	return ind;
}

// Function to calculate
// minimum number of elements
// to be removed
static int removals(int arr[], int n, int k)
{
	//sort the array
  	Arrays.sort(arr);
  	int i,j,ans=n-1;//as at max we can remove all the
  	//elements

  	//traversing through the sorted array and finding
  	//the max no. such that arr[j]-arr[i]<=k

  	for(i=0;i<n;i++)
    {
      	j = findInd(arr[i],i,n,k,arr);

      	//if such element exists
      	if(j!=-1)
          	ans = Math.min(ans, n-(j-i+1));
    }

  	return ans;
}

// Driver Code
public static void main(String args[])
{
	int a[] = { 1, 3, 4, 9, 10,
				11, 12, 17, 20 };
	int n = a.length;
	int k = 4;

	System.out.println(removals(a, n, k));
}
}

/*
Time Complexity --> O(nlongn) <-- due to the binary search, not considering the complexity required to sort the array
*/