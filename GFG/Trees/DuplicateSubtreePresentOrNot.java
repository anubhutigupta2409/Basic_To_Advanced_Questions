/*
Duplicate subtree in Binary Tree
Medium
Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

Example 1 :

Input :
               1
             /   \
           2       3
         /   \       \
        4     5       2
                     /  \
                    4    5

Output : 1
Explanation :
    2
  /   \
 4     5
is the duplicate sub-tree.


Example 2 :

Input :
               1
             /   \
           2       3

Output: 0
Explanation: There is no duplicate sub-tree
in the given binary tree.


Your Task:
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only arguement and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.

Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.


Constraints:
1<=length of string<=100

*/
class DuplicateSubtreePresentOrNot
{
    //<subtree values converted to string, frequency of that subtree>
    HashMap<String, Integer> map = new HashMap<>();

    String dupSubUtil(Node root)
    {
        if(root==null)
            return "$";//delimeter

        /*
        Why delimtere required??

            2
           / \
          4   5

          and

          2
           \
            4
             \
              5

         will return same string, therefore we need to distinguish
        */

        //if leaf node then don't put in map
        if(root.left==null && root.right==null)
            return String.valueOf(root.data);

        String s= "";

        //concatenate the returned strings in case of other nodes
        s+=String.valueOf(root.data);
        s+=dupSubUtil(root.left);
        s+=dupSubUtil(root.right);

        //put each subtree in a map
        if(!map.containsKey(s))
            map.put(s,1);
        else
            map.put(s,map.get(s)+1);

        return s;
    }
    int dupSub(Node root) {
        // code here
        String s= dupSubUtil(root);

        //checking
        for(String key : map.keySet())
        {
            if(map.get(key)>=2)
                return 1;
        }
        return 0;
    }
}