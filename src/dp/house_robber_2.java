package dp;

import java.util.Arrays;

public class house_robber_2 {
    static int[] nums = {1, 2, 3, 1};
    static int[] dp1 = new int[nums.length - 1];
    static int[] dp2 = new int[nums.length - 1];

    static int[] nums1 = new int[nums.length - 1];
    static int[] nums2 = new int[nums.length - 1];

    public static void main(String[] args) {
        System.out.println(rob());
    }

    static int rob() {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        for (int i = 1; i < nums.length; i++) {
            nums1[i - 1] = nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            nums2[i] = nums[i];
        }

        return Math.max(maxMoney(nums1, 0, dp1), maxMoney(nums2, 0, dp2));
    }

    static int maxMoney(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        } else if (dp[i] != -1) {
            return dp[i];
        } else {
            dp[i] = Math.max(nums[i] + maxMoney(nums, i + 2, dp), maxMoney(nums, i + 1, dp));
            return dp[i];
        }
    }
}
