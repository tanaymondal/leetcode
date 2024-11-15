package sliding_window;

public class stock_buy_sell_max_profit {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public static void main(String[] args) {
        // buy and sell stock. return max profit.
        int[] array = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array));
    }

    static int maxProfit(int[] array) {
        int buyIndex = 0;
        int maxProfit = 0;

        for (int sellIndex = 1; sellIndex < array.length; sellIndex++) {
            if (array[sellIndex] > array[buyIndex]) {
                int currentProfit = array[sellIndex] - array[buyIndex];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
               buyIndex = sellIndex;
            }
        }
        return maxProfit;
    }
}
