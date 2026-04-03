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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }
        ListNode head = null, head1 = list1, head2 = list2;

        if(head1.val > head2.val) {
            head = head2;
            head2 = head2.next;
        } else {
            head = head1;
            head1 = head1.next;
        }

        while(head1 != null && head2 != null) {
            if(head1.val > head2.val) {
                head.next = head2;
                head2 = head2.next;
            } else {
                head.next = head1;
                head1 = head1.next;
            }

            head = head.next;
        }

        if(head1 != null) {
            head.next = head1;
        }

        if(head2 != null) {
            head.next = head2;
        }

        if(list1.val > list2.val) {
            return list2;
        } else {
            return list1;
        }
    }
}