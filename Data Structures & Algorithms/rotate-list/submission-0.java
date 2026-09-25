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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode left = head;
        ListNode right = head;
        
        int length = 1;
        while(right.next != null){
            right = right.next;
            length++;
        }

        k = k % length;
        if(k == 0){
            return head;
        }
        
        for(int i = 0; i < length - k - 1; i++){
            left = left.next;
        }

        ListNode newHead = left.next;
        left.next = null;
        right.next = head;

        return newHead;
    }
}