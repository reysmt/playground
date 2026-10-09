/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> ancestorP = new HashSet<>();

        while(p != null){
            ancestorP.add(p);
            p = p.parent;
        }

        while(!ancestorP.contains(q)){
            q = q.parent;
        }

        return q;
    }
}