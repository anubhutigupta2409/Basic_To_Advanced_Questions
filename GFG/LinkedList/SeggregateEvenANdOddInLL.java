/*

Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified
list. The order of appearance of numbers within each segregation should be same as that in the original list.


Example 1:

Input:
N = 7
Link List =
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

Explaination: 17,15,8,9 are odd so they appear
first and 2,4,6 are the even numbers that appear later.

Example 2:

Input:
N = 4
Link List = 1 -> 3 -> 5 -> 7

Output: 1 3 5 7

Explaination: There is no even number.
So ne need for modification.

Your Task:
You do not need to read input or print anything. Your task is to complete the function divide() which takes N and head of Link
List as input parameters and returns the head of modified link list.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 = N = 100
1 = arr[i] = 10000
*/

class SeggregateEvenANdOddInLL{
    Node divide(int N, Node head){
        // code here

        if(head==null)
            return null;

        //where e1 and o1 marks the starting of the even and odd lists
        //and e2 and o2 marks the end of the lists
        Node e1 = null, e2= null, o1=null, o2=null;

        Node curr=head;

        while(curr!=null)
        {

            if((curr.data&1)==0)
            {
                if(e1==null)
                {
                    e1=curr;
                    e2=e1;
                }
                else
                {
                    e2.next=curr;
                    e2=e2.next;
                }
            }
            else
            {
                if(o1==null)
                {
                    o1=curr;
                    o2=o1;
                }
                else
                {
                    o2.next=curr;
                    o2=o2.next;
                }
            }

            curr= curr.next;
        }

        //if the list originally didn't contain even or odd numbers
        if(o1==null || e1==null)
            return head;

          //even to be placed before odd
        e2.next=o1;
        //odd at the end
        o2.next=null;

        //even at the very beginning
        head=e1;

        return head;
    }
}