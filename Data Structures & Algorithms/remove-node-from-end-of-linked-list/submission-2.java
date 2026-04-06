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
        ListNode prev = null, next = head.next;

        while(next!= null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }

        head.next = prev;

        int i = 1;
        prev = null;
        ListNode curr = head;
        while(i != n) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(prev != null) {
            prev.next = curr.next;
        }
        if(curr == head) {
            head = head.next;
        }
        curr.next = null;

        prev = null;
        next = head.next;

        while(next!= null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }

        head.next = prev;

        return head;
    }
}
