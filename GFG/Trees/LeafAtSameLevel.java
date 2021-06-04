/*
Leaf at same level

Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input:
            1
          /   \
         2     3

Output: 1

Explanation:
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.

Your Task:
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns
true/false depending on whether all the leaf nodes are at the same level or not.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 = N = 10^3


*/
class LeafAtSameLevel
{
    boolean flag=true;
    int leafLevel=-1;

    void checkUtil(Node root, int level)
    {
        if(root==null)
            return;
        if(flag==false)
            return ;

        if(root.left==null && root.right==null)
        {
            if(leafLevel==-1)
                leafLevel=level;
            else
                if(leafLevel!=level)
                    flag=false;

            return;

        }
        checkUtil(root.left, level+1);
        checkUtil(root.right,level+1);
    }
    boolean check(Node root)
    {
	// Your code here
	    if(root==null)
	        return true;

	    checkUtil(root,0);
	    return flag;
    }
}
