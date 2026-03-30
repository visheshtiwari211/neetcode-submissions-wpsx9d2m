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
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        int jump = size - n;

        ListNode remPrev = null, rem = head;

        while(jump > 0) {
            remPrev = rem;
            rem = rem.next;
            jump--;
        }

        ListNode remNext = rem.next;
        rem.next = null;
        if(remPrev == null) {
            head = remNext;
        } else {
            remPrev.next = remNext;
        }

        return head;
    }
}
