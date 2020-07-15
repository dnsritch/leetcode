class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        int[][] profit = new int[length][3];
        profit[0][0] = -prices[0];// 持有
        profit[0][1] = 0;// 非持有，冻结
        profit[0][2] = 0;// 非持有，非冻结

        for (int i = 1; i < profit.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][2] - prices[i]);
            profit[i][1] = profit[i - 1][0] + prices[i];
            profit[i][2] = Math.max(profit[i - 1][2], profit[i - 1][1]);
        }
        return Math.max(profit[length - 1][1], profit[length - 1][2]);

    }
}