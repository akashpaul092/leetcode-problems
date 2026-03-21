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
    TreeNode node;
    int height;
    Pair(TreeNode node, int height){
        this.node = node;
        this.height = height;
    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int maxHeight = 0;
        queue.offer(new Pair(root, 1));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                Pair ele = queue.poll();
                maxHeight = Math.max(maxHeight, ele.height);
                if(ele.node.left != null) queue.offer(new Pair(ele.node.left, ele.height + 1));
                if(ele.node.right != null) queue.offer(new Pair(ele.node.right, ele.height + 1));
            }
        }
        return maxHeight;
    }
}