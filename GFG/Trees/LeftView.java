/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1

       /     \
     2        3

  /     \   /    \

  4     5   6    7

   \
     8

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000

Company Tags
*/
class LeftView
{
	   //left view of a tree is basically the left-most node of a tree
	    ArrayList<Integer> leftView(Node root)
	    {
	      // Your code here

	      ArrayList<Integer> res= new ArrayList<Integer>();

	      if(root!=null)
	      {
	      //Queue
	      Queue<Node> q = new LinkedList<Node>();
	      q.add(root);

	      while(!q.isEmpty())
	      {
	         int n= q.size();//number of nodes on the current level

	         //transfer all the nodes and just print the leftmost
	         for(int i=1;i<=n;i++)
	         {
	            Node temp = q.poll();
	            if(i==1)
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