/*

Clone a linked list with next and random pointer
Hard
You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers , where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.

ArbitLinked List1

Example 1:

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output: 1
Explanation: In this test case, there
re 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbit pointer
set, rest two nodes have arbit pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbit pointer is set to
node 2.  The second node arbit pointer
is set to node 4.
Example 2:

Input:
N = 4, M = 2
value[] = {1,3,5,9}
pairs[] = {{1,1},{3,4}}
Output: 1
Explanation: In the given testcase ,
applying the method as stated in the
above example, the output will be 1.
Your Task:
The task is to complete the function copyList() which takes one argument the head of the linked list to be cloned and should
return the head of the cloned linked list.
NOTE : If their is any node whose arbitrary pointer is not given then its by default null.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 100
1 <= M <= N
1 <= a, b <= 100
*/
/*
cloning a normal singly linked list is fine, but the problem arises when we have to link the randome nodes, since we cannot link
our nodes to some random node which we haven't clone yet, as in one iteration we can move further by adding or linking the nexts of the
nodes, but how do we get access to it back, in order to link the random nodes.

one solution is using a hash map, where we can add the newly created cloned nodes to the hash map, and we can access them in
constant time and then we can link the random nodes, but this takes O(n) time, so we need some solution in constant space

therefore, we use the next of the curr node of the original list to store the cloned node.
that is, curr.next = new Node(curr.data);
before this we store the next value somewhere, temp=curr.next;
then link the next of the cloned node as the original list's curr node's next, but how to we acces the cloned node?, remember we
stored it in the next of the original list's curr node,
so,
curr.next.next=next;

then link the random pointers, if they exist

separate the lists.

That's it :)
*/
class CloneLLWithNextAndRandomPointer{
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node start) {
        // your code here
        if(start==null)
            return start;

        Node curr = start, temp = null;

    // insert additional node after
    // every node of original list
    while (curr != null)
    {
        temp = curr.next;

        // Inserting node
        curr.next = new Node(curr.data);
        curr.next.next = temp;
        curr = temp;
    }
    curr = start;

    // adjust the random pointers of the
    // newly added nodes
    while (curr != null)
    {
        if(curr.next != null)
            curr.next.arb = (curr.arb != null)
                      ? curr.arb.next : curr.arb;

        // move to the next newly added node by
        // skipping an original node
        curr = (curr.next != null) ? curr.next.next
                                        : curr.next;
    }

    Node original = start, copy = start.next;

    // save the start of copied linked list
    temp = copy;

    // now separate the original list and copied list
    while (original != null && copy != null)
    {
        original.next = (original.next != null)?
                    original.next.next : original.next;

        copy.next = (copy.next != null) ? copy.next.next
                                            : copy.next;
        original = original.next;
        copy = copy.next;
    }
    return temp;
    }
}

