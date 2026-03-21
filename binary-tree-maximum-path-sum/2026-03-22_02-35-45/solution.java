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
    int sum = Integer.MIN_VALUE;
    public int maxChildSum(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, maxChildSum(root.left));
        int right = Math.max(0, maxChildSum(root.right));

        sum = Math.max(sum, root.val + left + right);

        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxChildSum(root);
        return sum;
    }
}