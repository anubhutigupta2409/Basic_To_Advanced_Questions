/*
Find Bottom Left Tree Value
Medium

Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

class BottomLeftTreeValue{
   
    public int findBottomLeftValue(TreeNode root) {
        
        if(root==null)
            return -1;
        
        int res = -1;
        
        Queue<TreeNode> util = new LinkedList<>();
        
        util.add(root);
        
        while(!util.isEmpty())
        {
            int count = util.size();
            
            for(int i=0;i<count;i++)
            {
                TreeNode temp = util.poll();
                
                if(i==0)
                    res = temp.val;
                
                if(temp.left!=null)
                    util.add(temp.left);
                if(temp.right!=null)
                    util.add(temp.right);
                
           
            }
        }
        
        return res;
        
    }
}