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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while(true){
            ListNode kthNode = findKthGroup(node, k);
            if(kthNode == null) break;

            ListNode nextGroup = kthNode.next;

            ListNode prev = nextGroup;
            ListNode curr = node.next;
            while(curr != nextGroup){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = node.next;
            node.next = kthNode;
            node = temp;
        }
        return dummy.next;
    }
    private ListNode findKthGroup(ListNode head, int k){
        while(head != null && k > 0){
            head = head.next;
            k--;
        }
        return head;
    }
}