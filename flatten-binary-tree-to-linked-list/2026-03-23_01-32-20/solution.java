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
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while(temp.left!=null || temp.right!=null || !stack.isEmpty()){
            if(temp.left!=null){
                TreeNode node=temp.right;
                if(node!=null){
                    stack.push(new TreeNode(node.val,node.left,node.right));
                }
                temp.right=temp.left;
                temp.left=null;
                temp=temp.right;
            }else if(temp.right!=null){
                temp=temp.right;
            }else{
                temp.right=stack.pop();
                temp=temp.right;
            }
            if(temp==null) return;
        }
    }
}