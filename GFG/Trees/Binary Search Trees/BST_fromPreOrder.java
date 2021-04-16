/*
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be the root of the following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50

*/

/*
Approach->
For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater
than 10, we find 40. So we know the structure of BST is as following.

             10
           /    \
          /      \
  {5, 1, 7}       {40, 50}
We recursively follow above steps for subarrays {5, 1, 7} and {40, 50}, and get the complete tree.
*/

class Node {
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BST_fromPreOrder {
    private static Node node;

    // This will create the BST
    public static Node createNode(Node node, int data)
    {
        if (node == null)
            node = new Node(data);

        if (node.data > data)
            node.left = createNode(node.left, data);
        if (node.data < data)
            node.right = createNode(node.right, data);

        return node;
    }

    // A wrapper function of createNode
    public static void create(int data)
    {
        node = createNode(node, data);
    }
    // A function to print BST in inorder
    public static void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] nodeData = { 10, 5, 1, 7, 40, 50 };

        for (int i = 0; i < nodeData.length; i++) {
            create(nodeData[i]);
        }
        inorderRec(node);
    }
}