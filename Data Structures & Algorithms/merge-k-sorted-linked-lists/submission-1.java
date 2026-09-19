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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode result = null;
        for(ListNode list : lists){
            result = mergeTwo(result, list);
        }
        return result;
    }

    public ListNode mergeTwo(ListNode first, ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(first != null && second != null){
            if(first.val < second.val){
                current.next = first;
                first = first.next;
            }else{
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        current.next = (first != null) ? first : second;
        return dummy.next;
    }
}
