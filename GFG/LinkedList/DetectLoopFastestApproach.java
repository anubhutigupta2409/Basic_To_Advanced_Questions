/*
The algorithm which we are going to use over here is called the "Floyd's Cycle-Finding Algorithm", which is the fastest possible
solution to the given problem.
What we do is we traverse the given linked list using two  pointers and keep moving them forward, one moves one step forward after
every iteration and the other moves two steps forward after every iteration and if in any instance both of them are equal means
a loop exists otherwise not.

This algorith is called Tortoise and hare approach where the pointer moving two steps ahead is the fast one and the pointer
that moves one step ahead is the slow one
*/

class DetectLoopFastestApproach {
    public static boolean detectLoop(Node head){
        // Add code here
        Node byOne=head, byTwo=head;
        while(byOne!=null && byTwo!=null && byTwo.next!=null)
        {
            byOne=byOne.next;
            byTwo=byTwo.next.next;
            if(byOne==byTwo)
                return true;
        }
        return false;
    }
}
