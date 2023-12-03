/*
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {

        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int start = 0;
        int end = arr.size() -1;
        while(start<end){
            if(arr.get(start) != arr.get(end)){
                return false;
            }else{
                start++;
                end--;
            }

        }
        return true;
        
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(20);
        ListNode node4 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(node1));
    }
}
