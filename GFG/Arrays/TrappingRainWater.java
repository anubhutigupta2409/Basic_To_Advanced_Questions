/*

Trapping Rain Water
Medium
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.


Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation:

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above
block of height 4 is 3 units and above
block of height 0 is 7 units. So, the
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
3 <= N <= 107
0 <= Ai <= 108


*/
/*
Approach-->
1.Water is bound by the greatest element in the left subarray(left) and greatest element in the right subarray(right)
2.The height of the water trapped is defined by the minimum of left and right, as for a building to be able to store water above
it, another building with height higher than it must exist to hold the water
3.what's the height of water above a bulding x --> [(min of it's left, right) - (x's own height)] *1 = as unit 1 is width of each
building
4.and the sum of these heights = total area of rainwater trapped
5.Dry run-->

3 0 0 2 0 4 <--arr
3 3 3 3 3 4 <--left
4 4 4 4 4 4 <--right
0 3 3 1 3 0 <--height

sum(area) = 0+3+3+1+3+0 = 10 sq. units

5.How to calculate left? initialise left[0] as arr[0] then compare(left[i-1], arr[i])
on the way as we traverse from left to right (i=1;i<n)
6.How to calculate right? initialise right[n-1] as arr[n-1] then compare(right[i+1], arr[i])
on the way as we traverse from right to left (i=n-1;i>=0)

*/
class TrappingRainWater {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) {

        // Your code here
        int leftGreater[] = new int[n];
        int rightGreater[]=new int[n];
        int waterHeight[] = new int[n];

        leftGreater[0] = arr[0];

        for(int i=1;i<n;i++)
            leftGreater[i]= Math.max(leftGreater[i-1], arr[i]);

        rightGreater[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--)
            rightGreater[i]= Math.max(rightGreater[i+1], arr[i]);

        for(int i=0;i<n;i++)
            waterHeight[i]=Math.min(leftGreater[i],rightGreater[i])-arr[i];

        int ans=0;

        for(int i=0;i<n;i++)
            ans+=waterHeight[i];

        return ans;
    }
}


