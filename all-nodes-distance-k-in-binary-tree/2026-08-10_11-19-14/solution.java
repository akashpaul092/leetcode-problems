/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Map<TreeNode, TreeNode> map = mapParent(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Map<TreeNode, Boolean> visit = new HashMap<>();
        while(!queue.isEmpty()){
            if(k == 0) break;
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                visit.put(node, true);
                if(node.left != null && !visit.containsKey(node.left)) queue.offer(node.left);
                if(node.right != null && !visit.containsKey(node.right)) queue.offer(node.right);
                if(map.containsKey(node) && !visit.containsKey(map.get(node))) queue.offer(map.get(node));
            }
            k--;
        }
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }

    private Map<TreeNode, TreeNode> mapParent(TreeNode root){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return map;
    }
}