/*

Binary Tree Zigzag Level Order Traversal
Medium

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
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
class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root==null)
            return res;

        Queue<TreeNode> q= new LinkedList<>();

        q.add(root);

        boolean flag = true;

        while(!q.isEmpty())
        {
            int count = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            while(count-->0)
            {
                TreeNode curr= q.poll();
                temp.add(curr.val);

                if(curr.left!=null)
                    q.add(curr.left);

                if(curr.right!=null)
                    q.add(curr.right);

            }
            if(flag)
                res.add(temp);
            else
            {
                Collections.reverse(temp);
                res.add(temp);
            }
            flag= !flag;
        }

        return res;

    }
}