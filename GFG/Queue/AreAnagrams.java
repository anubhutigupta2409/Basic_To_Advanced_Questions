/*
Check if all levels of two trees are anagrams or not
Difficulty Level : Medium

Given two binary trees, we have to check if each of their levels are anagrams of each other or not.

Example:


Tree 1:
Level 0 : 1
Level 1 : 3, 2
Level 2 : 5, 4

Tree 2:
Level 0 : 1
Level 1 : 2, 3
Level 2 : 4, 5
As we can clearly see all the levels of above two binary trees are anagrams of each other, hence return true.
*/

/*
Approach-->
We traverse both trees simultaneously level by level. We store each level both trees in vectors (or array). To check if two
vectors are anagram or not, we sort both and then compare.

Time Complexity: O(n), where n is the number of nodes.
*/

public class AreAnagrams
{
	public boolean areAnagrams(Node root1, Node root2)
	{
		if(root1==null && root2==null)
			return true;

		if(root1==null || root2==null)
			return false;

		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		q1.add(root1);
		q2.add(root2);

		while(true)
		{
			int n1=q1.size(), n2=q2.size();

			if(n1 != n2)
				return false

			if(n1 == 0)
				break;

			ArrayList<Integer> currLevel1 = new ArrayList<Integer>();
			ArrayList<Integer> currLevel2 = new ArrayList<Integer>();

			while(n1>0)
			{
				Node node1 = q1.poll();

				if(node1.left!=null)
					q1.add(node1.left);

				if(node1.right!=null)
					q1.add(node1.right);
				n1--;

				Node node2 = q2.poll();

				if(node2.left!=null)
					q1.add(node1.left);

				if(node2.right!=null)
					q1.add(node1.right);

				currLevel1.add(node1.data);
				currLevel2.add(node2.data);
			}

			Collections.sort(currLevel1);
			Collections.sort(currLevel12);

			if(!currLevel1.equals(currLevel2))
				return false;

		}

		return true;
	}
}