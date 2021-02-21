
/*
Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two
trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path
in each tree of length nine, but no path longer than nine nodes).



Example 1:

Input:
       1
     /  \
    2    3
Output: 3
Example 2:

Input:
         10
        /   \
      20    30
    /   \
   40   60
Output: 4
Your Task:
You need to complete the function diameter() that takes root as parameter and returns the diameter.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000


*/

class A
{
    int ans = Integer.MIN_VALUE;
}

class DiameterOptimised{
    /* Complete the function to get diameter of a binary tree */

    //concept-->
    //diameter is nothing else but the maximum value of
    //(leftH + rightH + 1)
    //out of all the nodes

    int height(Node node, A a)
    {
        if(node==null)
            return 0;

        int leftH = height(node.left,a);
        int rightH = height(node.right,a);

        //calculates (leftH + rightH + 1) for each node,
        //and the maximum value gets stored in the 'ans'
        a.ans= Math.max(a.ans, leftH + rightH + 1);

        //calculates the height
        return 1 + Math.max(leftH , rightH);
    }
    int diameter(Node root) {
        // Your code here
        if(root==null)
            return 0;

        A a = new A();
        int heightTREE = height(root,a);
        return a.ans;

    }
}
//time complexity of O(n)

