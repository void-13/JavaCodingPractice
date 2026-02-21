/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=problem-list-v2&envId=two-pointers
 */
public class RemoveNthNodeFromEndOfList {
    class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
            ListNode slow = head;
            ListNode fast = head;

            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            if (fast == null) {
                return head.next;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

        return  head;
    }
}
