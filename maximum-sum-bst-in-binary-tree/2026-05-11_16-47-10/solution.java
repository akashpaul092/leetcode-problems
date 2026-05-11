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

class BSTInfo{
    int sum, max, min;
    boolean isBST;
    BSTInfo(int sum, int max, int min, boolean isBST){
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}
class Solution {
    private int sum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return sum;
    }

    private BSTInfo traverse(TreeNode root){
        if(root == null) return new BSTInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);

        BSTInfo left = traverse(root.left);
        BSTInfo right = traverse(root.right);

        if(left.isBST && right.isBST && root.val > left.max && root.val < right.min){
            int curSum = root.val+ left.sum + right.sum;
            sum = Math.max(sum, curSum);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new BSTInfo(curSum, max, min, true);
        }
        return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
    }
}