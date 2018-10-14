package leetcode;

import java.util.Stack;

public class Problem160 {
	
	
	public static class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	static ListNode head1;
	static ListNode head2;
	
	    public ListNode getIntersectionNode() {
	    //boundary check
	    if(head1 == null || head2 == null) return null;
	    
	    ListNode a = head1;
	    ListNode b = head2;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? head2 : a.next;
	        b = b == null? head1 : b.next;    
	    }
	    
	    return a;
	}
	
	    
	    
	    public static void main(String[] args) {
	    	Problem160 list = new Problem160();
	 
	        // creating first linked list
	        list.head1 = new ListNode(3);
	        list.head1.next = new ListNode(6);
	        list.head1.next.next = new ListNode(15);
	        list.head1.next.next.next = new ListNode(15);
	        list.head1.next.next.next.next = new ListNode(30);
	 
	        // creating second linked list
	        list.head2 = new ListNode(10);
	        list.head2.next = new ListNode(15);
	        list.head2.next.next = new ListNode(30);
	 
	        System.out.println("The node of intersection is " + list.getIntersectionNode());
	 
	    }

}
