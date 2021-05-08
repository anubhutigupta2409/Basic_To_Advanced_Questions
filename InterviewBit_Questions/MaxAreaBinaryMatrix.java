/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0
    ]

Output : 4

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

*/
/*
How do we make this similar to the problem maximum area in a histogram --> ??
1. convert into 1-D matrix
2. for example-->

make individual histograms

0 1 1 0 	--> 0 1 1 0 		maxArea=2
1 1 1 1		--> (0+1) (1+1) (1+1) (0+1) --> 1 2 2 1 	maxArea= 4
1 1 1 1		--> (1+1) (2+1) (2+1) (1+1) --> 2 3 3 2 	maxArea= 8
1 1 0 0		--> (2+1) (3+1)   0     0   --> 3 4 0 0 	maxArea= 6 (why zero over here, as ground level has changed and no histogram exists over here therefore, zero)
*/
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
public class MaxAreaBinaryMatrix {
    public int MAH(int hist[])
    {
        // your code here

        int n= hist.length;

        int width[] = new int[n];

        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Pair> stk = new Stack<>();

        //nearest greater to left
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

        //nearest greater to right
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
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        //histogram array
        int hist[] = new int[A.get(0).size()];

        //first histogram
        for(int j=0;j<A.get(0).size() ;j++)
            hist[j]=A.get(0).get(j);

        int max = MAH(hist);

        for(int i=1;i<A.size();i++)
        {
            for(int j=0;j<A.get(0).size();j++)
            {
                if(A.get(i).get(j) == 0)
                    hist[j]= 0;
                else
                    hist[j]+= A.get(i).get(j);
            }

            max = Math.max(max , MAH(hist));
        }

        return max;


    }
}
