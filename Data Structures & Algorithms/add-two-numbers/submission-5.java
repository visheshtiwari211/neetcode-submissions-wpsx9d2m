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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        int remainder = 0;
        while(l1 != null && l2 != null) {
            int finalValue = l1.val + l2.val + remainder;
            remainder = 0;
            if(finalValue/10 > 0) {
                int value = finalValue;
                value %= 10;
                remainder = finalValue/10;
                finalValue = value;
            }

            ListNode newNode = new ListNode(finalValue);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1= l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int finalValue = l1.val + remainder;
            remainder = 0;
            if(finalValue/10 > 0) {
                int value = finalValue;
                value %= 10;
                remainder = finalValue/10;
                finalValue = value;
            }

            ListNode newNode = new ListNode(finalValue);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1= l1.next;
        }

        while(l2 != null) {
            int finalValue = l2.val + remainder;
            remainder = 0;
            if(finalValue/10 > 0) {
                int value = finalValue;
                value %= 10;
                remainder = finalValue/10;
                finalValue = value;
            }

            ListNode newNode = new ListNode(finalValue);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l2= l2.next;
        }

        if(remainder > 0) {
            ListNode newNode = new ListNode(remainder);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }

        dummyNode.next = null;

        return head.next;
    }
}
