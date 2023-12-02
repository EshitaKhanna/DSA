/*
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
*/
package DSA.Leetcode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode temp = head;

        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(30);

        node1.next = node2;
        node2.next = node3;

        deleteDuplicates(node1);
    }
}
