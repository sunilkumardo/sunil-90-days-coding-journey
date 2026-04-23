// Day: 12
// Problem: 141. Linked List Cycle
// Platform: LeetCode
// Topic: Linked List
// Approach: Fast & Slow Pointers (Floyd’s Cycle Detection)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Use HashSet to track visited nodes → O(n) space

// Optimal:
// Use two pointers: slow moves 1 step, fast moves 2 steps
// If they meet → cycle exists

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Create cycle: 3 -> 2 -> 0 -> -4 -> back to 2
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // cycle

        System.out.println("Has Cycle: " + hasCycle(head));
    }
}