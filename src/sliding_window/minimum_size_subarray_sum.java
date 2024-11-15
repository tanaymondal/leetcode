package sliding_window;

public class minimum_size_subarray_sum {
    // https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, array));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        // [2,3,1,2,4,3]
        for(int right=0; right<nums.length; right++) {
            sum = sum + nums[right];
            while(sum >= target) {
                length = Math.min(right - left + 1, length);
                sum = sum - nums[left];
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
