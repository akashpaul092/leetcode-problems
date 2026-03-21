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
class Pair{
    TreeNode n;
    int count;
    Pair(TreeNode n, int count){
        this.n = n;
        this.count = count;
    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int length = 0;
        while(!queue.isEmpty()){
            Pair t = queue.poll();
            TreeNode node = t.n;
            length = Math.max(length, t.count);
            if(node.left != null) queue.offer(new Pair(node.left, t.count+1));
            if(node.right != null) queue.offer(new Pair(node.right, t.count+1));
        }

        return length;
    }
    
}