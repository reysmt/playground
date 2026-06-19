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
        Map<Integer,Integer> seen = new HashMap<Integer, Integer>();
        while(head != null){
            int num = head.val; 
            if(seen.containsKey(num)){
                return true;
            }
            seen.put(num, num);
            head = head.next;
        }
        return false;
    }
}
