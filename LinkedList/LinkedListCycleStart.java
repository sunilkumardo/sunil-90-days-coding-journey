// Day: 12
// Problem: 142. Linked List Cycle II
// Platform: LeetCode
// Topic: Linked List
// Approach: Floyd’s Algorithm (Cycle Detection + Entry Point)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Idea:
// After detecting cycle, move one pointer to head
// Move both one step → they meet at cycle start

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleStart {

    public static ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Find start
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Create cycle: 1 -> 2 -> 3 -> 4 -> back to 2
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // cycle

        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println("Cycle starts at: " + result.val);
        } else {
            System.out.println("No cycle");
        }
    }
}