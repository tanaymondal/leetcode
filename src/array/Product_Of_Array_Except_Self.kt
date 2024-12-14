package array

//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]

fun main() {
    val array = intArrayOf(1, 2, 3, 4)

    println(productExceptSelf(array).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 1 }

    var prefix = 1
    for (i in nums.indices) {
        result[i] = prefix
        prefix = prefix * nums[i]
    }

    var postfix = 1
    for (i in nums.size - 1 downTo 0) {
        result[i] = result[i] * postfix
        postfix = postfix * nums[i]
    }

    return result
}