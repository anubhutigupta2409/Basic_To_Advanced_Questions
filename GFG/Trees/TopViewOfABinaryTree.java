/*
Top View of Binary Tree
Medium
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right. Print endline after end of printing the top view.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 = N = 105
1 = Node Data = 105


Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

class TreeData
{
    int vLevel;
    Node node;
    public TreeData(int vLevel, Node node)
    {
        this.vLevel= vLevel;
        this.node = node;
    }
}
class TopViewOfABinaryTree
{
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> res = new ArrayList<>();

        if(root==null)
            return res;

        HashMap<Integer,Integer> map = new HashMap<>();
        //<vertical level, node.data>

        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        Queue<TreeData> q = new LinkedList<>();

        q.add(new TreeData(0,root));

        while(!q.isEmpty())
        {
            TreeData curr= q.poll();
            int currV= curr.vLevel;

            minLevel=Math.min(currV,minLevel);
            maxLevel=Math.max(currV,maxLevel);

            if(!map.containsKey(currV))
                map.put(currV,curr.node.data);//just add the first node of a vertical level

            if(curr.node.left!=null)
                q.add(new TreeData(currV-1,curr.node.left));

            if(curr.node.right!=null)
                q.add(new TreeData(currV+1,curr.node.right));
        }

        for(int i=minLevel;i<=maxLevel;i++)
            res.add(map.get(i));

        return res;

    }
}
