/*
Linked List in Binary Tree
Medium

Given a binary tree root and a linked list with head as the first node.

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.



Example 1:



Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.
Example 2:



Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:

Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.


Constraints:

The number of nodes in the tree will be in the range [1, 2500].
The number of nodes in the list will be in the range [1, 100].
1 <= Node.val <= 100 for each node in the linked list and binary tree.
*/

class LinkedListDownwardInBT {
    //util function to if path exists
    private boolean searchPath(ListNode head, TreeNode root)
    {
        //reached tree's end, check for list's
        if(root == null)
            return head == null;

        //reached list's end, true
        if(head==null)
            return true;

        //values not same return false
        if(head.val != root.val)
            return false;

        return searchPath(head.next, root.left) || searchPath(head.next, root.right);

    }

    public boolean isSubPath(ListNode head, TreeNode root) {


        if(root==null)
            return false;

        //if head's match find
        if(head.val == root.val)
            if(searchPath(head,root))
                return true;

        //not found, further search
        return isSubPath(head,root.left) || isSubPath(head,root.right);

    }
}