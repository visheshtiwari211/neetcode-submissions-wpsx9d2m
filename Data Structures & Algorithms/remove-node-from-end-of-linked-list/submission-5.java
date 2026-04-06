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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, prev = null;
        int jump = 0;

        while(jump < n && fast != null) {
            fast = fast.next;
            jump++;
        }

        if(fast == null) {
            head = head.next;
            return head;
        }

        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;
        slow.next = null;
        

        return head;
    }
}
