/*

Given a singly linked list which represents a number where each node contains only one digit [0 – 9]. The task is to add 1 to 
the number represented by the given linked list and print the new linked list.

Examples:

Input: 1 -> 2 -> 9 -> 9 -> NULL
Output:
Original list is : 1 2 9 9
Resultant list is : 1 3 0 0

Input: 9 -> 9 -> 9 -> 9 -> NULL
Output:
Original list is : 9 9 9 9
Resultant list is : 1 0 0 0 0

*/

class AddOneWithCarry
{
    
    public static Node addOne(Node head) 
    { 
        //code here.
        Node curr=head;//current node
        Node last = null;//node which is the last node and after which all the 
        //other nodes have value == 9
        
        while(curr.next!=null)
        {
            if(curr.data!=9)
                last=curr;
            curr=curr.next;
        }
        //if we reached the end and the node's data != 9
        //increment by 1 and return head
        if(curr.data!=9)
        {
            curr.data+=1;
            return head;
        }
        //means there's no node after which all are 9's 
        //beacuse the list is of the format 9->9->9->..
        if(last==null)
        {
            last = new Node(0);
            last.data=0;
            last.next=head;
            head=last;
        }
        // For cases when the righmost node which 
        // is not equal to 9 is not the last 
        // node in the linked list 
        last.data+=1;
        last=last.next;
        
        //making the rest nodes ==0
        while(last!=null)
        {
            last.data=0;
            last=last.next;
        }
        return head;
    }
}
