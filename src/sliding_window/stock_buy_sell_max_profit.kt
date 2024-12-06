package sliding_window

object stock_buy_sell_max_profit {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    @JvmStatic
    fun main(args: Array<String>) {
        // buy and sell stock. return max profit.
        val array = intArrayOf(7, 1, 5, 3, 6, 4)
        println(maxProfit(array))
    }

    private fun maxProfit(array: IntArray) : Int {
        var buyIndex = 0
        var maxProfit = 0
        for (sellIndex in 1 until array.size) {
            if (array[sellIndex] > array[buyIndex]) {
                val profit = array[sellIndex] - array[buyIndex]
                maxProfit = Math.max(maxProfit, profit)
            } else {
                buyIndex = sellIndex
            }
        }
        return maxProfit
    }
}
