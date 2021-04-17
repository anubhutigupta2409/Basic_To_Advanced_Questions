/*

Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.


Example 1:

Input:
      1
    /   \
   2     3
Output: 1 2 3

Example 2:

Input:
          1
       /    \
     2       3
   /
 4
Output: 1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1


Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of
the Binary tree as input and returns the root of the BST. The driver code will print inorder traversal of the converted BST.


Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).


Constraints:
1 <= Number of nodes <= 1000
*/

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */

/*
Approach-->
1.Do the inorder traversal of the binary tree given , and convert it into an array.
2.Sort the resultant array
3.convert the resultant array into a bst, since we did an inorder traversal and also we sorted the array in an ascending order
we should know that the middle element of the range would be the root of the tree, similarly we recursively call the method
in order to build the left(range = start - mid-1) and right(range = mid+1 - end) subtree.
*/
class Convert_BT_BST
{
    int arr[];
    int index=0;

    int countNodes(Node root)
    {
        if(root==null)
            return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //transefering doing the inorder traversal
    void convertArray(Node root)
    {
        if(root==null)
            return;

        if(root.left!=null)
            convertArray(root.left);

        arr[index] = root.data;
        index++;

        if(root.right!=null)
            convertArray(root.right);
    }

    Node createBST(int start, int end)
    {
        if(start>end)
            return null;

        //mid element is the root of our tree
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);

        //constructing left sub-tree
        node.left=createBST(start,mid-1);

        //constructing right sub-tree
        node.right=createBST(mid+1,end);

        return node;
    }
    Node binaryTreeToBST(Node root)
    {
       // Your code here

       if(root==null)
        return root;

       //declaring the array -->
        int count = countNodes(root);
        arr = new int[count];

        //converting binary tree into an array-->
        convertArray(root);

        //sorting the resultant array-->
        Arrays.sort(arr);

        Node node = createBST(0,arr.length-1);

        return node;

    }
}
