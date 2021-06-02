/*
Binary Tree Level Order Traversal
Medium


Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level)
.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
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
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root==null)
            return res;

        Queue<TreeNode> help= new LinkedList<>();

        help.add(root);

        while(!help.isEmpty())
        {
            int count=help.size();
            List<Integer> level= new ArrayList<>();

            while(count-->0)
            {
                TreeNode temp= help.poll();
                level.add(temp.val);

                if(temp.left!=null)
                    help.add(temp.left);

                if(temp.right!=null)
                    help.add(temp.right);
            }
            res.add(level);
        }
        return res;
     }
}