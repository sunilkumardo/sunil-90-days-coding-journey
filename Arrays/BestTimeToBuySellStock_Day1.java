// Day: 1
// Problem: Best Time to Buy & Sell Stock
// Topic: Array + Greedy
// Approach: Track minimum price and max profit
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Try all pairs → O(n^2)

// Optimal:
// Track min price and calculate profit in one pass

public class BestTimeToBuySellStock_Day1 {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Update minimum price
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit
            int profit = price - minPrice;

            // Update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    // ✅ Main method for testing
    public static void main(String[] args) {

        BestTimeToBuySellStock_Day1 obj = new BestTimeToBuySellStock_Day1();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = obj.maxProfit(prices);

        System.out.println("Max Profit: " + result);
    }
}