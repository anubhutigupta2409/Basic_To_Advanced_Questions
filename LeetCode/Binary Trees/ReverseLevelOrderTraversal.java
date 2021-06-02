/*
Binary Tree Level Order Traversal II
Medium

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right,
level by level from leaf to root).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
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
class ReverseLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(root==null)
            return res;

        Queue<TreeNode> help= new LinkedList<>();

        help.add(root);

        while(!help.isEmpty())
        {
            List<Integer> level= new ArrayList<>();
            int count=help.size();

            while(count-->0)
            {
                TreeNode temp= help.poll();
                level.add(temp.val);

                if(temp.left!=null)
                    help.add(temp.left);

                if(temp.right!=null)
                    help.add(temp.right);
            }
            res.add(0,level);//always add at 0th position therefore bottom-up LOT
        }

        return res;

    }
}