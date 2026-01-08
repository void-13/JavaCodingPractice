/*
You are given the head of two singly linked lists head1 and head2 representing two non-negative integers. You have to return the head of the linked list representing the sum of these two numbers.
https://www.geeksforgeeks.org/problems/test-on-prod--120504/1?page=1&sortBy=latest
 */
public class TestOnProd {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
    Time Complexity: O(m + n) where m and n are the size of the two linked lists.
    Space Complexity: O(1)
     */
    public static Node addTwoLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return new Node(0);
        }
        if (head1 == null) {
            return removeLeadingZeros(head2);
        }
        if (head2 == null) {
            return removeLeadingZeros(head1);
        }

        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);
        int carry = 0;
        int sum;
        Node result = null;

        while (head1 != null || head2 != null || carry != 0) {
            if (head1!= null) {
                if (head2 != null) {
                    sum = head1.data + head2.data + carry;
                    head1 = head1.next;
                    head2 = head2.next;
                } else {
                    sum = head1.data + carry;
                    head1 = head1.next;
                }
            } else {
                sum = head2.data + carry;
                head2 = head2.next;
            }
            int resultNode = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(resultNode);
            newNode.next = result;
            result = newNode;
        }
        return removeLeadingZeros(result);
    }

    private static Node reverseLinkedList(Node head) {
        Node before = null;
        Node current = head;

        while (current != null) {
            Node after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        return before;
    }

    private static Node removeLeadingZeros(Node head) {
        while (head != null && head.next != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
}
