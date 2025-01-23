package binary_search

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
fun main() {
    val array = intArrayOf(1)
    println(search(array, 3))
}

// Solve in 2 steps:
// 1. Use binary search to find the lowest element in a rotated array
// 2. Check on which side the target element is
// 3. Again use binary search to find the target element from the proper half of the array
fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    // when mid is not the answer, then do < else use <=
    while (start < end) {
        // if start element is smaller than the end element, that means array is sorted
        if (nums[start] < nums[end]) {
            break
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

    // current start is the smallest element index
    // setting end to array last index
    end = nums.size - 1

    // checking on which side target is. if it's first half, setting start to 0 and end to start - 1
    if (target > nums[end]) {
        end = start - 1
        start = 0
    }
    while (start <= end) {
        val mid = (start + end) / 2

        if (nums[mid] > target) {
            end = mid - 1
        } else if (nums[mid] < target) {
            start = mid + 1
        } else {
            return mid
        }
    }
    return -1
}