/*
Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \
 3     2
Output:1 3 2

Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:10 20 30 40 60 N N

Your Task:
You don't have to take any input. Complete the function levelOrder() that takes the root node as input parameter and returns a
list of integers containing the level order traversal of the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= Number of nodes<= 104
1 <= Data of a node <= 104

*/
class Level_order_traversal
{
    //You are required to complete this method
    static ArrayList <Integer> levelOrder(Node node)
    {
        // Your code here
        ArrayList<Integer> result=new ArrayList<Integer> ();
        Queue<Node> help= new LinkedList<Node>();
        help.add(node);
        while(!help.isEmpty())
        {
            Node temp= help.poll();
            result.add(temp.data);

            if(temp.left!=null)
                help.add(temp.left);
            if(temp.right!=null)
                help.add(temp.right);
        }
        return result;
    }
}