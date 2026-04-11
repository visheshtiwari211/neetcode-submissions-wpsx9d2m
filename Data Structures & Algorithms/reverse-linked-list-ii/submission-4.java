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
        ListNode prev = null, curr = head, next = head.next;
        int currentLvl = 1;

        while(currentLvl < left) {
            prev = curr;
            curr = curr.next;
            next = next.next;
            currentLvl++;
        }
        ListNode prevHead = prev;
        ListNode firstNode = curr;
        prev = curr;
        curr = curr.next;
        next = next.next;
        currentLvl++;
        while(currentLvl < right) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
            currentLvl++;
        }
        if(prevHead != null) {
            prevHead.next = curr;
        }
        firstNode.next = curr.next;
        curr.next = prev;
        if(left == 1) {
            head = curr;
        }

        return head;
    }
}