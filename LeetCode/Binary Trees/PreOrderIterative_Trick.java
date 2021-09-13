/*
Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [1,2]
Example 5:


Input: root = [1,null,2]
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively
*/

class Pair
{
    TreeNode node;
    int state;

    Pair(TreeNode node, int state)
    {
        this.node = node;
        this.state = state;
    }
}
class PreOrderIterative_Trick{

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root==null)
            return res;

        Stack<Pair> stk = new Stack<>();

        stk.push(new Pair(root,0));

        while(!stk.empty())
        {
            Pair pair = stk.peek();
            TreeNode node = pair.node;
            int state = pair.state;

            if(node==null || state==3)
            {
                stk.pop();
                continue;
            }

            else if(state == 0)
                res.add(node.val);
            else if(state == 1)
                stk.push(new Pair(node.left,0));
            else if(state == 2)
                stk.push(new Pair(node.right,0));

            pair.state+=1;
        }

        return res;

    }
}