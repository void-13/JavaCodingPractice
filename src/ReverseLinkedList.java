/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }
}
