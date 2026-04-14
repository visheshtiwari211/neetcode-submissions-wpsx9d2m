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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = lists.length, i = 0;
        while(i<n) {
            if(lists[i] != null) {
                queue.offer(lists[i]);   
            }
            i++;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;

            if(node.next != null) {
                ListNode nextNode = node.next;
                queue.offer(nextNode);
            }
        }
        return dummy.next;
    }
}
