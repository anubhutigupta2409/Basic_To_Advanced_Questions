/*
Construct Binary Tree from Inorder and Postorder Traversal
Medium

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
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

class ConstructBTFromInorderAndPostorder {
    HashMap<Integer,Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTreeUtil(int inorder[], int postorder[], int low, int high)
    {
        //breaking condition
        if(low>high)
            return null;

        //make nodes out of preorder traversal one by one
        //right to left for postorder
        int curr = postorder[index--];
        TreeNode node = new TreeNode(curr);

        //if this doesn't have any left and right children
        if(low==high)
            return node;

        //now find index of the node in the inorder traversal, nodes left to it
        //is its left subtree and to its right are its right subtree
        int inorderIndex= map.get(curr);

        //recur
        //right first then left as postorder
        node.right=buildTreeUtil(inorder,postorder,inorderIndex+1,high);
        node.left=buildTreeUtil(inorder,postorder,low,inorderIndex-1);

        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        index=postorder.length-1;
        return buildTreeUtil(inorder, postorder, 0, inorder.length-1);
    }
}