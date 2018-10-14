package LinkedLists;

public class LeetCode2Add {

	// public static Node []head=new Node[2];

	public static Node headNew;
	public static Node[] head = new Node[2];

	public static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
		}
	}

	public static void main(String[] args) {

		LeetCode2Add llist1 = new LeetCode2Add();
		llist1.head[0] = new Node(2);
		Node second = new Node(4);
		Node third = new Node(3);
		head[0].next = second;
		second.next = third;

		/*System.out.println("Linked List Created \nList is : ");
		traverseLinkedList(head[0]);*/

		LeetCode2Add llist2 = new LeetCode2Add();
		llist1.head[1] = new Node(5);
		Node second2 = new Node(6);
		Node third2 = new Node(4);
		llist2.head[1].next = second2;
		second2.next = third2;

		/*System.out.println("Linked List Created \nList is : ");
		traverseLinkedList(head[1]);*/

		Node n3 = null;
		Node l3 = addTwoNumbers(head[0], head[1]);

		System.out.println("Linked List Created \nList is : ");
		traverseLinkedList(l3);
	}
	
	
	
	

	private static Node addTwoNumbers(Node l1, Node l2) {

		Node l3head=new Node(0);
		Node l3=l3head;
        int sum=0,carry=0,x,y;
        while(l1!=null||l2!=null)
        {
            x=(l1==null)?0:l1.data;
            y=(l2==null)?0:l2.data;
            sum=carry+x+y;
            l3.next=new Node((sum%10));
            carry=(sum/10);
            l3=l3.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
    
            
        }
        if(carry>0)
            l3.next=new Node(carry);
        return l3head.next;
	}





	public static Node merge2SortedLL(Node l1, Node l2) {
		
		System.out.println("\nL1 is : ");
		traverseLinkedList(l1);
		System.out.println("\nL2 is : ");
		traverseLinkedList(l2);
		if (l1 == null ) {
			
			return l2;
		}
		else if(l2==null){
			return l2;
		}

		if (l1.data < l2.data) {
			l1.next=addTwoNumbers(l1.next, l2);
			
			System.out.println("In First If \n L1 is : ");
			traverseLinkedList(l1);
			System.out.println("\nL2 is : ");
			traverseLinkedList(l2);
			
			return l1;
		} else {
			l2.next=addTwoNumbers(l1, l2.next);
			
			System.out.println("In second If \n L1 is : ");
			traverseLinkedList(l1);
			System.out.println("\nL2 is : ");
			traverseLinkedList(l2);
			
			return l2;
		}

		
	}

	private static void traverseLinkedList(Node head) {

		if (head == null) {
			System.out.println("List is empty ");
			return;
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
