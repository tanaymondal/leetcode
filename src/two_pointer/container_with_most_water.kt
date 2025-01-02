package two_pointer

fun main() {
    val array = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxArea(array))

}

fun maxArea(height: IntArray): Int {
    var startIndex = 0
    var endIndex = height.size - 1
    var maxArea = 0

    while (startIndex < endIndex) {
        maxArea = maxOf(maxArea, minOf(height[endIndex], height[startIndex]) * (endIndex - startIndex))
        if (height[startIndex] > height[endIndex]) {
            endIndex--
        } else {
            startIndex++
        }
    }
    return maxArea
}