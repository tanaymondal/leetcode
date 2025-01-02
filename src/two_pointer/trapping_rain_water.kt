package two_pointer

fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}

fun trap(height: IntArray): Int {

    if (height.isEmpty()) return 0

    var left = 0
    var right = height.size - 1

    var maxLeft = height[left]
    var maxRight = height[right]
    var maxWater = 0

    while (left < right) {
        if (maxLeft < maxRight) {
            left++
            maxLeft = maxOf(maxLeft, height[left])
            maxWater += maxLeft - height[left]
        } else {
            right--
            maxRight = maxOf(maxRight, height[right])
            maxWater += maxRight - height[right]
        }
    }
    return maxWater
}