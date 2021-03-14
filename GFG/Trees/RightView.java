/*
Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60
Output: 10 30 60
Your Task:
Just complete the function rightView() that takes node as parameter and returns the right view as a list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105.



*/

class RightView
{
   //right view of a tree is the rightmost node of each level
    ArrayList<Integer> rightView(Node node) {
        //add code here.

        ArrayList<Integer> res=new ArrayList<>();
        if(node!=null)
        {
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty())
            {
                int n= q.size();
                for(int i=1;i<=n;i++)
                {
                    Node temp= q.poll();
                    if(i==n)
                        res.add(temp.data);

                    if(temp.left!=null)
                        q.add(temp.left);

                    if(temp.right!=null)
                        q.add(temp.right);
                }
            }
        }
        return res;
    }
}