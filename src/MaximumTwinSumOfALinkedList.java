/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.

https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumTwinSumOfALinkedList {
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

    public int pairSum(ListNode head) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        if (head == null || head.next == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = slow.next;
        ListNode prev = null;
        ListNode current = reverseHead;
        slow.next = null;

        while (current != null) {
            ListNode after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }

        reverseHead = prev;

        int maxSum = 0;

        while (head != null && reverseHead != null) {
            int sum = head.val + reverseHead.val;
            maxSum = Math.max(maxSum, sum);
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return maxSum;
    }
}
