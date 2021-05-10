/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the new list.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(Max(N,M))

Constraints:
1 <= N, M <= 5000
*/

/*
Approach-->
1/count number of nodes in both the lists
2.add required number of zeroes in the shorter list
3. reverse both the lists
4.add the reverse lists as leftmost is the least significant
5.reverse the answer and return it
*/
class AddTwoNumbersRightMostLeastSignificant{
    //Function to add two numbers represented by linked list.
    static int count (Node head)
    {
        int count=0;
        while(head!=null)
        {
            head=head.next;
            count++;
        }
        return count;
    }
    static Node push(Node head, int data)
    {
        Node node = new Node(data);
        if(head!=null)
            node.next = head;

        head = node;
        return head;
    }
    static Node reverse(Node head)
    {
        Node curr=head, prev=null, next=null;

        while(curr!=null)
        {
            next = curr.next;

            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        int count1 = count(first);
        int count2 = count(second);

        if(count1> count2)
        {
            for(int i=0;i<count1-count2;i++)
                second = push(second,0);
        }
        else if(count1< count2)
        {
            for(int i=0;i<count2-count1;i++)
                first = push(first,0);
        }

        first = reverse(first);
        second = reverse(second);

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

        return reverse(head);
    }
}