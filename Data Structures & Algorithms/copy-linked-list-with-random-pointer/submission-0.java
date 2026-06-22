/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> temp = new HashMap<>();
        temp.put(null,null);

        Node curr = head;
        int count = 0;
        while (head != null){
            temp.put(curr, new Node(curr.val));
        }

        curr = head;
        while(curr != null){
            Node copy = temp.get(curr);
            copy.next = temp.get(curr.next);
            copy.random = temp.get(curr.random);
            curr = curr.next;
        }

        return temp.get(head);
    }
}
