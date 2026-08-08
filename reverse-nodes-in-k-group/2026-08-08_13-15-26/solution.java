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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for(int i = 0; i< k ;i++){
            if(tail == null) return head;
            tail = tail.next;
        }

        ListNode reversedNode = reverseList(head, tail);
        head.next = reverseKGroup(tail, k);

        return reversedNode;
    }

    public static ListNode reverseList(ListNode head, ListNode tail){
        ListNode dummy = null;
        while(head != tail){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}