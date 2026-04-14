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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(0, lists.length - 1, lists);
    }

    public ListNode divide(int l, int r, ListNode[] lists) {
        if(l > r) {
            return null;
        }

        if(l == r) {
            return lists[l];
        }
        int mid = l + (r-l)/2;

        ListNode left = divide(l, mid, lists);
        ListNode right = divide(mid + 1, r, lists);

        return conquer(left, right);
    }

    public ListNode conquer(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(left != null && right != null) {
            if(left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if(left != null) {
                head.next = left;
            }
            if(right != null) {
                head.next = right;
            }
        return dummy.next; 
    }
}
