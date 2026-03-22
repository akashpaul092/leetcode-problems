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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            if(temp.left != null){
                if(temp.right != null) stack.push(temp.right);
                temp.right = temp.left;
                temp.left = null;
            }else if(temp.right == null && !stack.isEmpty()){
                temp.right = stack.pop();
            }
            temp = temp.right;
        }
    }
}