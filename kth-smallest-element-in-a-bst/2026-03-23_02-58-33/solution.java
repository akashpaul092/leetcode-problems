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
    int count = 0;
    int val = -1;
    private void traverse(TreeNode root, int k){
        if(root == null || count >= k) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        traverse(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return val;
    }
}