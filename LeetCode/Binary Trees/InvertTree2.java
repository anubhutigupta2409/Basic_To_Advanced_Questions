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
class InvertTree2 {
    public TreeNode invertTree(TreeNode root) {

        if(root==null)
            return root;
        //approach-2 --->
        //changing the original tree
        TreeNode temp= root.left;
        root.left = root.right;
        root.right = temp;

        //now repeating in subtree
        invertTree(root.left);

        invertTree(root.right);

        return root;

    }
}