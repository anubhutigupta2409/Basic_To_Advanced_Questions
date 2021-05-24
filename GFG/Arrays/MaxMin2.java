/*
Write a program to return minimum and maximum in an array, with minimum number of comparisons
*/
/*
Approachh->
[DIVIDE AND CONQUER]
1.if n==1 return that one element as both max and min
2.if n==2 return accordingly
3. else recur for both the halves and then return the maximum out of the two max(s) and similarly for the minimum
*/
class Pair
{
	int max;
	int min;
	public Pair()
	{
	}
	public Pair(int max, int min)
	{
		this.max=max;
		this.min=min;
	}
}
public class MaxMin2
{
	public static Pair maxMin(int arr[], int low, int high)
	{
	Pair minmax = new Pair();
	        Pair mml = new Pair();
	        Pair mmr = new Pair();
	        int mid;

	        // If there is only one element
	        if (low == high) {
	            minmax.max = arr[low];
	            minmax.min = arr[low];
	            return minmax;
	        }

	        /* If there are two elements */
	        if (high == low + 1) {
	            if (arr[low] > arr[high]) {
	                minmax.max = arr[low];
	                minmax.min = arr[high];
	            } else {
	                minmax.max = arr[high];
	                minmax.min = arr[low];
	            }
	            return minmax;
	        }

	        /* If there are more than 2 elements */
	        mid = (low + high) / 2;
	        mml = maxMin(arr, low, mid);
	        mmr = maxMin(arr, mid + 1, high);

	        /* compare minimums of two parts*/
	        if (mml.min < mmr.min) {
	            minmax.min = mml.min;
	        } else {
	            minmax.min = mmr.min;
	        }

	        /* compare maximums of two parts*/
	        if (mml.max > mmr.max) {
	            minmax.max = mml.max;
	        } else {
	            minmax.max = mmr.max;
	        }

        return minmax;
	}
	public static void main(String args[])
	{
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		Pair res= maxMin(arr,0,arr.length-1);

		System.out.println("Max--> "+res.max+"\nMin--> "+res.min);
	}
}