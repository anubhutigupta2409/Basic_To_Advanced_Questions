/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked 
list representation of the addition of two input numbers.

First List is 7 5 9 4 6 
Second List is 8 4 
Resultant list is 5 0 0 5 6 

//considering the demand of the question

//this approach-->

which is for linked lists where a least significant digit is the first node of lists and the most significant digit is the 
last node. In this problem, the most significant node is the first node and the least significant digit is the last node and
we are not allowed to modify the lists.
*/

class AddTwoNumbersLeftMostLeastSignificant{
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node temp=null, head=null, prev=null;//for the sum list
        int sum, carry=0;
        while(first!=null || second!=null)
        {
            //calculating sum
            sum=carry + (first!=null ? first.data : 0 ) + (second!=null ? second.data : 0 );
            
            //updating carry's value
            carry = (sum>=10 ? 1 : 0);
            
            //updating sum's value if it's greater than 10
            sum%=10;
            
            //making a new node
            temp = new Node(sum);
            
            //if this was first value
            if(head==null)
                head=temp;
            
            //else link
            else
                prev.next=temp;
            
            //for next iteration
            prev=temp;
            
            //for next iterations
            if(first!=null)
                first=first.next;
            
            if(second!=null)
                second=second.next;
        }
        
        //for that last digit
        if(carry>0)
            temp.next = new Node(carry);
            
        //returning the head of the sum list
        return head;
    }
}