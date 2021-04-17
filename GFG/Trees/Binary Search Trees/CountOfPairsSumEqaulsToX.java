/*

Brothers From Different Roots
Easy
Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x. Your task is to complete the function countPairs(), that returns the count of all pairs from both the BSTs whose sum is equal to x.

Examples:

Input : BST 1:    5
                /   \
               3     7
              / \   / \
             2  4  6   8

        BST 2:    10
                /   \
               6     15
              / \   /  \
             3  8  11  18
        x = 16

Output : 3
The pairs are:
(5, 11), (6, 10) and (8, 8)
Input:
The function takes three arguments as input, first the reference pointer to the root(root1) of the BST1, then reference pointer to the root(root2) of the BST2 and last the element X.
There will be T test cases and for each test case the function will be called separately.

Output:
For each test cases print the required number of pairs on new line.

Constraints:
1<=T<=100
1<=N<=103

Example:
Input:
2
7
5 3 7 2 4 6 8
7
10 6 15 3 8 11 18
16
6
10 20 30 40 5 1
5
25 35 10 15 5
30
Output:
3
2
*/

/*
Approach-->
1.traverse the tree1 from smallest to largest(iterative inorder traversal)
2.traverse the tree1 from largest to smallest(reverse iterative inorder traversal)
3.if at any point their sums are equal to sum, increment the count
	3.a)If x > sum, then move to the inorder successor of the current node of BST 1, else move to the inorder predecessor
	of the current node of BST 2.

*/

/*class Node
{
    int data;
    Node left, right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }

}*/
class CountOfPairsSumEqaulsToX
{

    public static int countPairs(Node root1, Node root2, int x)
    {
        // your code here
        if(root1==null || root2==null)
            return 0;

        Stack<Node> st1= new Stack<>();
        Stack<Node> st2= new Stack<>();

        Node top1,top2;

        int count=0;

        while(true)
        {
            //iterating till we get left most
            while(root1!=null)
            {
                st1.push(root1);
                root1=root1.left;
            }
            //iterating till we get right most
            while(root2!=null)
            {
                st2.push(root2);
                root2=root2.right;
            }

            if(st1.empty() || st2.empty())
                break;

            top1=st1.peek();
            top2=st2.peek();

            if((top1.data+top2.data) == x)
            {
				//operation
                count++;

                st1.pop();
                st2.pop();

                //then right for tree1
                root1=top1.right;

                //then left for tree2
                root2=top2.left;
            }


            else if((top1.data+top2.data) < x)
            {
                st1.pop();
                //move to ios
                root1=top1.right;
            }
            else
            {
                st2.pop();
                //move to iop
                root2=top2.left;
            }
        }

        return count;

    }
}