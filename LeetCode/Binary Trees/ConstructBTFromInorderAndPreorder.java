/*
Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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

    
    
class ConstructBTFromInorderAndPreorder{
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int index=0;
    
    public TreeNode buildTreeUtil(int inorder[], int preorder[], int low, int high)
    {
        //breaking condition
        if(low>high)
            return null;
            
        //make nodes out of preorder traversal one by one
        int curr = preorder[index++];
        TreeNode node = new TreeNode(curr);
        
        //if this doesn't have any left and right children
        if(low==high)
            return node;
            
        //now find index of the node in the inorder traversal, nodes left to it
        //is its left subtree and to its right are its right subtree
        int inorderIndex= map.get(curr);
        
        //recur
        node.left=buildTreeUtil(inorder,preorder,low,inorderIndex-1);
        node.right=buildTreeUtil(inorder,preorder,inorderIndex+1,high);
    
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return buildTreeUtil(inorder, preorder, 0, inorder.length-1);
    }
}