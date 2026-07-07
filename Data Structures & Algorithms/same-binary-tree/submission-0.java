/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stackP = new LinkedList<>();
        stackP.push(p);
        Deque<TreeNode> stackQ = new LinkedList<>();
        stackQ.push(q);


        while(!stackP.isEmpty() || !stackQ.isEmpty()){
            if(stackP.isEmpty() != stackQ.isEmpty()){
                return false;
            }

            TreeNode currentP = stackP.pop();
            TreeNode currentQ = stackQ.pop();

            if (currentP == null && currentQ == null) {
                continue;
            }   

            if (currentP == null || currentQ == null || currentP.val != currentQ.val) {
                return false;
            }

            stackP.push(currentP.left);
            stackP.push(currentP.right);

            stackQ.push(currentQ.left);
            stackQ.push(currentQ.right);
        }
        return true;
    }
}
