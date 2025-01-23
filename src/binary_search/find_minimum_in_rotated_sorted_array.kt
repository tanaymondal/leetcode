package binary_search

fun main() {
    val array = intArrayOf(6,1,2,3,4,5)
    println(findMin(array))
}

fun findMin(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1

    // when mid is not the answer, then do < else use <=
    while (start < end) {
        // if start element is smaller than the end element, that means array is sorted
        if (nums[start] < nums[end]) {
            return nums[start]
        }

        // else array is not sorted, find mid of array
        val mid = (start + end) / 2
        // if mid-element is greater than = start element, that means, small element is on the right side of array
        if (nums[mid] >= nums[start]) {
            start = mid + 1
        } else {
            // else small element is on the left side of array. Note: set mid not mid - 1
            end = mid
        }
    }

    // start will always hold the answer
    return nums[start]
}