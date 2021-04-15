/*

There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, if the either of predecessor or successor is not found print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting the number of edges of the BST. The next line contains the edges of the BST. The last line contains the key.

Output:
Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.

Constraints:
1<=T<=100
1<=n<=100
1<=data of node<=100
1<=key<=100

Example:
Input:
2
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
65
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
100

Output:
60 70
80 -1

*/

/*
When we do the inorder traversal of a tree, the very left node of a particular node is it's inorder predecessor and it's very
right is it's inorder successor.

also iop is the largest element in the left sub-tree,
where as ios is the smallest element in the right sub-tree
*/

class find_IOP_IOS
{


    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here

        // Base case
    if (root == null)
        return;

    // If key is present at root
    if (root.data == key)
    {

        // The maximum value in left
        // subtree is predecessor
        if (root.left != null)
        {
            Node tmp = root.left;
            while (tmp.right != null)
                tmp = tmp.right;

            p.pre = tmp;
        }

        // The minimum value in
        // right subtree is successor
        if (root.right != null)
        {
            Node tmp = root.right;

            while (tmp.left != null)
                tmp = tmp.left;

            s.succ = tmp;
        }
        return;
    }

    // If key is smaller than
    // root's key, go to left subtree
    if (root.data > key)
    {
        s.succ = root;
        findPreSuc(root.left,p,s, key);
    }

    // Go to right subtree
    else
    {
        p.pre = root;
        findPreSuc(root.right,p,s, key);
    }

    }
}