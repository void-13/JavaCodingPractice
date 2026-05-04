/*
Given the head of a linked list, rotate the list to the right by k places.

https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=two-pointers
 */
public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        k = k % length;
        int toRotate = length - k;
        ListNode temp = tail;

        while (toRotate > 0) {
            temp = temp.next;
            toRotate--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
