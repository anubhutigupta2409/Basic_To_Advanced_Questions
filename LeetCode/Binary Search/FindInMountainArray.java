/*
Find in Mountain Array
Hard

(This problem is an interactive problem.)

You may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


Constraints:

3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9
*/


/*
1.find peak element
2.left of peak is sorted in ascending order
3.right of peak is sorted in descending order
4.Note** bitonic array can never be equal to rotated sorted array, no matter how much you rotate it ,it can never be converted
into a complete sorted array
*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class FindInMountainArray{
     public int binarySearch(MountainArray m,int start, int end, int target) {



        while(start<=end)
        {
            int mid = start + (end-start)/2;//to avoid any type of overflow

            if(target==m.get(mid))
                return mid;
            else if(target<m.get(mid))
                end = mid-1;
            else
                start=mid+1;
        }

        return -1;
    }
    public int binarySearchR(MountainArray m, int start, int end, int ele)
	{

		while(start<=end)
		{
			int mid=start + (end-start)/2 ;

			if(ele==m.get(mid))
				return mid;

			else if(ele<m.get(mid))
				start = mid+1;
			else
				end = mid-1;
		}
        return -1;
	}
    public int peakElement(MountainArray m) {

        int n=m.length();
        int start=0, end=n-1;


        while(start<=end)
        {
            int mid = start+(end-start)/2;

            if(mid>0 && mid<n-1)
            {
                if(m.get(mid)>m.get(mid-1) && m.get(mid)>m.get(mid+1))
                    return mid;

                else if(m.get(mid-1)>m.get(mid))
                    end=mid-1;//left

                else if(m.get(mid+1)>m.get(mid))
                    start= mid+1;//right
            }
            //starting element
            else if(mid==0)
            {
                if(m.get(mid) > m.get(1))
                    return mid;
                else
                    return 1;
            }
            //ending element
            else if(mid==n-1)
            {
                if(m.get(mid)>m.get(n-2))
                    return mid;
                else
                    return n-2;
            }
        }
        return -1;


    }
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n= mountainArr.length();
        int peakIndex= peakElement(mountainArr);

        int pos1= binarySearch(mountainArr, 0, peakIndex-1, target);
        int pos2= binarySearchR(mountainArr, peakIndex, n-1, target);

        if(pos1<0)
            return pos2;
        else if(pos2<0)
            return pos1;
        else
            return Math.min(pos1,pos2);

    }
}