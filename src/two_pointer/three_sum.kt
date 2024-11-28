package two_pointer


// https://leetcode.com/problems/3sum/
fun main() {
    val array = intArrayOf(3, -3, 0, -3, 6)
    println(threeSum(array))
}

fun threeSum(nums: IntArray): List<List<Int>> {

    nums.sort()

    val finalList = mutableListOf<List<Int>>()
    for (index in nums.indices) {
        val number = nums[index]

        // if number is > 0, we can't have a + b + c = 0
        if (number > 0) {
            break
        }

        // if current number and previous number is same, then continue to the next iteration
        if (index > 0 && number == nums[index - 1]) {
            continue
        }

        var left = index + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = number + nums[left] + nums[right]
            when {
                sum > 0 -> {
                    right--
                }

                sum < 0 -> {
                    left++
                }

                else -> {
                    finalList.add(listOf(number, nums[left], nums[right]))
                    left++
                    right--

                    // We don't want to check duplicate left value.
                    // Notice: we are not changing `number` value when we are on while loop
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++
                    }
                }
            }
        }
    }

    return finalList
}
