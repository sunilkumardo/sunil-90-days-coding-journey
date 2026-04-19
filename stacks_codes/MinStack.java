// Day: 10
// Problem: 155. Min Stack
// Platform: LeetCode
// Topic: Stack
// Approach: Use two stacks (main stack + min stack)
// Time Complexity: O(1) for all operations
// Space Complexity: O(n)

// Brute Force:
// Find min each time → O(n)

// Optimal:
// Maintain another stack to track minimums

import java.util.*;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // Push to minStack if smaller or equal
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        System.out.println("Min: " + obj.getMin()); // -3

        obj.pop();

        System.out.println("Top: " + obj.top());    // 0
        System.out.println("Min: " + obj.getMin()); // -2
    }
}
