package sliding_window

object stock_buy_sell_max_profit_ii {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(7, 1, 5, 3, 6, 4)
        println(maxProfit(array))
    }

    private fun maxProfit(array: IntArray) : Int {
        var maxProfit = 0
        for (index in 1 until array.size) {
            val currentProfit = array[index] - array[index - 1]
            if (currentProfit > 0) {
                maxProfit = currentProfit.coerceAtLeast(maxProfit)
            }
        }
        return maxProfit
    }
}
