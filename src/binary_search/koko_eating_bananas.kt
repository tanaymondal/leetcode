package binary_search

import kotlin.math.ceil

fun main() {
    val intArray = intArrayOf(30, 11, 23, 4, 20)
    val hour = 6
    println(minEatingSpeed(intArray, hour))
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var start = 1
    var end = piles.max()
    var result = end

    while (start <= end) {
        val mid = (start + end) / 2

        var totalHour = 0.0
        for (pile in piles) {
            totalHour += ceil(pile.toDouble() / mid)
        }

        if (totalHour <= h) {
            end = mid - 1
            result = mid
        } else {
            start = mid + 1
        }
    }
    return result
}