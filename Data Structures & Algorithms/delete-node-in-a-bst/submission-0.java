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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode node, int key){
        if(node == null){
            return node;
        }

        if(key > node.val){
            node.right = dfs(node.right, key);
        }else if(key < node.val){ 
            node.left = dfs(node.left, key);
        }else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            TreeNode cur = node.right;
            while(cur.left != null){
                cur = cur.left;
            }
            node.val = cur.val;
            node.right = dfs(node.right, node.val);
        }

        return node;
    }
}