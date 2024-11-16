package two_pointer


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
fun main() {
    val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println(removeDuplicates(nums))
}

fun removeDuplicates(nums: IntArray): Int {

    var left = 0
    val length = nums.size

    for (right in 1 until length) {
        if (nums[left] != nums[right]) {
            left++
            nums[left] = nums[right]
        }
    }
    return ++left
}