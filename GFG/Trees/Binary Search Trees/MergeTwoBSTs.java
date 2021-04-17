/*
You are given two balanced binary search trees e.g., AVL or Red Black Tree. Write a function that merges the two given balanced
BSTs into a balanced binary search tree. Let there be m elements in first tree and n elements in the other tree. Your merge
function should take O(m+n) time.
*/

/*
Approach-->
1.do inorder traversal of both the BSTs given
2.we get sorted arrays from the above
3.merge the sorted arrays into another sorted array
4.convert into a balanced bst
*/
import java.util.*;

public class MergeTwoBSTs
{

	ArrayList<Integer> storeInorderHelper(Node node, ArrayList<Integer> list)
	{
		if(node==null)
			return list;

		if(node.left!=null)
			list = storeInorderHelper(node.left,list);

		list.add(node.data);

		if(node.right!=null)
			list = storeInorderHelper(node.right,list);

		return list;
	}
	ArrayList<Integer> storeInorder(Node node)
	{
		ArrayList<Integer> listHelper = new ArrayList<>();

		ArrayList<Integer> list = storeInorderHelper(listHelper,node);

		return list;
	}

	ArrayList<Integer> merge(ArrayList<Integer> list1,ArrayList<Integer> list2,int m,int n)
	{
		ArrayList<Integer> list3 = new ArrayList<>();

		int i=0;
		intj=0;

		while(i<m && j<n)
		{
			if(list1.get(i)<list2.get(i))
			{
				list3.add(list1.get(i));
				i++;
			}
			else
			{
				list3.add(list2.get(i));
				j++;
			}
		}

		while(i<m)
		{
			list3.add(list1.get(i));
			i++;
		}
		while(j<n)
		{
			list3.add(list2.get(j));
			j++;
		}
		return list3;
	}
	Node buildTree(ArrayList<Integer> list,int start,int end)
	{
		if(start>end)
			return null;

		int mid=(start+end)/2;

		Node node = new Node(list.get(mid));

		node.left=buildTree(list,start,mid-1);
		node.right=buildTree(list,mid+1,end);

		return node;
	}
	Node mergeTrees(Node node1, Node node2)
	{
		ArrayList<Integer> list1 = storeInorder(node1);

		ArrayList<Integer> list2 = storeInorder(node2);

		ArrayList<Integer> list3 = merge(list1,list2,list1.size().list.size());

		return buildTree(list3,0,list3.size()-1);
	}
}