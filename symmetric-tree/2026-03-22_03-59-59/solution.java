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
private String dfsLeft(TreeNode root){
    if(root == null) return "#";
    return root.val + "," + dfsLeft(root.left) + "," + dfsLeft(root.right);
}

private String dfsRight(TreeNode root){
    if(root == null) return "#";
    return root.val + "," + dfsRight(root.right) + "," + dfsRight(root.left);
}

public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return dfsLeft(root.left).equals(dfsRight(root.right));
}
}