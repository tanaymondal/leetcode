package two_pointer

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    println(removeDuplicates(nums))
}

private fun removeDuplicates(nums: IntArray): Int {

    if (nums.size <= 2) return nums.size

    var left = 2
    for (right in 2 until nums.size)
        if (nums[right] != nums[left - 2]) {
            nums[left] = nums[right]
            left++
        }
    return left

}