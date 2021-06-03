/*

ZigZag Tree Traversal

Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.



Example 1:

Input:
        3
      /   \
     2     1
Output:
3 1 2
Example 2:

Input:
           7
        /     \
       9       7
     /  \     /
    8    8   6
   /  \
  10   9
Output:
7 7 9 8 8 6 9 10


Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.



Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).



Constraints:
1 <= N <= 104




*/

class ZigZagTreeTraversal
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> res = new ArrayList<>();

	    if(root==null)
	        return res;

	    boolean flag= true;//if it's true we print the level order traversal
	    //from left->right, if it's false we print level order traversal
	    //right->left

	    Queue<Node> q= new LinkedList<>();

	    q.add(root);

	    while(!q.isEmpty())
	    {
	        int count = q.size();
	        ArrayList<Integer> temp = new ArrayList<>();

	        while(count-- >0)
	        {
	            Node curr= q.poll();
	            temp.add(curr.data);

	            if(curr.left!=null)
	                q.add(curr.left);

	            if(curr.right!=null)
	                q.add(curr.right);

	        }
	        if(flag)
	            res.addAll(temp);
	        else
	        {
	            Collections.reverse(temp);
	            res.addAll(temp);
	        }

	        flag = !flag;
	    }

	    return res;
	}
}