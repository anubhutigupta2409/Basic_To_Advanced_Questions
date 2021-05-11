public class DeletionInCircularLL
{
	public Node delNode(Node head, int key)
	{
		if(head==null)
			return null;

		Node curr=head, prev=null;

		while(curr.data!=key)
		{
			if(curr.next==head)
			{
				System.out.println("Key not present");
				return head;
			}
			prev=curr;
			curr=curr.next;
		}

		//only one node present
		if(curr==head && curr.next==head)
		{
			head=null;
			return head;
		}

		//head is to be deleted
		if(curr==head)
		{
			prev=head;
			while(prev.next!=head)
				prev=prev.next;

			head=curr.next;
			prev.next=head;
		}

		//last element is to be deleted
		else if(curr.next==head)
			prev.next=head;

		//somewhere in between
		else
			prev.next=curr.next;

		return head;
	}
}