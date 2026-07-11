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

    private int maxNode = 0;

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
        
    }

    private int dfs(TreeNode node, int maxVal){
        if(node == null) {
            return 0;
        }

        maxNode = Math.max(maxNode, maxVal);

        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);
        return res;
    }
}
