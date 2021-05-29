/*
Median of two sorted arrays of same size
Difficulty Level : Hard


There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the
above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)).


*/
/*
Approach as explained by gfg -->
1) Calculate the medians m1 and m2 of the input arrays ar1[]
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
Examples :

   ar1[] = {1, 12, 15, 26, 38}
   ar2[] = {2, 13, 17, 30, 45}
For above two arrays m1 = 15 and m2 = 17
For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of the following two subarrays.

   [15, 26, 38] and [2, 13, 17]
Let us repeat the process for above two subarrays:

    m1 = 26 m2 = 13.
m1 is greater than m2. So the subarrays become

  [15, 26] and [13, 17]
Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
                       = (max(15, 13) + min(26, 17))/2
                       = (15 + 17)/2
                       = 16
*/
public class MedianSortedArraysSameSize
{
	public static int median(int arr[], int start, int end)
	{
		int n= end - start + 1;

		if(n%2 == 0)
			return (arr[start + n/2] + arr[start + n/2 -1])/2;
		else
			return arr[start+n/2];
	}
	public static int getMedian(int a[],int b[], int startA, int startB, int endA, int endB)
	{
		if(a.length==0)
			return -1;

		else if(a.length==1)
			return (a[0]+b[0])/2;

		else
		{
			//base case
			//2 elements in both arrays

			if(endA-startA == 1)
				return (Math.max(a[startA],b[startB]) + Math.min(a[endA],b[endB]) )/2;

			int m1 = median(a,startA,endA);
			int m2 = median(b,startB,endB);

			if(m1==m2)
				return m1;

			else if(m1<m2)
				return getMedian(a,b, (endA+startA+1)/2 , startB, endA, (endB+startB+1)/2 );

			else
				return getMedian(a, b, startA, (endB+startB+1)/2 ,(endA+startA+1)/2 ,  endB);
		}
	}
	public static void main(String args[])
	{
		int ar1[] = { 1, 2, 3, 6 };
        int ar2[] = { 4, 6, 8, 10 };

        System.out.println("Median is "+ getMedian( ar1, ar2, 0, 0, ar1.length - 1, ar2.length - 1));
	}
}