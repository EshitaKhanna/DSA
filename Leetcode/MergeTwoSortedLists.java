/*
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
*/
package DSA.Leetcode;
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode head1 = list1, head2 = list2, head = null, tail = null;

        if(head1.val <= head2.val){
            head = head1;
            tail = head1;
            
            head1 = head1.next;
            
        }else {
        	head = head2;
            tail = head2;
            
            head2 = head2.next;
        }
        
        while (head1 != null && head2 != null) {
        	if(head1.val <= head2.val){
                tail.next = head1;
                tail = head1;
                
                head1 = head1.next;
                
            }else {
            	tail.next = head2;
                tail = head2;
           
                head2 = head2.next;
            }
        }
        
        if(head1 != null) {
        	tail.next = head1;
        }else {
        	tail.next = head2;
        }
        return head;
    }

    public static void main(String[] args) {
        
    }
}
