/*
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/

class MaxDepthBFS {
    public int maxDepth(TreeNode root) {

        //bfs
        if(root==null)
            return 0;

        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

        Queue<TreeNode> helper = new LinkedList<>();

        helper.add(root);

        while(!helper.isEmpty())
        {
            int count = helper.size();
            List<Integer> level = new ArrayList<>();

            while(count-->0)
            {
                TreeNode temp = helper.poll();
                level.add(temp.val);

                if(temp.left!=null)
                    helper.add(temp.left);

                if(temp.right!=null)
                    helper.add(temp.right);
            }

            levelOrder.add(level);
        }

        return levelOrder.size();

    }
}