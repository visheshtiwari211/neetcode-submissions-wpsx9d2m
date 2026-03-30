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
        ListNode curr = null, newHead = null, prev = null;
        int carry = 0;
        while(l1!=null && l2!=null) {
            int val = l1.val + l2.val + carry;
            if(val > 10) {
                carry = (int) Math.floor(val/10);
                val = val%10;
            } else if(val == 10) {
                carry = 1;
                val = val %10;
            } else {
                carry = 0;
                val = val %10;
            }
            ListNode node = new ListNode(val);
            if(curr != null) {
                prev = curr;
            }
            curr = node;
            if(newHead == null) {
                newHead = curr;
            }
            if(prev != null) {
                prev.next = curr;
            }
            l1= l1.next;
            l2 = l2.next;
        }

        if(l1!=null) {
            while(l1 != null) {
            int val = l1.val + carry;
            if(val > 10) {
                carry = (int) Math.floor(val/10);
                val = val % 10;
            } else if(val == 10) {
                carry = 1;
                val = val %10;
            } else {
                carry = 0;
                val = val %10;
            }
            ListNode node = new ListNode(val);
            prev = curr;
            curr = node;
            prev.next = curr;
            l1= l1.next;
            }
        }

        if(l2!=null) {
            while(l2 != null) {
                int val = l2.val + carry;
            if(val > 10) {
                carry = (int) Math.floor(val/10);
                val = val % 10;
            } else if(val == 10) {
                carry = 1;
                val = val %10;
            } else {
                carry = 0;
                val = val %10;
            }
            ListNode node = new ListNode(val);
            prev = curr;
            curr = node;
            prev.next = curr;
            l2= l2.next;
            }
        }

        while(carry != 0) {
            int val = carry;
            ListNode node = new ListNode(val);
            prev = curr;
            curr = node;
            prev.next = curr;
            carry = 0;
        }

        return newHead;
    }
}
