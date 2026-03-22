/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        int celi = -1;
        while(root != null){
            if(root.data == x) return x;
            
            if(root.data < x){
                root = root.right;
            }else{
                celi = root.data;
                root = root.left;
            }
        }   
        return celi;
    }
}