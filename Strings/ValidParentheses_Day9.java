// Day: 9
// Problem: 20. Valid Parentheses
// Platform: LeetCode
// Topic: Stack
// Approach: Use stack to match opening and closing brackets
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Not practical

// Optimal:
// Push opening brackets
// Pop when matching closing bracket appears

import java.util.*;

public class ValidParentheses_Day9 {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            else {
                // If stack empty → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check matching pair
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[]{}";

        boolean result = isValid(s);

        System.out.println("Is Valid: " + result);
    }
}