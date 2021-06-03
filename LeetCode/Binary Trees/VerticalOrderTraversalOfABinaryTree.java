/*

Vertical Order Traversal of a Binary Tree
Hard

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.


Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
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

//class to maintain all the values we need for a treenode to traverse it vertically
class TreeData
{
    int vLevel;//vertical line number
    int hLevel;//nodes having same vLevel, are stored on the basis of their horizontal level
    TreeNode node;//nodes having same vertical and horizontal level are stored on the basis
    //of their data

    public TreeData(int vLevel, int hLevel, TreeNode node)
    {
        this.vLevel = vLevel;
        this.hLevel = hLevel;
        this.node = node;
    }
}
class VerticalOrderTraversalOfABinaryTree{
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        //our result list
        List<List<Integer>> res = new ArrayList<>();

        //if null return empty list
        if(root==null)
            return res;

        //making a map of map
        //key value pair is as follows-->
        //<vLevel, map(<hLevel , list of nodes in ascending order>)>
        //for this ascending order we are using a priorityQueue over here

    HashMap<Integer, LinkedHashMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();

        //marking the first vertical line and the last vertical line
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        //traversing using a queue
        Queue<TreeData> q = new LinkedList<>();

        //here for a root vertical and horizontal level both are zero
        q.add(new TreeData(0,0,root));

        while(!q.isEmpty())
        {
            //dealing with the current node
            TreeData curr = q.poll();

            //storing values, for our ease
            int currV = curr.vLevel;
            int currH = curr.hLevel;

            //updating values if necessary
            minLevel = Math.min(minLevel,currV);
            maxLevel = Math.max(maxLevel,currV);

            //if the current vertical line doesn't exist, make an entry
            if(!map.containsKey(currV))
                map.put(currV, new LinkedHashMap<>());

            //if the already existing vertical line is not related to the current horizontal
            //level, make an entry
            if(!map.get(currV).containsKey(currH))
                map.get(currV).put(currH, new PriorityQueue<>());

            //if both, current vertical and current horizontal level exists then add node
            map.get(currV).get(currH).add(curr.node.val);

            //now traversing the rest of the tree

            //for left child, vertical line decreases by 1 compared to root node
            //for right child, vertical line increases by 1 compared to root node
            //but horizontal level always increases as you reach the children

            if(curr.node.left!=null)
                q.add(new TreeData(currV-1, currH+1, curr.node.left));

            if(curr.node.right!=null)
                q.add(new TreeData(currV+1, currH+1, curr.node.right));
        }

        //now storing the required answers
        for(int i=minLevel;i<=maxLevel;i++)
        {
            ArrayList<Integer> currV= new ArrayList<>();

            for(int currH : map.get(i).keySet())
            {
                PriorityQueue<Integer> nodes = map.get(i).get(currH);

                while(!nodes.isEmpty())
                    currV.add(nodes.poll());
            }

            res.add(currV);
        }

        return res;
    }
}