/*
do reverse inorder traversal and while traversing set the next of the current node as the node you previously visited (which
actually is successor in the proper inorder traversal)
*/
class PopulateNext2
{
    static Node next=null;
    public static void populateNext(Node node)
    {
        //Add your code here.
        if (node != null)
        {
            // First set the next pointer in right subtree
            populateNext(node.right);

            // Set the next as previously visited node in reverse Inorder
            node.next = next;

            // Change the prev for subsequent node
            next = node;

            // Finally, set the next pointer in left subtree
            populateNext(node.left);
        }
    }
}