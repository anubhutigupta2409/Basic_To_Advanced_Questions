/*

K Closest Points to Origin
Medium


Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., v(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.


Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
*/
/*
Shorter approach using compare to sort the array-->
class Solution {
    public int[][] kClosest(int[][] points, int k) {

       Arrays.sort(points,(p1,p2)-> (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0] + p2[1]*p2[1]));
        return Arrays.copyOfRange(points,0,k);


    }
}

//but this is still sorting all n elements instead of k elements
*/

class xy
{
    int x;
    int y;
    public xy(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Pair
{
    xy point;
    int dist;

    public Pair(xy point, int dist)
    {
        this.point = new xy(point.x,point.y);
        this.dist=dist;
    }
}
class MyComparator implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
        return b.dist - a.dist;
    }
}
class K_ClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        int r = points.length;
        int c= points[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());

        int dist[] = new int[r];

        for(int i=0;i<r;i++)
            dist[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];

        for(int i=0;i<r;i++)
        {
            pq.add(new Pair(new xy(points[i][0],points[i][1]) , dist[i]));
            if(pq.size()>k)
                pq.poll();
        }

        int res[][]= new int[k][c];

        for(int i=0;i<k;i++)
        {
            res[i][0]=pq.peek().point.x;
            res[i][1]=pq.peek().point.y;

            pq.poll();
        }

        return res;
    }
}