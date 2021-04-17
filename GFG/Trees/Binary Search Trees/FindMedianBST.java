/*
Find median of BST in O(n) time and O(1) space
Difficulty Level : Hard

Given a Binary Search Tree, find median of it.

Given BST(with odd no. of nodes) is :
                    6
                 /    \
                3       8
              /   \    /  \
             1     4  7    9

Inorder of Given BST will be : 1, 3, 4, 6, 7, 8, 9
So, here median will 6.

Given BST(with even no. of nodes) is :
                    6
                 /    \
                3       8
              /   \    /
             1     4  7

Inorder of Given BST will be : 1, 3, 4, 6, 7, 8
So, here median will  (4+6)/2 = 5.
*/

public class FindMedianBST
{
	//finding count using morris travel
	int count(Node root)
	{
		if(root==null)
			return 0;

		int count=0;

		Node curr, pre;

		curr=root;
		while(curr!=null)
		{
			if(curr.left==null)
			{
				count++;
				curr=curr.right;
			}

			else
			{
				pre = curr.left;
				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;

				if(pre.right==null)
				{
					pre.right=curr;
					curr=curr.left;
				}
				else
				{
					count++;
					pre.right=null;
					curr=curr.right;
				}
			}
		}
		return count;

	}

	//finding median using morris travel
	int findMedian(Node root)
	{
		if(root==null)
			return -1;

		int n = count(root);
		int currCount = 0;

		int ans;

		Node curr=root,pre=null,prev=null;

		while(curr!=null)
		{
			if(curr.left==null)
			{
				currCount++;

				//odd
				if((n&1)!=0 && currCount==(n+1)/2)
					return prev.data;

				//even
				else if((n&1)==0 && currCount==(n/2)+1)
					return prev.data+curr.data;

				prev=curr;
				curr=curr.right;
			}

			else
			{
				pre=curr.left;

				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;

				if(pre.right==null)
				{
					pre.right=curr;
					curr=curr.left;
				}
				else
				{
					pre.right=null;

					prev=pre;

					currCount++;
					//odd
					if((n&1)!=0 && currCount==(n+1)/2)
						return curr.data;

					//even
					else if((n&1)==0 && currCount==(n/2)+1)
						return prev.data+curr.data;

					prev=curr;
					curr=curr.right;

				}
			}
		}

		return -1;
	}
}