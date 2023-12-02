/*
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
*/

public class MiddleOfLinkedList {
    
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);

        node1.next = node2;
        node2.next = node3;

        ListNode middle = middleNode(node1);
        System.out.println(middle.val);
    }
}
