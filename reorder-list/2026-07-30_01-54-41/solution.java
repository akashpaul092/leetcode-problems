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
    public void reorderList(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        merge(head,l2);
    }

    private static void merge(ListNode l1, ListNode l2){
        while(l1 != null && l2 != null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l2.next = l1_next;
            l1.next = l2;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    private static ListNode reverse(ListNode node){
        ListNode dummy = node;
        ListNode rev = null;
        while(dummy != null){
            ListNode next = dummy.next;
            dummy.next = rev;
            rev = dummy;
            dummy = next;
        }
        return rev;
    }

    private static ListNode findMiddleNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}