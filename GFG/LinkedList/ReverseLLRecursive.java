class ReverseLLRecursive
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        // code here
        //base case
        if (head == null || head.next == null) 
            return head; 
 
        /* reverse the rest list and put 
        the first element at the end */
        Node rest = reverseList(head.next); 
        head.next.next = head; //linking back
 
        /*as now our head is at the end */
        head.next = null; 
 
        /* fix the head pointer */
        return rest; 
        
    }
}
