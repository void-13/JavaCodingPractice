/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=two-pointers
 */
public class RemoveDuplicatesFromSortedListII {
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

    public ListNode deleteDuplicates(ListNode head) {
        /*
        Time complexity: O(n)
        Space complexity: O(1)
         */
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return temp.next;
    }
}
