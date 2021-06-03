/*

Vertical Traversal of Binary Tree
Medium
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
           1
         /   \
       2       3
     /   \   /   \
   4      5 6      7
              \      \
               8      9
Output:
4 2 1 5 6 3 8 7 9
Explanation:

Example 2:

Input:
       1
    /    \
   2       3
 /    \      \
4      5      6
Output: 4 2 1 5 3 6
Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input parameter and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 5000


*/
class TreeData
{
    int vLevel;//vertical line number
    int hLevel;//nodes having same vLevel, are stored on the basis of their horizontal level
    Node node;//nodes having same vertical and horizontal level are stored on the basis
    //of their level order traversal

    public TreeData(int vLevel, int hLevel, Node node)
    {
        this.vLevel = vLevel;
        this.hLevel = hLevel;
        this.node = node;
    }
}

class VerticalTraversalOfBinaryTree
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();

        //if null return empty list
        if(root==null)
            return res;

        //making a map of map
        //key value pair is as follows-->
        //<vLevel, map(<hLevel , list of nodes in ascending order>)>
        //for this ascending order we are using a priorityQueue over here

    HashMap<Integer, LinkedHashMap<Integer, Queue<Integer>>> map = new HashMap<>();

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
                map.get(currV).put(currH, new LinkedList<>());

            //if both, current vertical and current horizontal level exists then add node
            map.get(currV).get(currH).add(curr.node.data);

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


            for(int currH : map.get(i).keySet())
            {
                Queue<Integer> nodes = map.get(i).get(currH);

                while(!nodes.isEmpty())
                    res.add(nodes.poll());
            }


        }

        return res;
    }
}