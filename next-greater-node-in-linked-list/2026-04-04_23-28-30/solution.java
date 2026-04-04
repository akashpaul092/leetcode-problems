/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int[] output = new int[arr.size()];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<arr.size();i++){
            while(!stack.isEmpty() && arr.get(stack.peek())<arr.get(i)){
                output[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }
        return output;
    }
}