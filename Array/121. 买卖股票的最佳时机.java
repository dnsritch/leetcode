class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;

        int start = prices[0], end = prices[0], profit = end - start;

        for (int i = 1; i < length; i++) {
            int temp = prices[i];
            if (temp > start) {
                end = temp;
            } else {
                start = temp;
                end = temp;
            }
            profit = Math.max(profit, end - start);
        }

        return profit;
    }
}