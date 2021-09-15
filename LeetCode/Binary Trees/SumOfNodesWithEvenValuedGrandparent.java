/*
Sum of Nodes with Even-Valued Grandparent
Medium

Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.



Example 1:


Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
Example 2:


Input: root = [1]
Output: 0


Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
*/

class SumOfNodesWithEvenValuedGrandparent {
    private int util(TreeNode curr, TreeNode parent, TreeNode grandparent)
    {
        if(curr==null)
            return 0;

        int sum = 0;

        if(grandparent!=null && grandparent.val % 2 == 0)
            sum += ((grandparent.val&1)==0 ? curr.val : 0);

        sum += util(curr.left,curr,parent) + util(curr.right,curr,parent);

        return sum;
    }
    public int sumEvenGrandparent(TreeNode root) {


        return util(root,null,null);
    }
}