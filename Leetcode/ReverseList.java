/*
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
*/


package DSA.Leetcode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
	    ListNode prev = null;
	    ListNode temp;

        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
