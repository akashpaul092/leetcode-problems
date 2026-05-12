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
    private void flatten(TreeNode root, List<Integer> arr){
        if(root == null) return;
        flatten(root.left, arr);
        arr.add(root.val);
        flatten(root.right, arr);
    }

    private TreeNode constractTree(List<Integer> arr, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = constractTree(arr, start, mid - 1);
        node.right = constractTree(arr, mid + 1, end);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        flatten(root, list);
        return constractTree(list, 0, list.size() - 1);
    }
}