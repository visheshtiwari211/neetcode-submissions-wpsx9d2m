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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || right == left) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevHead = dummy, firstNode = head;
        int jump = 1;
        while(jump<left) {
            prevHead = firstNode;
            firstNode = firstNode.next;
            jump++;
        }

        while(jump < right) {
            ListNode nextNode = firstNode.next;
            firstNode.next = nextNode.next;
            nextNode.next = prevHead.next;
            prevHead.next = nextNode;
            jump++;
        }

        return dummy.next;
    }
}