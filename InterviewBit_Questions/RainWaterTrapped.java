/*

Rain Water Trapped
Asked in:
Qualcomm
Amazon
Microsoft
Goldman Sachs
Problem Description

Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how
much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is integer array A.



Output Format
Return the total water it is able to trap after raining.



Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:

 A = [1, 2]


Example Output
Output 1:

 6
Output 2:

 0



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
public class RainWaterTrapped {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {

        int maxLeft[] = new int[A.size()];
        int maxRight[] = new int[A.size()];

        maxLeft[0] = A.get(0);

        for(int i=1;i<A.size();i++)
            maxLeft[i] = Math.max(maxLeft[i-1] , A.get(i));

        maxRight[A.size()-1] = A.get(A.size()-1);

        for(int i=A.size()-2;i>=0;i--)
            maxRight[i] = Math.max(maxRight[i+1] , A.get(i));

        int water[] = new int[A.size()];

        for(int i=0;i<A.size();i++)
            water[i] = Math.min(maxLeft[i] , maxRight[i]) - A.get(i);

        int sum=0;

        for(int i=0;i<water.length;i++)
            sum+= water[i];

        return sum;
    }
}
