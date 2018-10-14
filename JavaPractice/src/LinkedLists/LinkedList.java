package LinkedLists;

 class LinkedList {
	public static Node head; // head of list

	/* Linked list Node */
	static class Node {
		int data;
		Node next;

		// Constructor to create a new node
		// Next is by default initialized
		// as null
		Node(int d) {
			data = d;
		}
	}

	public static void main(String[] args) {
		 createLinkedList();
		insertAtBegin(new Node(10));
		insertAtEnd(new Node(23));
		insertAtPosition(new Node(15), 2);

		// removeFromBegin();
		// removeFromEnd();
		removeFromPosition(2);

		// deleteStart();
		// deleteEnd();
	}

	private static Node removeFromPosition(int pos) {
		Node prev = null, current = null, nextNode = null;
		if (pos < 1) {
			System.out.println("\nInvalid pos , only greater than 1 allowed");
			return null;
		}
		if (head == null) {
			System.out.println("\nList is empty can't remove anything");
			return null;
		}

		if (pos == 1) {
			head = head.next;
			System.out.println("\nNode removed from pos" + pos + " \nList is : ");
			traverseLinkedList();
			return null;
		}
		current = head;

		for (int i = 1; i < pos; i++) {
			if (current.next == null) {
				System.out.println("\nposition given is greater then list lentgh");
				return null;
			}
			prev = current;
			current = current.next;
			nextNode = current.next;
		}
		prev.next = current.next;
		current.next = null;
		System.out.println("\nNode removed from pos" + pos + " \nList is : ");
		traverseLinkedList();
		return current;
	}

	private static Node removeFromEnd() {
		Node n = head, prev = head;
		if (n.next == null) {
			head = null;
			System.out.println("\nNode removed from end \nList is : ");
			traverseLinkedList();
			return n;
		}
		if (n != null) {
			while (n.next != null) {
				prev = n;
				n = n.next;
			}
			prev.next = null;
		}
		System.out.println("\nNode removed from end \nList is : ");
		traverseLinkedList();
		return n;
	}

	private static Node removeFromBegin() {
		Node n = head;
		if (head != null) {
			head = head.next;
			n.next = null;
		}
		System.out.println("\nNode removed from begin \nList is : ");
		traverseLinkedList();
		return n;
	}

	private static void insertAtBegin(Node newNode) {
		newNode.next = head;
		head = newNode;
		System.out.println("\nNew node inserted at begin\nList is : ");
		traverseLinkedList();

	}

	private static void insertAtEnd(Node newNode) {

		if (head == null)
			head = newNode;
		else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = newNode;
		}
		System.out.println("\nNew Node inserted at the end \nList is : ");

		traverseLinkedList();
	}

	private static void insertAtPosition(Node newNode, int pos) {

		if (pos == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}

		else if (head == null && pos != 1) {
			System.out.println("\nLinked List emplty,Your Position is larger then list lentgh");
		}

		else {
			Node prev = null, nextNode = head;

			for (int i = 1; i < pos; i++) {
				if (nextNode.next == null) {
					System.out.println("\nposition give is greater then list lentgh");
					return;
				}
				prev = nextNode;
				nextNode = nextNode.next;

			}

			newNode.next = nextNode;
			prev.next = newNode;

		}
		System.out.println("\nNew Node inserted at the pos" + pos + "\nList is : ");

		traverseLinkedList();
	}

	private static void traverseLinkedList() {

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

	private static void createLinkedList() {

		LinkedList llist = new LinkedList();
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		llist.head.next = second;
		second.next = third;

		System.out.println("Linked List Created \nList is : ");
		traverseLinkedList();
	}

}
