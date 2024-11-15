package kadanes_algorithm;

import java.util.Arrays;

public class maximum_sub_array {
    // https://leetcode.com/problems/maximum-subarray/

    public static void main(String[] args) {
        int[] nums = {-4, -1, 2, -7, -3, -4};

        System.out.println(kadanes(nums));
        System.out.println(Arrays.toString(slidingWindow(nums)));
    }

    private static int kadanes(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for(int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum = currentSum + num;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }


    // find sub array start and end index
    private static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        int maxR = 0;
        int maxL = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            int num = nums[R];
            if (currentSum < 0) {
                currentSum = 0;
                L = R;
            }

            currentSum = currentSum + num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxR = R;
                maxL = L;
            }
        }
        return new int[]{maxL, maxR};
    }

}
