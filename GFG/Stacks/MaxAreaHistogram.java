/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of
contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12
Explanation:


Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram
will be 8  and there will be 2 consecutive
histogram. And hence the area of the
histogram will be 8x2 = 16.
Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest
rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 106
1 <= arr[i] <= 1012
*/
/*
Approach-->
1.All we need to do is make rectangle
2.How to make a rectangle, check till where a particular bar can be extended
3.It can be extended till the length, till when a particular bar next to cuurent bar has height >= to the current
4.So by observing this when do we stop ? we stop when for a particular bar it's nearest smaller to left on the left side, and
nearest smaller to right to right on the right side is reached.
5.We store indices of the above in two different arrays.
6.Note* --> we store pseudo index for right as "n" when no smaller element is found, and "-1" for left
7. width = right - left -1
8. area = height*width , then find the maximum area

Dry run-->
{ 6, 2, 5, 4, 5, 1, 6} <-- Array
  0, 1, 2, 3, 4, 5, 6  <-- index
 -1,-1, 1, 1, 3,-1, 5  <-- left
  1, 5, 3, 5, 5, 7, 7  <-- right
  1, 5, 1, 3, 1, 7, 1  <-- width
  6,10, 5,12, 5, 7, 6  <-- area

*/
import java.util.*;

class Pair
{
    int index;
    int element;

    public Pair(int i, int e)
    {
        index = i;
        element = e;
    }
}
public class MaxAreaHistogram
{
    //Function to find largest rectangular area possible in a given histogram.
    public static int getMaxArea(int hist[], int n)
    {
        // your code here

        int width[] = new int[n];

        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Pair> stk = new Stack<>();

        //nearest smaller to left
        for(int i=0; i<n;i++)
        {
            while(!stk.empty() && stk.peek().element >= hist[i])
                stk.pop();

            if(stk.empty())
                left[i] = -1;
            else
                left[i] = stk.peek().index;

            stk.push(new Pair(i,hist[i]));
        }

		stk.clear();

        //nearest smaller to right
        for(int i= n-1; i>=0;i--)
        {
            while(!stk.empty() && stk.peek().element >= hist[i])
                stk.pop();

            if(stk.empty())
                right[i] = n;
            else
                right[i] = stk.peek().index;

            stk.push(new Pair(i,hist[i]));
        }

        //width array-->
        for(int i=0;i<n;i++)
            width[i] = right[i] - left[i] - 1;

        int maxArea = Integer.MIN_VALUE;
        int area=1;


        for(int i=0;i<n;i++)
        {
            area = width[i]*hist[i];
            if(area > maxArea)
                maxArea = area;
        }

        return maxArea;

    }

    public static void main(String args[])
    {
		int hist[] = {6,2,5,4,5,1,6};

		System.out.println(getMaxArea(hist, hist.length));
	}

}



