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
    public boolean hasCycle(ListNode head) {
        ListNode dummy = head;
        ListNode current = dummy;
        while(current.next != null){
            ListNode slow = current.next;
            ListNode fast = current.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
