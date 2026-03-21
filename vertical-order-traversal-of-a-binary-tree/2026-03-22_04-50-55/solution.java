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
    int level;
    Pair(TreeNode node, int pos, int level){
        this.node = node;
        this.pos = pos;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                Pair pair = queue.poll();
                if(!map.containsKey(pair.pos)) map.put(pair.pos, new TreeMap<>());
                if(!map.get(pair.pos).containsKey(pair.level)) map.get(pair.pos).put(pair.level, new ArrayList<>());
                map.get(pair.pos).get(pair.level).add(pair.node.val);
                if(pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.pos - 1, pair.level + 1));
                if(pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.pos + 1, pair.level + 1));
            }
        }

        for(Map.Entry<Integer, Map<Integer, List<Integer>>> m: map.entrySet()){
            List<Integer> l = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> im: m.getValue().entrySet()){
                List<Integer> arr = im.getValue();
                Collections.sort(arr);
                for(int i=0; i<arr.size(); i++){
                    l.add(arr.get(i));
                }
            }
            list.add(l);
        }
        return list;
    }
}