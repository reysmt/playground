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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;

        
        while (true) {
            ListNode nextGroupHead = left; //riparte da left
            int i = 0;

            while (i <= k && nextGroupHead != null) {
                nextGroupHead = nextGroupHead.next;
                i++;
            }

            if (i <= k) break;  // 2-3. meno di k nodi: stop, non invertire

            ListNode oldHead = left.next;

            ListNode prev = null;
            ListNode curr = oldHead;
            while (curr != nextGroupHead) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            left.next = prev; // 4. aggancia il nuovo primo nodo

            oldHead.next = nextGroupHead; // aggancia il resto

            left = oldHead;// 5. avanza al gruppo successivo

        }

        return dummy.next;
    }
}
