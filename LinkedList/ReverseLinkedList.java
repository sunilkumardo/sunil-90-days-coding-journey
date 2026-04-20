// Day: 11
// Problem: 206. Reverse Linked List
// Platform: LeetCode
// Topic: Linked List
// Approach: Iterative (Pointer Manipulation)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Use extra array/stack → O(n) space

// Optimal:
// Reverse pointers in-place

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                  // move prev
            curr = nextTemp;              // move curr
        }

        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(head);

        head = reverseList(head);

        System.out.print("Reversed: ");
        printList(head);
    }
}