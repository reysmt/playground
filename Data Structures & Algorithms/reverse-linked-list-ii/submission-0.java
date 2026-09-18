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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy;
        ListNode cur = head;

        while(left - 1 > 0){
            leftNode = cur;
            cur = cur.next;
            left--;
        }

        ListNode prev = null;
        for(int i = 0; i < right - left + 1; i++){
            ListNode tmpNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNext;
        }

        leftNode.next.next = cur;
        leftNode.next = prev;

        return dummy.next;
    }
}