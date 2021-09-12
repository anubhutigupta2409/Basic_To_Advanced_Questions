

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

/*
BFS is much better here, rather than a DFS approach.

Sure, the solution here is short in terms of lines of code and looks nice, but it's far from optimal.

If you have a tree where say the root's left subtree has a depth of 500 and the right subtree has a depth of 1, the code is going to traverse all the way down the 500 left subtree first before finally traversing the right subtree with a measly depth of 1 and figuring out "d'oh!" that's the min depth.

With BFS, instead of traversing 501 nodes to figure out the min depth, you could've just traversed two. Now imagine if the left subtree comprised of tens of thousands of nodes ...
*/
class MinDepthBFS {
    public int minDepth(TreeNode root) {

        //bfs
        if(root==null)
            return 0;


        Queue<TreeNode> helper = new LinkedList<>();

        helper.add(root);

        int level = 1;

        while(!helper.isEmpty())
        {
            int count = helper.size();

            while(count-->0)
            {
                TreeNode temp = helper.poll();

                if(temp.left==null && temp.right==null)
                    return level;

                if(temp.left!=null)
                    helper.add(temp.left);

                if(temp.right!=null)
                    helper.add(temp.right);

            }
            level++;
        }

        return level;

    }
}