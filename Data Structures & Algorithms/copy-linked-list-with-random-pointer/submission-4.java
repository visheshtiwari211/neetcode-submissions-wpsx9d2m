/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node first = new Node(head.val);
        Node curr = first;
        Node duplicateHead = curr;
        Node firstIterator = head;

        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, first);

        while(firstIterator.next != null) {
            firstIterator = firstIterator.next;
            Node newNode = new Node(firstIterator.val);
            curr.next = newNode;
            map.put(firstIterator, newNode);
            curr = curr.next;
        }

        curr.next = null;

        curr = duplicateHead;

        while(head != null) {
            Node randomNode = head.random;
            if(randomNode != null) {
                if(map.containsKey(randomNode)) {
                    Node rNode = map.get(randomNode);
                    curr.random = rNode;
                }
            }
            curr = curr.next;
            head = head.next;
        }

        return duplicateHead;
    }
}
