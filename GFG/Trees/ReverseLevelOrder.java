/*
Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.

Example 1:

Input :
        1
      /   \
     3     2

Output: 3 2 1
Explanation:
Traversing level 1 : 3 2
Traversing level 0 : 1
Example 2:

Input :
       10
      /  \
     20   30
    / \
   40  60

Output: 40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10

Your Task:
You dont need to read input or print anything. Complete the function reverseLevelOrder() which takes the root of the tree as
input parameter and returns a list containing the reverse level order traversal of the given tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 = N = 10^4

*/
class ReverseLevelOrder
{
    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        // code here
        ArrayList<Integer> result= new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty())
        {
            Node temp= q.poll();
            s.push(temp);
            if(temp.right!=null)
                q.add(temp.right);
            if(temp.left!=null)
                q.add(temp.left);
        }
        while(!s.empty())
            result.add(s.pop().data);

        return result;
    }
}