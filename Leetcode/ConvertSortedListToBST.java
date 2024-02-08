/*
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
*/
package DSA.Leetcode;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if(head == tail){
            return null;
        }
        ListNode mid = midOfList(head,tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head, mid);
        root.right = sortedListToBST(mid.next, tail);

        return root;

    }
    public ListNode midOfList(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        
    }
}
