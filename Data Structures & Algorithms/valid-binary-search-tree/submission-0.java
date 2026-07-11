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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int rootVal){
        if(node == null){
            return true;
        }

        if(node.left != null && node.left.val > rootVal){
            return false;
        }

        if(node.right != null && node.right.val < rootVal){
            return false;
        }

        dfs(node.left, node.val);
        dfs(node.right, node.val);

        return true;

    }
}
