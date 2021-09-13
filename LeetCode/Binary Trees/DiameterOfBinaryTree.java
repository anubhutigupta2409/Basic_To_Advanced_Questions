/*
Diameter of Binary Tree
Easy

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class A
{
    int ans= Integer.MIN_VALUE;
}
class DiameterOfBinaryTree {
    public int height(TreeNode root, A a)
    {
        if(root==null)
            return 0;
        int leftH= height(root.left,a);
        int rightH= height(root.right,a);

        a.ans=Math.max(a.ans, leftH+rightH+1);

        return Math.max(leftH,rightH)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;

        A a= new A();
        int heightOfTheTree= height(root,a);

        //no. of edges = nodes-1
        return a.ans-1;
    }
}

//Aditya Verma explanation -->

class A
{
    int res;
    A(int res)
    {
        this.res = res;
    }
}
class Solution {
    private int solve(TreeNode root, A a)
    {
        //base 
        if(root==null)
            return 0;
        
        //hypothesis
        int leftD = solve(root.left,a);
        int rightD = solve(root.right,a);
        
        //induction
        int temp = 1 + Math.max(leftD,rightD);
        int ans = Math.max(temp , 1+leftD+rightD);
        
        a.res = Math.max(a.res,ans);
        
        return temp;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        A a = new A(Integer.MIN_VALUE);
        
        int x = solve(root,a);
        
        return a.res-1;
        
    }
}
