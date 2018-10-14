package leetcode;

public class Problem21 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		ListNode list1 = new ListNode(10);
		list1.next = new ListNode(20);
		list1.next.next = new ListNode(40);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(list1, list2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	
		
		
		ListNode n=l1;
		System.out.print("\nL1 is :");
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.print("\nL2 is :");
		n=l2;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		
		
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
	
		
		

		if (l1.val < l2.val) {
			
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1,l2.next);
			return l2;
		}

	}

}
