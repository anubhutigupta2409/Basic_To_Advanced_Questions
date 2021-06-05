/*
Find Duplicate Subtrees
Medium

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.



Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]


Constraints:

The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200
*/

class AllDuplicateSubtrees {
    HashMap<String, Integer> map= new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    String util(TreeNode root)
    {
        if(root==null)
            return "$";//delimiter

        //here leaf nodes are also counted

        String left= util(root.left);
        //null is not counted as a subtree
        if(!left.equals("$"))
        {
            //if it exists in the map then add in result
            if(map.getOrDefault(left,0)==1)
                res.add(root.left);
            //increase the count
            map.put(left,map.getOrDefault(left,0)+1);
        }

        String right= util(root.right);
        if(!right.equals("$"))
        {
            if(map.getOrDefault(right,0)==1)
                res.add(root.right);
            map.put(right,map.getOrDefault(right,0)+1);
        }

        //return string
        //we need to distinguish between left root and right ,as combined they can be same
        //for different subtrees
        return "l=[" + left + "],root=[" + root.val  +"],r=["+ right + "]";
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        String s= util(root);
        return res;
    }
}