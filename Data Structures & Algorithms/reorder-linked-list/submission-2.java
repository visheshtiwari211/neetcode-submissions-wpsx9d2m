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
        ListNode fast = head.next, slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        if(head2 == null) {
            return;
        }

        ListNode prev = null, next = head2.next;

        while(head2.next != null) {
            head2.next = prev;
            prev = head2;
            head2 = next;
            next = next.next;
        }

        head2.next = prev;

        ListNode temp1 = head.next, temp2 = head2.next;
        while(temp1 != null && temp2 != null) {
            head.next = head2;
            head2.next = temp1;
            head = temp1;
            head2 = temp2;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        head.next = head2;
        head2.next = temp1;

        return;
    }

    
}
