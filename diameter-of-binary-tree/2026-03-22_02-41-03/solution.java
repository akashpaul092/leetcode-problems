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
    int maxPath = 0;
    private int maxPath(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));

        maxPath = Math.max(maxPath, left + right);

        return 1 + Math.max(left, right);
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return maxPath;
    }
}