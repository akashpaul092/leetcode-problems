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
    int pos;
    Pair(TreeNode node, int pos){
        this.node = node;
        this.pos = pos;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int i=0; i<size; i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int pos = pair.pos;
                if(i == 0) start = pos;
                if(i == size - 1) end = pos;
                if(node.left != null) queue.offer(new Pair(node.left, 2*pos));
                if(node.right != null) queue.offer(new Pair(node.right, 2*pos + 1));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}