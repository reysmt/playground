/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = head;
        ListNode right = head;

        while(right != null && right.next != null){
            right = right.next.next;
            left = left.next;
        }

        ListNode prev = null;
        while(left != null){
            ListNode temp = left.next;
            left.next = prev;
            prev = left;
            left = temp;
        }

        left = head;
        right = prev;

        while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}