/*
Write a function findFirstLoopNode() that checks whether a given Linked List contains a loop. If the loop is present then it
returns point to the first node of the loop. Else it returns NULL.
*/

/*
approach--> perform floyd's cycle algorithm to detect the loop, if not found return null else-->
1. set the byOne pointer equal to head and let the byTwo pointer be at it's position only
2. now start making the pointers shift one node further ,the point at which they are equal is the starting of the node
3. return the pointer
*/

class StartingPointOfLoop
{
	Node findFirstLoopNode(Node head)
	{
		Node byOne = head, byTwo= head;
		while(byOne!=null && byTwo!=null && byTwo.next!=null)
		{
			byOne=byOne.next;
			byTwo=byTwo.next.next;
			
			if(byOne==byTwo)
				break;
		}
		if(byOne!=byTwo)
			return null;
		byOne = head;
		while(byOne!=byTwo)
		{
			byOne=byOne.next;
			byTwo=byTwo.next;
		}
		return byOne;
	}
}
