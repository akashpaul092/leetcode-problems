/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    private void findleftNodes(Node root, List<Integer> list){
        if(root == null || (root != null && root.left == null && root.right == null)) return;
        list.add(root.data);
        findleftNodes(root.left, list);
        if(root.left == null) findleftNodes(root.right, list);
    }
    private void findrightNodes(Node root, List<Integer> list){
        if(root == null || (root != null && root.left == null && root.right == null)) return;
        if(root.right == null) findrightNodes(root.left, list);
        findrightNodes(root.right, list);
        list.add(root.data);
    }
    private void findLeafNodes(Node root, List<Integer> list){
        if(root == null) return;
        findLeafNodes(root.left, list);
        findLeafNodes(root.right, list);
        if(root.left == null && root.right == null) list.add(root.data);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(!(root.left == null && root.right == null)){
            list.add(root.data);
        }
        findleftNodes(root.left, list);
        findLeafNodes(root, list);
        findrightNodes(root.right, list);
        return list;
    }
}


