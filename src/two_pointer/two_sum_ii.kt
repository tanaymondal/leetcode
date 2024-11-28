package two_pointer


// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// input array is sorted.
// numbers = [-1,2,7,11,15], target = 9
// find two index, we need to return 2,3 (here index starts from 1)
fun main() {
    val array = arrayOf(-1, 2, 7, 11, 15)
    val target = 9
    println(findTwoSum(array, target).contentToString())
}

fun findTwoSum(array: Array<Int>, target: Int): IntArray {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        val total = array[left] + array[right]
        if (total == target) {
            return intArrayOf(++left, ++right)
        } else if (total > target) {
            right--
        } else {
            left++
        }
    }
    return intArrayOf()
}