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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(val > curr.val){
                if(curr.right == null){
                    curr.right = new TreeNode(val);
                    return root;
                }
                stack.push(curr.right);
            }else{
                if(curr.left == null){
                    curr.left = new TreeNode(val);
                    return root;
                }
                stack.push(curr.left);
            }
        }
        return root;
    }
}