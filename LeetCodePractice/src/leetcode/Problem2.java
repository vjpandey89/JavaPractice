package leetcode;

public class Problem2 {

	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3Head = new ListNode(0);
		ListNode l3 = l3Head;
		int sum = 0, carry = 0, x, y;
		while (l1 != null || l2 != null) {
			x = (l1 == null) ? 0 : l1.val;
			y = (l2 == null) ? 0 : l2.val;
			sum = carry + x + y;
			l3.next = new ListNode(sum % 10);
			carry = (sum / 10);
			l3 = l3.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

		}
		if (carry > 0)
			l3.next = new ListNode(carry);
		return l3Head.next;

	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode l3 = addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.print(" " + l3.val);
			l3 = l3.next;
		}

	}

}
