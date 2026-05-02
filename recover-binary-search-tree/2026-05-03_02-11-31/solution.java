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
    TreeNode firstViolation;
    TreeNode secondViolation;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = firstViolation.val;
        firstViolation.val = secondViolation.val;
        secondViolation.val = temp;
    }
    
    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(prev != null && prev.val > root.val){
            if(firstViolation == null){
                firstViolation = prev;
            }
            secondViolation = root;
        }
        prev = root;
        helper(root.right);
    }
}