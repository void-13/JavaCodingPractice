/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

https://leetcode.com/problems/partition-list/description/?envType=problem-list-v2&envId=two-pointers
 */
public class PartitionList {
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

    public ListNode partition(ListNode head, int x) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        ListNode less = new ListNode(0);
        ListNode lessTail = less;
        ListNode greaterOrEqual = new ListNode(0);
        ListNode greaterOrEqualTail = greaterOrEqual;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                lessTail.next = temp;
                lessTail = lessTail.next;
            } else {
                greaterOrEqualTail.next = temp;
                greaterOrEqualTail = greaterOrEqualTail.next;
            }
            temp = temp.next;
        }

        greaterOrEqualTail.next = null;
        lessTail.next = greaterOrEqual.next;
        return less.next;
    }
}
