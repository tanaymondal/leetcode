package two_pointer


// https://leetcode.com/problems/3sum/
fun main() {
    val array = intArrayOf(3, -3, 0, -3, 6)
    println(threeSum(array))
}

fun threeSum(nums: IntArray): List<List<Int>> {

    nums.sort()

    val list = mutableListOf<List<Int>>()

    for(index in 0 until nums.size) {
        if(index > 0 && nums[index] == nums[index - 1]) {
            continue
        }

        var left = index + 1
        var right = nums.size - 1

        while(left < right) {
            val sum = nums[index] + nums[left] + nums[right]

            if(sum > 0) {
                right--
            } else if (sum < 0) {
                left++
            } else {
                val l = listOf(nums[index], nums[left], nums[right])
                list.add(l)

                left++

                while (nums[left] == nums[left - 1] && left < right) {
                    left++
                }

            }
        }
    }

    return list
}
