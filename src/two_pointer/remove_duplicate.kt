package two_pointer


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
fun main() {
    val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println(removeDuplicates(nums))
}

private fun removeDuplicates(nums: IntArray): Int {

    var left = 1
    for (right in 1 until nums.size)
        if (nums[right] != nums[left - 1]) {
            nums[left] = nums[right]
            left++
        }
    return left
}